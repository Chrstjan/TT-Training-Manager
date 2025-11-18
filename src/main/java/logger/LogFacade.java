package logger;

public interface LogFacade {

    void trace(String message);

    void trace(String format, Object arg);

    void trace(String format, Object arg1, Object arg2);

    void trace(String format, Object... args);

    void trace(String message, Throwable t);

    void debug(String message);

    void debug(String format, Object arg);

    void debug(String format, Object arg1, Object arg2);

    void debug(String format, Object... args);

    void debug(String message, Throwable t);

    void info(String message);

    void info(String format, Object arg);

    void info(String format, Object arg1, Object arg2);

    void info(String format, Object... args);

    void info(String message, Throwable t);

    void warning(String message);

    void warning(String format, Object arg);

    void warning(String format, Object arg1, Object arg2);

    void warning(String format, Object... args);

    void warning(String message, Throwable t);

    void error(String message);

    void error(String format, Object arg);

    void error(String format, Object arg1, Object arg2);

    void error(String format, Object... args);

    void error(String message, Throwable t);
}
