package bank;

public class bop {

    private String name ; //no restriction
    private double balance; // it cannot be negative

    public bop(String name, double balance) {
        this.name = name;
        if(balance >= 0) {
            this.balance = balance;
        }
        else {throw new IllegalArgumentException("balance cannot be negative");}
    }

    public bop(String name) {
        this(name, 0.0);
    }

    public String getName() {
        return name; // Return the name
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }
    public void setBalance(double balance) {
        if(balance >= 0) {
            this.balance = balance;
        }
        else {throw new IllegalArgumentException("balance cannot be negative");}
    }

}
