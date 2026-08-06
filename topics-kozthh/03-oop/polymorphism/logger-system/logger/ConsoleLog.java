package logger;

public class ConsoleLog extends Logging {

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(ConsoleLog.class.getName());

	@Override
	public void input() {
		LOGGER.info("Console logger selected");
	}
}
