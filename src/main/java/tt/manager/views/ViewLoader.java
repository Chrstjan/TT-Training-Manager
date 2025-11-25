package tt.manager.views;

public class ViewLoader {
    private final Injector injector;

    @Inject
    public ViewLoader(Injector injector) {
        this.injector = injector;
    }

    /**
     * Loads a view and it's controller from an FXML file associated with the specified class.
     *
     * @param <T> The type of controller
     * @param c The class of the controller
     * @return a @link ViewWrapper containing the loaded view & it's controller
     *
     */*/
    public <T> ViewWrapper<T> loadView(Class<T> c) {
        FXMLLoader loader = new FXMLLoader();

        String name = c.getSimpleName().replace("Controller", "");
        URL location = c.getResource(name + ".fxml");

        if (location == null) {
            throw new IllegalStateException(MessageFormat.format("FXML File not found for class: {0}", c));
        }

        loader.setLocation(location);
        loader.setControllerFactory(injector::getInstance);

        //Sets the resource bundle
        ResourceBundle bundle = new MessageResourceBundles();
        loader.setResources(bundle);

        try {
            Parent parent = loader.load();
            T controller = loader.getController();
            return new ViewWrapper<>(parent, controller);
        }
        catch (IOException e) {
            throw new IllegalStateException(MessageFormat.format("FXML for class {0} could not be loaded.", c), e);
        }
    }
}
