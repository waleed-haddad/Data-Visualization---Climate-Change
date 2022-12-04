package views;

import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;

public class NightModeDisplay implements DefaultView{
    private final Color colour;
    private final WorldMapView.CountryView view;

    public NightModeDisplay(WorldMapView.CountryView view) {
        this.view = view;
        this.colour = Color.rgb(0, 0, 51);
    }

    public void updateDisplay() {
        this.view.setFill(this.colour);
    }
}

