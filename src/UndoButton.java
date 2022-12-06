package src;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class UndoButton extends UIButton{
    TextField textField;
    MapView mapView;

    Button undo;
    /**
     * Constructor for UndoButton
     * @param mapView - The mapview is required in order to process the handler for the button
     */
    public UndoButton(MapView mapView) {
        this.mapView = mapView;
        this.button = new Button("Undo");
    }

}
