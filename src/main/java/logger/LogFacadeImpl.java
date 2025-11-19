package logger;

import org.slf4j.Logger;

public class LogFacadeImpl implements LogFacade {

    private final Logger slf4jLogger;

    LogFacadeImpl(Logger slf4jLogger) {
        if (slf4jLogger == null)
            throw new IllegalArgumentException("Underlying SLF4J Logger must not be null.");
        this.slf4jLogger = slf4jLogger;
    }

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
}
