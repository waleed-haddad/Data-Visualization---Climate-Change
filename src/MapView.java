package src;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;
import javafx.scene.control.Button;

import src.CommandOperation.MapEditor;


import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class  MapView extends Event{
    public WorldMapView worldMapView;
    public SplitPane splitPane;
    public SearchButton searchButton;
    public UndoButton undoButton;
    public AccessibilityButton accessibilityButton;
    public MapEditor editor;
    public ImageView imageView;
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
        accessibilityButton = new AccessibilityButton(this);
        undoButton = new UndoButton(this);
        try {
            Image image1 = new Image(new FileInputStream("src/DefaultModeLegend.png"));
            imageView = new ImageView();
            imageView.setImage(image1);
            imageView.setFitHeight(100);
            imageView.setFitWidth(300);
            VBox display = new VBox(searchButton.textField, searchButton.button, undoButton.button, accessibilityButton.defaultView, accessibilityButton.colourBlind, accessibilityButton.nightMode, imageView, new Label("Display Information"));
            splitPane.getItems().add(display);
            editor = new MapEditor(this);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
