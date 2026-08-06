package Vault;

import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String name = sc.nextLine();

        System.out.print("Please enter your ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        account acc = new account(name, id);

        boolean exit = false;
        while (!exit) {
            System.out.print("1. Deposit \n 2. View \n 3. Withdraw \n 4. Quit\n");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Please enter your Deposit amount: ");
                    double amount = sc.nextDouble();
                    acc.deposit(amount);

                    System.out.print("your new balance: " + acc.getBalance());
                    break;

                case 2:
                    System.out.print("your balance is " + acc.getBalance());
                    break;

                case 3:
                    System.out.print("please enter your Withdraw amount: ");
                    double amount2 = sc.nextDouble();
                    acc.withdraw(amount2);
                    System.out.println("you successfully withdraw the amount " + amount2);
                    break;

                case 4:
                    System.out.println("bye");
                    exit = true;
                    break;

                default:
                    System.out.println("invalid choice");
            }
        }

        sc.close();
    }
}