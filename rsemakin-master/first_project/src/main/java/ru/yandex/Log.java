package ru.yandex;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
Log customize class
 */

public class Log {
    public static Logger logger = LogManager.getLogger(Log.class.getName());

    public void logMessages() {
        logger.debug("debug"); // all
        logger.info("info"); // except debug
        logger.warn("warn"); // except debug and info
        logger.error("error"); // except debug, info and warn
        logger.fatal("fatal"); // only fatal
        try {
            throw new Exception("test exception");
        } catch (Exception e) {
            logger.error("exception", e);
        }
    }
}