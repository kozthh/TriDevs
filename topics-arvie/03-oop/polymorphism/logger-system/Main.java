import logger.ConsoleLog;
import logger.FileLog;
import logger.LoggerSwitcher;
import logger.Logging;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose logger (console, file, db): ");
        String choice = scanner.nextLine();

        LoggerSwitcher switcher = new LoggerSwitcher();
        Logging logger;
        switch (choice == null ? "" : choice.toLowerCase()) {
            case "file":
                logger = new FileLog();
                break;
            case "db":
                logger = switcher.selectLogger("db");
                break;
            case "console":
            default:
                logger = new ConsoleLog();
                break;
        }

        logger.input();
    }
}