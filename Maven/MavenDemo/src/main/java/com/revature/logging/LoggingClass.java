package com.revature.logging;

import org.apache.log4j.Logger;

public class LoggingClass {
	
	private static Logger log = Logger.getRootLogger();
	
	public void allTheLogs() {
		log.trace("Trace message");
		log.debug("debug message");
		log.info("Info message");
		log.warn("Warn message");
		log.error("error message");
		log.fatal("fatal message");
		
	}
	
	public void giveFatal(Throwable t) {
		log.fatal(t.getMessage(), t);
	}
	
}
