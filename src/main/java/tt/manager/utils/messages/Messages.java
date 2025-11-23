package tt.manager.utils.messages;

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
}
