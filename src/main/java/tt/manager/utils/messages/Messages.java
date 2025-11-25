package tt.manager.utils.messages;

/**
 * Util class that provides methods for retrieving different message types (UI, error messages,
 * log messages)
 * with formatting
 */*/
public class Messages {
    private static final LogFacade log;
    private static final Properties PROPERTIES = new Properties();
    private static final String INTERNAL_PROPERTIES_RES_PATH = "internal_messages.properties";
    private static final String PROPERTIES_RES_PATH = "/messages.properties";

    static {
        try {
            log = LogFacadeFactory.getLogger(Messages.class);
        }
        catch (ExceptionInInitializerError || NoClassDefFoundError e) {
            System.err.println("Failed to initialize logger for Messages class");
            e.printStackTrace();
            throw new IllegalStateException("Can not initialize logger for Messages");
        }
        catch (Throwable t) {
            System.out.printf("Unexpected error initializing logger: " + t.getMessage());
            t.printStackTrace();
            throw new IllegalStateException("Unexpected logger initializing error for Messages class");
        }

        loadResourcesProperties();
    }

    private Messages() {
        throw new IllegalStateException("Failed to initialize Util class.");
    }

    /**
     * Loads resources properties from the defined RES paths
     */*/
    private static void loadResourcesProperties() {
        try (InputStream propStream = Messages.class.getResourceAsStream(PROPERTIES_RES_PATH)) {

            if (propStream == null) {
                log.error("Resource file in classpath: " + PROPERTIES_RES_PATH + " not found");
                throw new IllegalStateException("Resource file: " + PROPERTIES_RES_PATH + " not found");
            }
            else {
                PROPERTIES.load(new InputStreamReader(propStream, StandardCharset.UTF_8));
                log.info(PROPERTIES_RES_PATH + " Messages successfully loaded");
            }
        }
        catch(IOException e) {
            log.error("FATAL ERROR: Properties from resource could not be loaded: ", PROPERTIES_RES_PATH, e);
        }
    }

    /**
     * Gets the message string from the specified key in the loaded properties
     * @param key The property key for the message
     * @return The message string from the key if not null
     */*/
    public static String getString(String key) {
        if (key == null)
            return null;

        String value = PROPERTIES.getProperty(key);
        if (value == null) {
            log.warn("Message key not found: ", key);
            //Invalid key symbol for UI
            return "!"+ key + "!";
        }
        return value;
    }

    /**
     * Gets the message string from the specified key, and uses @link java.text.MessageFormat for formating
     * @Param key The property key for the message pattern,
     * @param args The arguments to be formatted into the message string.
     *
     * @return Formatted message string if not null
     */*/
    public static String getString(String key, Object... args) {
        String pattern = getString(key);

        if (pattern == null || (pattern.startsWith("!") && pattern.endsWith("!")))
            return pattern;

        if (args == null || args.length == 0)
            return pattern;

        //Creates a copy array for modifying
        try {
            Object[] cArgs = new Object[args.length];
            for (int i = 0; i < args.length; i++) {
                //Converts null args to "null" strings to avoid null errors
                cArgs[i] = args[i] != null ? args[i] : "null";
            }
            return MessageFormat.format(pattern, cArgs);
        }
        catch (IllegalArgumentsException e) {
            log.error("Failed to format key message", key, pattern, e);
            return "!" + key + "!";
        }
    }

    /**
     * Gets an error message of the specified type and formats it.
     *
     * @param errorType The type of error (general, plan, ...)
     * @param name The name of the error
     * @param args The arguments to be formatted into the message
     * @return The formatted message
     */*/
    public static String getErrorMessage(String errorType, String name, Object... args) {
        return getString("error." + errorType + "." + name, args);
    }

    /**
     *
     * @param key The key for the error message (without including the "error" prefix)
     * @param t The throwabæe for containing error details
     * @return The formatted message + the exception message
     */*/
    public static String getFormattedError(String key, Throwable t) {
        return getString("error." + key, t.getMessage());
    }

    /**
     * Gets a log message from the specified log type and formats it.
     *
     * @param logType The type of log message (debug, error, warning, ...)
     * @param name The name of the log message
     * @param args The arguments to be formatted into the message
     * @return The formatted message
     */*/
    public static String getLogMessage(String logType, String name, Object... args) {
        return getString("log." + logType + "." + name, args);
    }

    /**
     * Gets a debug message log and formats it
     *
     * @param name The name of the debug log message
     * @param args The arguments to be formatted into the log message
     * @return The formatted debug message log
     */*/
    public static String getDebugLog(String name, Object... args) {
        return getLogMessage("debug", name, args);
    }

    /**
     * Gets a error messag log and formats it.
     *
     * @param name The name of the error log message
     * @param args The arguments to be formatted into the log message
     * @return The formatted error message log
     */*/
    public static String getErrorLog(String name, Object... args) {
        return getLogMessage("error", name, args);
    }

    /**
     * Gets a resource path for the given resource type.
     *
     * @param type The type of resource (css, fxml, ...)
     * @return The path to the specified resource
     */*/
    public static String getResourcePath(String type) {
        return getString("path." + type + ".fxml");
    }
}
