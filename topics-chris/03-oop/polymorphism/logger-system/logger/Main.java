package logger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();

        Logging logger;
        switch (choice == null ? "" : choice.toLowerCase()) {
            case "file":
                logger = new FileLog();
                break;
            case "db":
                logger = new DbLog();
                break;
            case "console":
            default:
                logger = new ConsoleLog();
                break;
        }

        logger.input();
    }
}
