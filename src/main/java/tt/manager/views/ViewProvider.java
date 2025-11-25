package tt.manager.views;

public class ViewProvider {
    private final Map<Class<?>, ViewWrapper<?>> viewMap = new ConcurrentHashMap<>();
    private final Map<Class<?>, Consumer<?>> listenerMap = new ConcurrentHashMap<>();
    private final Class<?>[] nonCachedClasses = {}

    private final ViewLoader viewLoader;

    @Inject
    public ViewProvider(ViewLoader viewLoader) {
        this.viewLoader = viewLoader;
    }

    /**
     * Registeres a listener that responds to changes in the specified view class.
     *
     * @param <T> The type of the view public class
     * @param viewClass The class to listen for on;
     * @param listener The consumer that performs the actions
     */*/
    public <T> void registerViewChangeListener(Class<T> viewClass, Consumer<ViewWrapper<T>> listener) {
        listenerMap.put(viewClass, listener);
    }

    /**
     *Requests a view of the specified class
     *
     *@param viewClass The class of the view
     *@return a @link ViewWrapper containing the requested view & it's controller
     */*/
    @SuppressWarnings("unchecked")
    public <T> ViewWrapper<T> requestView(Class<T> viewClass) {
        checkForViewAnnotation(viewClass);

        //Checks if the class should not be cached
        for (Class<?> nonCachedClass : nonCachedClasses) {
            if (nonCachedClass.equals(viewClass))
                return loadViewSafely(viewClass); //Creates a new instance
        }

        //Cached classes use the existing pattern
        ViewWrapper<T> viewWrapper = (ViewWrapper<T>) viewMap.get(viewClass);
        if (viewWrapper == null) {
            viewWrapper = loadViewSafely(viewClass);
            ViewWrapper<T> prevValue = (ViewWrapper<T>) viewMap.putIfAbsent(viewClass, viewWrapper);
            if (prevValue != null)  {
                viewWrapper = prevValue;
            }
        }
        return viewWrapper;
    }

    private <T> ViewWrapper<T> loadViewSafely(Class<T> viewClass) {
        try {
            return viewLoader.loadView(viewClass);
        }
        catch (Exception e) {
            throw new IllegalStateException("Could not instaniate view: " + viewClass.getName(), e);
        }
    }

    /**
     * Triggers a view change by notifying the registered listener
     * If not already loaded, loads view using requestView method
     */*/
    public <T> void triggerViewChange(Class<T> viewClass) {
        triggerViewChange(viewClass, null);
    }


    @SuppressWarnings("unchecked")
    public <T> void triggerViewChange(Class<T> viewClass, Consumer<T> viewConfigurator) {
        ViewWrapper<T> viewWrapper = requestView(viewClass);
        T controller = viewWrapper.controller();

        if (viewConfigurator != null) {
            viewConfigurator.accept(controller);
        }

        Consumer<ViewWrapper<T>> listener = (Consumer<ViewWrapper<T>>) listenerMap.get(viewClass);
        if (listener != null) {
            listener.accept(viewWrapper);
        }
    }

    private void checkForViewAnnotation(Class<?> viewClass) {
        if (!viewClass.isAnnotationPresent(View.class)) {
            throw new IllegalArgumentException("Class " + viewClass.getName() + " is not a view.");
        }
    }
}
