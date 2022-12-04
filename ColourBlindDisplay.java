import java.util.*;

import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;

public class ColourBlindDisplay implements DefaultView {
    private final Color colour;
    private final WorldMapView.CountryView view;
    public ColourBlindDisplay(WorldMapView.CountryView view) {
        this.view = view;
        this.colour = Color.rgb(0, 114, 178);
    }
    public void updateDisplay() {
        this.view.setFill(this.colour);
    }
}
