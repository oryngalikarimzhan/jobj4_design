package ru.job4j.io;

import java.io.*;

public class Analizy {
    public static void unavailable(String source, String target) throws IOException {
        StringBuilder log = new StringBuilder();
        try (BufferedReader in =
                     new BufferedReader(
                             new FileReader(source))) {
            try (PrintWriter out = new PrintWriter(
                    new BufferedOutputStream(
                            new FileOutputStream(target)))) {
                String line;
                while ((line = in.readLine()) != null) {
                    String[] split = line.split(" ");
                    if (log.length() == 0
                            && (split[0].equals("500") || split[0].equals("400"))) {
                        log = new StringBuilder(split[1]);
                    } else if (log.length() != 0
                            && (split[0].equals("200") || split[0].equals("300"))) {
                        log.append(";").append(split[1]).append(";");
                        out.println(log);
                        log = new StringBuilder();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        unavailable("./data/server.log", "./data/unavailable.csv");
    }
}
