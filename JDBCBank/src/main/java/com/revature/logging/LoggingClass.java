package com.revature.logging;

import org.apache.log4j.Logger;

public class LoggingClass {

	private static Logger log = Logger.getRootLogger();
	
	public void logDebug(String msg) {
		log.debug(msg);
	}
	
	public void logInfo(String infoMsg) {
		log.info(infoMsg);
	}
	
	public void logWarn(Throwable t) {
		log.warn(t.getMessage(), t);
	}
	
	public void logError(Throwable t) {
		log.error(t.getMessage(), t);
	}
	
	public void logFatal(Throwable t) {
		log.error(t.getMessage(), t);
	}
}
