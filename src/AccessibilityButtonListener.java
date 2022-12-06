package src;


import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;

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
            System.out.println("here");

            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(3).setOnMouseClicked(evt2 -> {
                System.out.println("Enter in Default Mode setting");

                mapView.worldMapView.setCountryViewFactory(country -> {
                    WorldMapView.CountryView view = new WorldMapView.CountryView((WorldMapView.Country) country);

                    return helper(mapView, view);
                });
            });
            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(4).setOnMouseClicked(evt2 -> {
                System.out.println("Enter in Colour Blind Mode setting");

                mapView.worldMapView.setCountryViewFactory(country -> {

                    WorldMapView.CountryView view = new WorldMapView.CountryView((WorldMapView.Country) country);

                    return helper(mapView, view);
                });
            });
            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(5).setOnMouseClicked(evt2 -> {
                System.out.println("Enter in Night Mode setting");

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
