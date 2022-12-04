package src;

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

public class MapListener implements EventListener{
    public boolean observerState;
    public MapView subject;
    public WorldMapView worldMapView;

    public MapEditor editor;

    public CommandHistory history;

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
            ((VBox) subject.splitPane.getItems().get(0)).getChildren().get(0).setOnMouseClicked(evt2 -> {
                try {
                    history.undoCommand().unexecute();
                }
                catch (IndexOutOfBoundsException e){
                    Alert a = new Alert(Alert.AlertType.NONE, "No Action left to Undo!", ButtonType.CLOSE);
                    a.show();
                }
            });

            worldMapView.setCountryViewFactory(country -> {
                WorldMapView.CountryView view = new WorldMapView.CountryView(country);
                view.setOnMouseClicked(evt -> {
                    Country tempCountry = new Country(view.getCountry().getLocale().getDisplayCountry(), 0.0);
                    Command tempC = new FilterCommand(new Label(view.getCountry().getLocale().getDisplayCountry()),
                            subject, view, editor, tempCountry);
                    if(view.getFill() == Color.BLUE){
                        history.removeCommand(tempC).unexecute();
                    }
                    else {
                        history.addCommand(tempC);
                        tempC.execute();
                    }
                });
                view.setOnMouseEntered(evt -> {
                    view.setOpacity(0.5);
                });
                view.setOnMouseExited(evt -> {
                    view.setOpacity(1);
                });

                return view;
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
