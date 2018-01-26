//LoggingClass.java

package com.revature.logging;

import org.apache.log4j.Logger;

public class LoggingClass {
	
	private static Logger log = Logger.getRootLogger();
	
	public void allTheLogs() {
		log.trace("trace message");
		log.debug("debug message");
		log.info("info message");
		log.warn("warn message");
		log.error("error message");
		log.fatal("fatal message");
	}
	
	//Message just for when something goes really wrong
	//Also works with an exception
	public void giveFatal(Throwable t) {
		log.fatal(t.getMessage(), t);		//Overloaded form. t could also be an exception and print stack trace
	}
}
