import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;
public class MapListener implements EventListener{
    public boolean observerState;
    public MapView subject;
    public WorldMapView worldMapView;

    /**
     * Constructor for MapListener
     * @param subject : MapView object as MapListeners can only be used with MapView
     */
    public MapListener(MapView subject){
        observerState = false;
        this.subject = subject;
        worldMapView = subject.worldMapView;
    }

    /**
     * Updates the MapView subject according to state
     * @param state : boolean value of the listener
     */
    public void update(boolean state){
        observerState = state;
        if(state){
            worldMapView.setCountryViewFactory(country -> {
                WorldMapView.CountryView view = new WorldMapView.CountryView(country);
                view.setOnMouseClicked(evt -> {
                    if(view.getFill() == Color.BLUE){
                        view.setFill(Color.LIGHTGREEN);
                    }else{
                        view.setFill(Color.BLUE);
                        ((VBox) subject.splitPane.getItems().get(0)).getChildren().add(new Label(view.getCountry().getLocale().getDisplayCountry()));
                    }
                });
                view.setOnMouseEntered(evt -> {
                    view.setOpacity(0.5);
                });
                view.setOnMouseExited(evt -> {
                    view.setOpacity(1);
                });
                return view;
            });
        }else{
            worldMapView.setCountryViewFactory(country -> {
                WorldMapView.CountryView view = new WorldMapView.CountryView(country);
                view.setOnMouseClicked(evt -> {
                });
                return view;
            });
        }
    }
}
