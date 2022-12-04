import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;

import java.util.ListIterator;

public class SearchButtonHandler implements EventHandler<MouseEvent> {

    public SearchButton subject;
    public MapView mapView;

    public SearchButtonHandler(SearchButton subject, MapView mapView){
        this.subject = subject;
        this.mapView = mapView;
    }
    @Override
    public void handle(MouseEvent mouseEvent) {
        String input = subject.textField.getText();
        String display = "";
        if(!App.world.Countries.containsKey(input)){
            display = "Country is not found";
        }else{
            Country country = App.world.Countries.get(input);
            display = country.getName() + " : " + country.getCO2_Emission();
        }
        System.out.println(mapView.worldMapView.getSelectedCountries());
        ((VBox) mapView.splitPane.getItems().get(0)).getChildren().add(new Label(display));
    }
}
