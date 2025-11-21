package logger;

import org.slf4j.Logger;

public class LogFacadeImpl implements LogFacade {

    private final Logger slf4jLogger;

    LogFacadeImpl(Logger slf4jLogger) {
        if (slf4jLogger == null)
            throw new IllegalArgumentException("Underlying SLF4J Logger must not be null.");
        this.slf4jLogger = slf4jLogger;
    }

    //#region Trace

    @Override
    public void trace(String message) {
        slf4jLogger.trace(message);
    }

    @Override
    public void trace(String format, Object arg) {
        slf4jLogger.trace(format, arg);
    }

    @Override
    public void trace(String format, Object arg1, Object arg2) {
        slf4jLogger.trace(format, arg1, arg2);
    }

    @Override
    public void trace(String format, Object... args) {
        slf4jLogger.trace(format, args);

    }

    @Override
    public void trace(String message, Throwable t) {
        slf4jLogger.trace(message, t);
    }

    //#endregion Trace

    @Override
    public void debug(String message) {
        slf4jLogger.debug(message);
    }

    @Override
    public void debug(String format, Object arg) {
        slf4jLogger.debug(format, arg);
    }


    @Override
    public void debug(String format, Object arg1, Object arg2) {
        slf4jLogger.debug(format, arg1, arg2);
    }

    @Override
    public void debug(String format, Object... args) {
        slf4jLogger.debug(format, args);
    }

    @Override
    public void debug(String message, Throwable t) {
        slf4jLogger.debug(message, t);
    }

    @Override
    public void info(String message) {
        slf4jLogger.info(message);
    }

    @Override
    public void info(String format, Object arg) {
        slf4jLogger.info(format, arg);
    }

    @Override
    public void info(String format, Object arg1, Object arg2) {
        slf4jLogger.info(format, arg1, arg2);
    }

    @Override
    public void info(String format, Object... args) {
        slf4jLogger.info(format, args);
    }

    @Override
    public void info(String message, Throwable t) {
        slf4jLogger.info(message, t);
    }

    @Override
    public void warning(String message) {
        slf4jLogger.warning(message);
    }

    @Override
    public void warning(String format, Object arg) {
        slf4jLogger.warning(format, arg);
    }

    @Override
    public void warning(String format, Object arg1, Object arg2) {
        slf4jLogger.warning(format, arg1, arg2);
    }

    @Override
    public void warning(String format, Object... args) {
        slf4jLogger.warning(format, args);
    }

    @Override
    public void warning(String message, Throwable t) {
        slf4jLogger.warning(message, t);
    }

    @Override
    public void error(String message) {
        slf4jLogger.error(message);
    }

    @Override
    public void error(String format, Object arg) {
        slf4jLogger.error(format, arg);
    }

    @Override
    public void error(String format, Object arg1, Object arg2) {
        slf4jLogger.error(format, arg1, arg2);
    }

    @Override
    public void error(String format, Object... args) {
        slf4jLogger.error(format, args);
    }

    @Override
    public void error(String message, Throwable t) {
        slf4jLogger.error(message, t);
    }
}
