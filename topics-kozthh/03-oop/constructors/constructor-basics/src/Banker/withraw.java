package Banker;
import bank.bop;

public class withraw extends bop {

    public withraw(String name, double balance) {
        super(name, balance);
    }

    public withraw(double balance) {
        super("",balance);
    }

    public void withdraw(double balance) {
        if(balance >= 0) {
            this.setBalance(this.getBalance() - balance);
        }
        else {throw new IllegalArgumentException("insufficient balance");}
    }
}
