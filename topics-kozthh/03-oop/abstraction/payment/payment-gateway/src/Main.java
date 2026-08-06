//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

import payments.mode;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        mode paymentMode = new mode();


        System.out.println("Select payment method: \n 1. gcash \n 2. maya \n 3. uniondigital \n 4. cash \n 5. exit");
        int choice  = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter payment amount: ");
                double amount = scanner.nextDouble();
                paymentMode.payment("gcash", amount);

                break;
            case 2:
                System.out.print("Enter payment amount: ");
                amount = scanner.nextDouble();
                paymentMode.payment("maya", amount);
                break;
            case 3:
                System.out.print("Enter payment amount: ");
                amount = scanner.nextDouble();
                paymentMode.payment("uniondigital", amount);
                break;
            case 4:
                System.out.print("Enter payment amount: ");
                amount = scanner.nextDouble();
                paymentMode.payment("cash", amount);
                break;
            case 5:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        scanner.close();

    }
}