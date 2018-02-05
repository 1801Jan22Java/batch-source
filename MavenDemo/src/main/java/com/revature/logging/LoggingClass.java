package com.revature.logging;

import org.apache.log4j.Logger;

public class LoggingClass
{
	private static Logger log = Logger.getRootLogger();

	public void allTheLogs()
	{
		log.trace("Trace Message!");
		log.debug("Debug Message!");
		log.info("Info Message!");
		log.warn("Warn Message!");
		log.error("Error Message!");
		log.fatal("Fatal Message!");
	}
	
	public void giveFatal(Throwable t)
	{
		log.fatal(t.getMessage(),t);
	}
}
