import java.util.Scanner;

import shapes.options;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = true;

        while (exit) {
            System.out.println("Choose a shape:");
            System.out.println("1. Circle");
            System.out.println("2. Square");
            System.out.println("3. Triangle");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            if(choice == 4) {
                exit = false;
                continue;
            }
            options shapeOptions = new options(scanner, choice);

        }
        scanner.close();
    }
}
