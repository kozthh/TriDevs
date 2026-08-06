package bank; 

public class banking { 

private String name; 
private double balance; 
private int pin; 

public banking(String name, double balance, int pin) {
     this.name = name; 
     this.balance = balance; 
     this.pin = pin; 
}

public String getName() {
     return name;
}

public void setName(String name) {
     this.name = name;
}

public double getBalance() {
     return balance;
}

public void setBalance(double balance) {
     this.balance = balance;
}

public int getPin() {
     return pin;
}

public void setPin(int pin) {
     this.pin = pin;
}


}