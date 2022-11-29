import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;

public class MapView extends Event{
    public WorldMapView worldMapView;
    public SplitPane splitPane;
    /**
     * Constructor for MapView
     */
    public MapView(){

        worldMapView = new WorldMapView();
        splitPane = new SplitPane();
        VBox display = new VBox(new Label("Display Information"));
        splitPane.getItems().add(display);
    }

}
