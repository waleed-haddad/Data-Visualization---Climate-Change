import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;
import javafx.scene.control.Button;


public class MapView extends Event{
    public WorldMapView worldMapView;
    public SplitPane splitPane;
    public SearchButton searchButton;
    public MapView(){
       // initUIComponents();
    }
    /**
     * Function to initialize UI components of MapView to enable for testing.
     * Must be called right after initialization of MapView object
     */
    public void initUIComponents(){
        worldMapView = new WorldMapView();
        splitPane = new SplitPane();
        searchButton = new SearchButton(this);
        VBox display = new VBox(searchButton.textField, searchButton.button, new Label("Display Information"));
        splitPane.getItems().add(display);
    }

}
