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

import static src.SearchButtonHandler.helper;

public class MapListener implements EventListener{
    public boolean observerState;
    public MapView subject;
    public WorldMapView worldMapView;

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
