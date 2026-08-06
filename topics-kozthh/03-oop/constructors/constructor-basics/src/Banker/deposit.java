package Banker;
import bank.bop;

public class deposit extends bop {


    public deposit(String name, double balance) {
        super(name, balance);
    }

    public deposit(double balance) {
        super("",balance);
    }

   public double deposit(double balance) {

        if (balance < 0) {
            throw new IllegalArgumentException("insufficient balance");
        } else {
            double newBalance = getBalance() + balance;
            setBalance(newBalance);
            return newBalance;
        }
    }
}