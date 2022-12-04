import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class SearchButton extends UIButton {
    TextField textField;
    MapView mapView;

    SearchButtonHandler handler;

    public SearchButton(MapView mapView) {
        this.mapView = mapView;
        textField = new TextField("Search For Country");
        this.button = new Button("Search");
        handler = new SearchButtonHandler(this, mapView);
        button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
    }

}
