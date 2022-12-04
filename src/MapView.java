package src;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;
import javafx.scene.control.Button;
import src.CommandOperation.MapEditor;


public class MapView extends Event{
    public WorldMapView worldMapView;
    public SplitPane splitPane;
    public SearchButton searchButton;
    public MapEditor editor;

    public MapView(){

    }
    /**
     * Function to initialize UI components of MapView to enable for testing.
     * Must be called right after initialization of MapView object
     */
    public void initUIComponents(){
        worldMapView = new WorldMapView();
        splitPane = new SplitPane();
        Button undoB = new Button("Undo");
        searchButton = new SearchButton(this);
        VBox display = new VBox(searchButton.textField, searchButton.button, undoB, new Label("Display Information"));
        splitPane.getItems().add(display);
        editor = new MapEditor(this);
    }

}
