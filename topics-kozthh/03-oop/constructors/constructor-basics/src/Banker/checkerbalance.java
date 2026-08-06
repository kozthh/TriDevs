package Banker;
import bank.bop;

public class checkerbalance extends bop {
    bop money;

    public checkerbalance(String name, double balance) {
        super(name, balance);
    }

    public checkerbalance() {
        super("",0.0);
    }
    public void display() {
        System.out.println("Name: " + this.getName());
        System.out.println("Balance: " + this.getBalance());
    }
}
