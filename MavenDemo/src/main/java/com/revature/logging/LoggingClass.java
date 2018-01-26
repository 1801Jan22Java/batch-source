package com.revature.logging;

import org.apache.log4j.Logger;

public class LoggingClass {
<<<<<<< HEAD

	private static Logger log = Logger.getRootLogger();
	
	public void allTheLogs() {
=======
	
	private static Logger log = Logger.getRootLogger();
	
	public void allTheLogs(){
>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
		log.trace("trace message");
		log.debug("debug message");
		log.info("info message");
		log.warn("warn message");
		log.error("error message");
		log.fatal("fatal message");
	}
	
<<<<<<< HEAD
	public void giveFatal(Throwable t) {
		log.fatal(t.getMessage());
	}
	
=======
	public void giveFatal(Throwable t){
		log.fatal(t.getMessage(),t);
	}

>>>>>>> 39c64c4d101d1e56e70955d3bd4aa54d6f94e18e
}
