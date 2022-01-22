package ru.job4j.design.lsp;

public class Loan {

    public void check(Borrower borrower) {
        if (!borrower.getStatus() || borrower.getBalance() < 1000) {
            throw new IllegalArgumentException("Borrower cant afford it");
        }
    }

    public void giveLoan(Borrower borrower, int required) {
        check(borrower);
        borrower.setBalance(borrower.getBalance() + required);
    }
}

class Mortgage extends Loan {

    public void giveLoan(Borrower borrower, int required) {
        borrower.setBalance(borrower.getBalance() + required);
    }

}

class Borrower {
    private int balance;
    private boolean status;

    public Borrower(int balance, boolean status) {
        this.balance = balance;
        this.status = status;
    }

    public int getBalance() {
        return balance;
    }

    public boolean getStatus() {
        return status;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}