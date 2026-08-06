package Vault;

class account {
    private String name;
    private int id;
    private double balance;

    account(String name, int id) {
        this.name = name;
        this.id = id;
        this.balance = 0.0;
    }

    String getName() {
        return name;
    }

    int getId() {
        return id;
    }

    double getBalance() {
        return balance;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
        } else {
            throw new IllegalArgumentException("Insufficient balance");
        }
    }
}