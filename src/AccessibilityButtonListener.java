package src;


import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;
import src.CommandOperation.MapEditor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static src.SearchButtonHandler.helper;


public class AccessibilityButtonListener implements EventListener {
    public boolean observerState;
    public AccessibilityButton subject;
    public MapView mapView;

    /**
     * Constructor for AccessibilityButtonListener
     * @param subject - AccessibilityButton object
     * @param mapView - MapView object, using the MapView object allows for ease in establishing the handlers for the buttons
     */
    public AccessibilityButtonListener(AccessibilityButton subject, MapView mapView){
        observerState = false;
        this.subject = subject;
        this.mapView = mapView;
    }

    /**
     * Updates the EventHandler of the three Accessibility Buttons based on the state
     * @param state : boolean value
     */
    public void update(boolean state){
        observerState = state;

        if(state){

            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(3).setOnMouseClicked(evt2 -> {
                ResetDisplay dl = new ResetDisplay(mapView);
                dl.updateDisplay();
                try {
                    Image image1 = new Image(new FileInputStream("src/DefaultModeLegend.png"));
                    ImageView Iv = (ImageView) ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(6);
                    Iv.setImage(image1);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                mapView.worldMapView.setCountryViewFactory(country -> {
                    WorldMapView.CountryView view = new WorldMapView.CountryView((WorldMapView.Country) country);

                    return helper(mapView, view);
                });
            });
            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(4).setOnMouseClicked(evt2 -> {
                ColourBlindDisplay dl = new ColourBlindDisplay(mapView);
                dl.updateDisplay();
                try {
                    Image image1 = new Image(new FileInputStream("src/ColourBlindLegend.png"));
                    ImageView Iv = (ImageView) ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(6);
                    Iv.setImage(image1);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                mapView.worldMapView.setCountryViewFactory(country -> {

                    WorldMapView.CountryView view = new WorldMapView.CountryView((WorldMapView.Country) country);

                    return helper(mapView, view);
                });
            });
            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(5).setOnMouseClicked(evt2 -> {
                NightModeDisplay dl = new NightModeDisplay(mapView);
                dl.updateDisplay();
                try {
                    Image image1 = new Image(new FileInputStream("src/NightModeLegend.png"));
                    ImageView Iv = (ImageView) ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(6);
                    Iv.setImage(image1);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
                mapView.worldMapView.setCountryViewFactory(country -> {

                    WorldMapView.CountryView view = new WorldMapView.CountryView((WorldMapView.Country) country);

                    return helper(mapView, view);
                });
            });

        }else{
            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(3).setOnMouseClicked(evt2 -> {

            });
            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(4).setOnMouseClicked(evt2 -> {

            });
            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(5).setOnMouseClicked(evt2 -> {

            });
        }
    }

}
