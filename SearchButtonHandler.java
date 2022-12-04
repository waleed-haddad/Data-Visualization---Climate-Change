import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class SearchButtonHandler implements EventHandler<MouseEvent> {

    public SearchButton subject;
    public MapView mapView;

    /**
     * Constructor for SearchButtonHandler
     * @param subject - SearchButton object
     * @param mapView - MapView object, necessary in order to make changes to the display
     */
    public SearchButtonHandler(SearchButton subject, MapView mapView){
        this.subject = subject;
        this.mapView = mapView;
    }

    /**
     * Handler function for SearchButton
     * @param mouseEvent - Handles function on certain mouse function.
     */
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
