package src;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AccessibilityButton extends UIButton{

    MapView mapView;
    Button defaultView;
    Button colourBlind;
    Button nightMode;


    /**
     * Constructor for Accessibility Button
     * @param mapView - The mapview is required in order to process the handler for the button
     */
    public AccessibilityButton(MapView mapView) {
        this.mapView = mapView;
        this.defaultView = new Button("Default View");
        this.colourBlind = new Button("Colour Blind View");
        this.nightMode = new Button("Night Mode");

    }
}
