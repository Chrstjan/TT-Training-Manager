package tt.manager.views;

import javafx.scene.Parent;

/**
 * A record that bundles JavaFX parent node and controller
 *
 * @param parent The root node of the FXML scene graph
 * @param controller The controller for handling the events & interactions of the FXML view
 * @param <T> The type of the controller
 */*/
public record ViewWrapper<T>(Parent parent, T controller) {}
