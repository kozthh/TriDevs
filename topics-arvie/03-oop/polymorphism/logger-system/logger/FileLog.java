package logger;

public class FileLog extends Logging {

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(FileLog.class.getName());

	@Override
	public void input() {
		LOGGER.info("File logger selected");
	}
}
