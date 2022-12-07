package src;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ResetDisplay implements DefaultView {
    public final MapView display;

    /**
     * Constructor for ResetDisplay
     * @param view - MapView object, using the MapView object allows for ease in updating the vbox aspect of the GUI.
     */
    public ResetDisplay(MapView view) {
        this.display = view;
    }

    /**
     * Updates the mapview and resets all changes to the vbox GUI and colours of the WorldMapView back to the default view.
     */
    public void updateDisplay() {
        App.world.setColors();
        VBox dis = (VBox) display.splitPane.getItems().get(0);
        dis.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int i = 0; i < dis.getChildren().size(); i++) {
            if (dis.getChildren().get(i) instanceof Label) {
                ((Label) dis.getChildren().get(i)).setTextFill(Color.BLACK);
            }
        }
    }
}
