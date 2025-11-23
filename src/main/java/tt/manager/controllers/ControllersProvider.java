package tt.manager.controllers;

import javafx.scene.Node;
import javafx.scene.HBox;
import javafx.scene.layout.Region;

public interface ControllersProvider() {

    /*
     * Creates a @link #createContainer(Node) container to place the control nodes
     * @return a @link Region that wraos the controls returned by @link #controls()
    */
    default Region controlsContainer() {
        return createContainer(controls());
    }

    /*
     * Factory method for creating a wrapper contrainer around controls (@link Region, @code FlowPane, @code GridPane ...)
     * @param controls control nodes to place in the container
     * @return a @link Region nodes wrapper
    */
    default Region createContainer(Node... controls) {
        return new HBox(controls);
    }

    //Alignment value inside of parent layout
    Alignment alignment();

    /*
     * An array of control nodes for the UI
     * @return an array of @link Node
    */
    Node[] controls();

    enum Alignment {
        LEFT,
        CENTER,
        RIGHT,
    }
}
