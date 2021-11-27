package ru.job4j.jdbc;

import java.io.FileReader;
import java.sql.*;
import java.util.Properties;
import java.util.StringJoiner;

public class TableEditor implements AutoCloseable {

    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName(properties.getProperty("driver"));
        String url = properties.getProperty("url");
        String login = properties.getProperty("login");
        String password = properties.getProperty("password");
        connection = DriverManager.getConnection(url, login, password);
    }

    public void createTable(String tableName) throws Exception {
        String sql = String.format(
                "create table if not exists %s();", tableName
        );
        execute(sql, tableName);
    }

    public void dropTable(String tableName) throws Exception {
        String sql = String.format(
                "drop table if exists %s;", tableName
        );
        execute(sql, tableName);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = String.format(
                "alter table if exists %s add column if not exists %s %s;",
                tableName, columnName, type
        );
        execute(sql, tableName);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = String.format(
                "alter table if exists %s drop column if exists %s;",
                tableName, columnName
        );
        execute(sql, tableName);
    }

    public void renameColumn(
            String tableName, String columnName, String newColumnName) throws Exception {
        String sql = String.format(
                "alter table if exists %s rename column %s to %s;",
                tableName, columnName, newColumnName
        );
        execute(sql, tableName);
    }

    public void execute(String sql, String tableName) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
            System.out.println(getTableScheme(connection, tableName));
        }
    }

    public static String getTableScheme(Connection connection, String tableName) throws Exception {
        var rowSeparator = "-".repeat(30).concat(System.lineSeparator());
        var header = String.format("%-15s|%-15s%n", "NAME", "TYPE");
        var buffer = new StringJoiner(rowSeparator, rowSeparator, rowSeparator);
        buffer.add(header);
        try (var statement = connection.createStatement()) {
            var selection = statement.executeQuery(String.format(
                    "select * from %s limit 1", tableName
            ));
            var metaData = selection.getMetaData();
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                buffer.add(String.format("%-15s|%-15s%n",
                        metaData.getColumnName(i), metaData.getColumnTypeName(i))
                );
            }
        }
        return buffer.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.load(new FileReader("./data/app.properties"));
        TableEditor tableEditor = new TableEditor(properties);
        tableEditor.createTable(properties.getProperty("create"));
        tableEditor.addColumn(properties.getProperty("create"),
                properties.getProperty("column"), properties.getProperty("type"));
        tableEditor.renameColumn(properties.getProperty("create"),
                properties.getProperty("column"), properties.getProperty("newname"));
    }
}
