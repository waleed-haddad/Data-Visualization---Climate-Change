import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SearchButton extends UIButton {
    TextField textField;
    MapView mapView;

    SearchButtonHandler handler;

    /**
     * Constructor for SearchButton
     * @param mapView - The mapview is required in order to process the handler for the button
     */
    public SearchButton(MapView mapView) {
        this.mapView = mapView;
        textField = new TextField("Search For Country");
        this.button = new Button("Search");
        handler = new SearchButtonHandler(this, mapView);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

}
