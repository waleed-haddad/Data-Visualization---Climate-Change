import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;
public class MapListener implements EventListener{
    public boolean observerState;
    public MapView subject;
    public WorldMapView worldMapView;

    /**
     * Constructor for MapListener
     * @param subject
     */
    public MapListener(MapView subject){
        observerState = false;
        this.subject = subject;
        worldMapView = subject.worldMapView;
    }

    /**
     * Updates the MapView subject according to state
     * @param state
     */
    public void update(boolean state){
        observerState = state;
        if(state){
            worldMapView.setCountryViewFactory(country -> {
                WorldMapView.CountryView view = new WorldMapView.CountryView(country);
                view.setOnMouseClicked(evt -> {
                    view.setFill(Color.BLUE);
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
