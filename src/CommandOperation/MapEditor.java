package src.CommandOperation;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;
import src.App;
import src.Country;
import src.MapView;

/**
 * This is the receiver class and contains methods for carrying out all of
 * the commands.
 */
public class MapEditor {
    public MapView subject;

    public WorldMapView worldMapView;


    public MapEditor(MapView subject){
        this.subject = subject;
        worldMapView = subject.worldMapView;
    }

    public void FilterCountry(WorldMapView.CountryView view) {
        view.setFill(Color.BLUE);
   }

    public void updateDisplay(Label countryLabel) {
        ((VBox) subject.splitPane.getItems().get(0)).getChildren().add(countryLabel );
    }
}
