import java.util.Scanner;
import bank.bop;
import Banker.deposit;
import Banker.withraw;
import Banker.checkerbalance;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        bop bank = null;
        boolean exit = true;

        while (exit) {
            System.out.println("----------Bank System---------- \n 1. Create Account \n 2. Deposit \n 3. Withdraw \n 4. Check Balance \n 5. Exit");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    bank = new bop("John Doe", 1000.0);

                    break;

                case 2:
                    if (bank == null) {
                        System.out.println("No account found. Create an account first (choose 1).");
                    } else {
                        System.out.print("Enter deposit amount: ");
                        double amt = sc.nextDouble();
                        deposit dep = new deposit(bank.getName(), bank.getBalance());
                        bank.setBalance(dep.deposit(amt));
                    }

                    break;

                case 3:
                    if (bank == null) {
                        System.out.println("No account found. Create an account first (choose 1).");
                    } else {
                        System.out.print("Enter withdrawal amount: ");
                        double amt = sc.nextDouble();
                        withraw with = new withraw(bank.getName(), bank.getBalance());
                        with.withdraw(amt);
                        bank.setBalance(with.getBalance());
                    }
                    break;

                case 4:
                    if (bank == null) {
                        System.out.println("No account found. Create an account first (choose 1).");
                    } else {
                        checkerbalance check = new checkerbalance();
                        check.display();
                    }
                    break;

                case 5:
                    exit = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;

            }
        }
    }
}