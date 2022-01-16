package ru.job4j.srp;

import java.util.*;


public class Bank {
    private final String name = "ORYN Bank";
    private final Calendar founded = new GregorianCalendar(2021, Calendar.FEBRUARY, 2);
    private final Person founder = new Person("Oryngali");
    private Set<Person> employees = new HashSet<>();
    private List<Account> accounts = new ArrayList<>();

    public void addEmployee(Person employee) {
        employees.add(employee);
    }

    public Set<Person> getEmployees() {
        return employees;
    }

    public List<Account> getAllAccounts() {
        return accounts;
    }

    public Account getAccount(Person person) {
        for (Account account : accounts) {
            if (account.getPerson().equals(person)) {
                return account;
            }
        }
        return null;
    }
}



