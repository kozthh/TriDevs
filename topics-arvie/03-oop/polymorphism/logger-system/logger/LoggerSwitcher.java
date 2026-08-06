package logger;

public class LoggerSwitcher {

    public Logging selectLogger(String type) {
        if (type == null) {
            return new ConsoleLog();
        }

        switch (type.toLowerCase()) {
            case "file":
                return new FileLog();
            case "db":
                return new DbLog();
            case "console":
            default:
                return new ConsoleLog();
        }
    }
}


