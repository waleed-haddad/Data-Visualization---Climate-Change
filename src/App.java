package src;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;

import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.controlsfx.control.WorldMapView;

import static src.SearchButtonHandler.helper;


public class App extends Application {
    MapView map = new MapView();
    SearchButton searchButton = new SearchButton(map);
    AccessibilityButton accessibilityButton = new AccessibilityButton(map);
    WorldMapView worldMapView;
    SplitPane splitPane;

    UndoButton undoButton = new UndoButton(map);

    public static World world = new World();


    /**
     * Main method to launch the application
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     *
     * @return Node representing MapView in the stage
     */
    public Node createView() {
        map.initUIComponents();
        worldMapView = map.worldMapView;
        splitPane = map.splitPane;
        map.setState(true);
        MapListener mapListener = new MapListener(map);
        map.register(mapListener);
        map.notifyObserver(mapListener);
        accessibilityButton.setState(true);
        AccessibilityButtonListener accessibilityButtonListener = new AccessibilityButtonListener(accessibilityButton, map);
        accessibilityButton.setState(true);
        accessibilityButton.register(accessibilityButtonListener);
        accessibilityButton.notifyObserver(accessibilityButtonListener);
        undoButton.setState(true);
        UndoButtonListener undoButtonListener = new UndoButtonListener(undoButton, map);
        undoButton.register(undoButtonListener);
        undoButton.notifyObserver(undoButtonListener);

        searchButton.setState(true);
        SearchButtonListener searchButtonListener = new SearchButtonListener(searchButton);
        searchButton.register(searchButtonListener);
        searchButton.notifyObserver(searchButtonListener);
        StackPane stackPane = new StackPane();
        StackPane.setAlignment(worldMapView, Pos.CENTER);
        stackPane.getChildren().add(worldMapView);

        return stackPane;
    }

    /**
     * Function to Start the Visualizer
     * @param primaryStage : Stage object for the view
     */
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Climate Change Data Visualizer");

        Scene scene = new Scene((Parent) buildView(), 800, 800);

        primaryStage.setScene(scene);
        primaryStage.show();
    }


    /**
     * General Function for building the view
     * @return Node for the final view
     */
    public Node buildView() {

        final Node samplePanel = createView();

        if (samplePanel != null) {
            splitPane.getItems().add(samplePanel);
        }


        return splitPane;
    }

}