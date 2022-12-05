import java.util.*;

import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;

public class ColourBlindDisplay implements DefaultView {
    public final MapView display;
    public final MapEditor editor;
    public final CommandHistory history;
    public final WorldMapView worldMapView;
    public ColourBlindDisplay(MapView view) {
        this.display = view;
        this.worldMapView = view.worldMapView;
        this.editor = new MapEditor(view);
        this.history = new CommandHistory();
    }
    public MapView updateDisplay() {
        for (Map.Entry<String, Country> country : App.world.Countries.entrySet()) {
            if (country.getValue().color.equals(Color.rgb(51, 204, 255)) || country.getValue().color.equals(Color.rgb(180, 180, 200))) {
                country.getValue().color = Color.rgb(229, 204, 255);
            } else if (country.getValue().color.equals(Color.rgb(51, 153, 255)) || country.getValue().color.equals(Color.rgb(160, 160, 160))) {
                country.getValue().color = Color.rgb(204, 153, 255);
            } else if (country.getValue().color.equals(Color.rgb(0, 0, 255)) || country.getValue().color.equals(Color.rgb(100, 100, 100))) {
                country.getValue().color = Color.rgb(178, 114, 255);
            } else if (country.getValue().color.equals(Color.rgb(0, 0, 204)) || country.getValue().color.equals(Color.rgb(64, 64, 64))) {
                country.getValue().color = Color.rgb(153, 51, 255);
            } else if (country.getValue().color.equals(Color.rgb(0, 0, 153)) || country.getValue().color.equals(Color.rgb(127, 0, 255))) {
                country.getValue().color = Color.rgb(127, 0, 255);
            }
        }
        return null;
    }
}
