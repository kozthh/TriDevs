package logger;

class DbLog extends Logging {

	private static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger(DbLog.class.getName());

	@Override
	public void input() {
		LOGGER.info("Database logger selected");
	}
}
