package tech.pathtoprogramming.lombokdemo;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;

public class LogTestUtil {
	    public static ListAppender<ILoggingEvent> getListAppenderForClass(Class loggingClass) {
	        Logger logger = (Logger) LoggerFactory.getLogger(loggingClass);

	        ListAppender<ILoggingEvent> loggingEventListAppender = new ListAppender<>();
	        loggingEventListAppender.start();

	        logger.addAppender(loggingEventListAppender);

	        return loggingEventListAppender;
	    }
	}
