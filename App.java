package src;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.*;

import javafx.stage.Stage;
import org.controlsfx.control.WorldMapView;


public class App extends Application {
    MapView map = new MapView();
    WorldMapView worldMapView;
    SplitPane splitPane;

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
        StackPane stackPane = new StackPane();
        StackPane.setAlignment(worldMapView, Pos.CENTER);
        stackPane.getChildren().add(worldMapView);

        return stackPane;
    }

    /**
     * Function to Start the Visualizer
     * @param primaryStage : Stage object for tbe view
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