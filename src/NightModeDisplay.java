package src;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;
import src.CommandOperation.CommandHistory;
import src.CommandOperation.MapEditor;

import java.util.Map;

public class NightModeDisplay implements DefaultView {
    public final MapView display;
    public final MapEditor editor;
    public final CommandHistory history;
    public final WorldMapView worldMapView;

    public NightModeDisplay(MapView view) {
        this.display = view;
        this.worldMapView = view.worldMapView;
        this.editor = new MapEditor(view);
        this.history = new CommandHistory();
    }

    public MapView updateDisplay() {
        for (Map.Entry<String, Country> country : App.world.Countries.entrySet()) {
            if (country.getValue().color.equals(Color.rgb(51, 204, 255)) || country.getValue().color.equals(Color.rgb(229, 204, 255))) {
                country.getValue().color = Color.rgb(180, 180, 200);
            } else if (country.getValue().color.equals(Color.rgb(51, 153, 255)) || country.getValue().color.equals(Color.rgb(204, 153, 255))) {
                country.getValue().color = Color.rgb(160, 160, 160);
            } else if (country.getValue().color.equals(Color.rgb(0, 0, 255)) || country.getValue().color.equals(Color.rgb(178, 114, 255))) {
                country.getValue().color = Color.rgb(100, 100, 100);
            } else if (country.getValue().color.equals(Color.rgb(0, 0, 204)) || country.getValue().color.equals(Color.rgb(153, 51, 255))) {
                country.getValue().color = Color.rgb(64, 64, 64);
            } else if (country.getValue().color.equals(Color.rgb(0, 0, 153)) || country.getValue().color.equals(Color.rgb(127, 0, 255))) {
                country.getValue().color = Color.rgb(0, 0, 6);
            }
        }
        display.initUIComponents();
        VBox dis = (VBox) display.splitPane.getItems().get(0);
        dis.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
        for (int i = 0; i < dis.getChildren().size(); i++) {
            if (dis.getChildren().get(i) instanceof Label) {
                ((Label) dis.getChildren().get(i)).setTextFill(Color.WHITE);
            }
        }
        return display;
    }
}

