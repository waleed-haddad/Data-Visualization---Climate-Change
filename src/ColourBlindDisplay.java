package src;

import java.util.*;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class ColourBlindDisplay implements DefaultView {
    public final MapView display;

    /**
     * Constructor for ColourBlindDisplay
     * @param view - MapView object, using the MapView object allows for ease in updating the vbox aspect of the GUI.
     */
    public ColourBlindDisplay(MapView view) {
        this.display = view;
    }

    /**
     * Updates the mapview to change the colour of the vbox GUI to white if switching from night-mode display to
     * colourblind. Updates the colours of the WorldMapView.
     */
    public void updateDisplay() {
        for (Map.Entry<String, Country> country : App.world.Countries.entrySet()) {
            if (country.getValue().color.equals(Color.rgb(51, 255, 174)) || country.getValue().color.equals(Color.rgb(180, 180, 200))) {
                country.getValue().color = Color.rgb(229, 204, 255);
            } else if (country.getValue().color.equals(Color.rgb(51, 255, 103)) || country.getValue().color.equals(Color.rgb(160, 160, 160))) {
                country.getValue().color = Color.rgb(204, 153, 255);
            } else if (country.getValue().color.equals(Color.rgb(0, 255, 0)) || country.getValue().color.equals(Color.rgb(100, 100, 100))) {
                country.getValue().color = Color.rgb(178, 114, 255);
            } else if (country.getValue().color.equals(Color.rgb(0, 204, 0)) || country.getValue().color.equals(Color.rgb(64, 64, 64))) {
                country.getValue().color = Color.rgb(153, 51, 255);
            } else if (country.getValue().color.equals(Color.rgb(0, 153, 0)) || country.getValue().color.equals(Color.rgb(35, 35, 35))) {
                country.getValue().color = Color.rgb(127, 0, 255);
            }
        }
        VBox dis = (VBox) display.splitPane.getItems().get(0);
        dis.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int i = 0; i < dis.getChildren().size(); i++) {
            if (dis.getChildren().get(i) instanceof Label) {
                ((Label) dis.getChildren().get(i)).setTextFill(Color.BLACK);
            }
        }
    }
}
