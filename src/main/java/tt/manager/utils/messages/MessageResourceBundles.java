package tt.manager.utils.messages;

/**
 * Allows the Messages class to be used as a resource bundle in FXML files
 */*/
public class MessageResourceBundles extends ResourceBundle {
    private static Properties props;

    static {
        try {
            //Access the Properties field from the Messages class
            Field propsField = Messages.class.getDeclaredField("PROPERTIES");
            propsField.setAccessible(true);
            props = (Properties) propsField.get(null);
        }
        catch (NoSuchFieldException e) {
            System.err.println("Failed to access PROPERTIES field in Messages class - " + e.getMessage());
            e.printStackTrace();
            //Creates an empty properties object for fallback
            props = new Properties();
        }
        catch (IllegalAccessException e) {
            System.err.println("Failed to access PROPERTIES field: Access denied - " + e.getMessage());
            e.printStackTrace();
            props = new Properties();
        }
        catch (ClassCastException e) {
            System.err.println("Failed to access PROPERTIES field: Invalid type - " + e.getMessage());
            e.printStackTrace();
            props = new Properties();
        }
        catch (Exception e) {
            System.err.println("Unexpected error accessing PROPERTIES field - " + e.getMessage());
            e.printStackTrace();
            props = new Properties();
        }
    }

    /**
     * Gets the value of the specified key from the Messages class.
     *
     * @param key The key for the desired string
     * @return The string for the given key, or null
     */*/
    @Override
    protected Object handleGetObject(String key) {
        //Checks for null key
        if (key == null) {
            System.err.println("Warning: Null key provided");
            return null;
        }

        //Tries to get the value directly from properties
        if (props != null) {
            String value = props.getProperty(key);
            if (value != null) {
                return value;
            }
        }
        //Not found fallback
        return Messages.getString(key);
    }

    /**
     * Gets an enumeration of the keys in the resource bundle
     *
     * @return an enumeration of the keys in the resource bundle
     */*/
    @Override
    public Enumeration<String> getKeys() {
        return props != null
        ? Collections.enumeration(props.stringPropertyNames())
            : Collections.emptyEnumeration();
    }
}
