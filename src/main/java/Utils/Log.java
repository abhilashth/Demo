package Utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.testng.Reporter;

/**
 * Created by Abhilash Thaduka on 8/9/2016.
 */
public class Log {

    private static Logger logger = Logger.getLogger(Log.class);


    public static void info(String message) {
        logger.log(Log.class.getCanonicalName(), Level.INFO, message, null);
        reporterLog(message);
    }


    public static void error(String message) {
        logger.log(Log.class.getCanonicalName(), Level.ERROR, message, null);
        reporterLog(message);
    }

    public static void debug(String message) {
        logger.log(Log.class.getCanonicalName(), Level.DEBUG, message, null);
    }

    private static void reporterLog(final String message) {
        Reporter.log(message.toString());
    }
}
