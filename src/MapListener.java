package src;

import javafx.util.Callback;
import src.CommandOperation.MapEditor;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;
import src.CommandOperation.Command;
import src.CommandOperation.CommandHistory;
import src.CommandOperation.FilterCommand;
import src.CommandOperation.MapEditor;


import java.util.Map;

import static src.SearchButtonHandler.helper;

public class MapListener implements EventListener{
    public boolean observerState;
    public MapView subject;
    public WorldMapView worldMapView;

    public MapEditor editor;

    public static CommandHistory history;

    public static Callback mapFunction;

    /**
     * Constructor for MapListener
     * @param subject : MapView object as MapListeners can only be used with MapView
     */
    public MapListener(MapView subject){
        observerState = false;
        this.subject = subject;
        worldMapView = subject.worldMapView;
        editor = new MapEditor(subject);
        history = new CommandHistory();
    }

    /**
     * Updates the MapView subject according to state
     * @param state : boolean value of the listener
     */
    public void update(boolean state){
        observerState = state;
        if(state){
            //the button used to undo commands

            ((VBox) subject.splitPane.getItems().get(0)).getChildren().get(2).setOnMouseClicked(evt2 -> {
                try {
                    FilterCommand command = (FilterCommand) history.undoCommand();
                    command.unexecute();
                    command.country.selected = false;
                    command.country.printed = false;
                }
                catch (IndexOutOfBoundsException e){
                    Alert a = new Alert(Alert.AlertType.NONE, "No Action left to Undo!", ButtonType.CLOSE);
                    a.show();
                }
            });

            worldMapView.setCountryViewFactory(country -> {

                WorldMapView.CountryView view = new WorldMapView.CountryView((WorldMapView.Country) country);
                String countryName = view.getCountry().getLocale().getDisplayName();
                for (Map.Entry<String, Country> country2 : App.world.Countries.entrySet()) {
                    System.out.println(country2.getValue().getSelected());
                }
                if (App.world.Countries.containsKey(countryName)) {
                    Country countryTest = App.world.Countries.get(countryName);
                    view.setFill(countryTest.getColor());
                    System.out.println(countryTest.getColor());
                }else{
                    view.setFill(Color.rgb(51, 204, 255));
                }
                return helper(subject, view);
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
