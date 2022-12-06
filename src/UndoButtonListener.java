package src;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;
import src.CommandOperation.FilterCommand;

import static src.MapListener.history;
import static src.SearchButtonHandler.helper;


public class UndoButtonListener implements EventListener{

    public boolean observerState;
    public UndoButton subject;
    public MapView mapView;

    public UndoButtonListener(UndoButton subject, MapView mapView){
        observerState = false;
        this.subject = subject;
        this.mapView = mapView;
    }

    public void update(boolean state){
        observerState = state;
        if(state){
            //the button used to undo commands

            ((VBox) mapView.splitPane.getItems().get(0)).getChildren().get(2).setOnMouseClicked(evt2 -> {
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

            mapView.worldMapView.setCountryViewFactory(country -> {

                WorldMapView.CountryView view = new WorldMapView.CountryView((WorldMapView.Country) country);

                return helper(mapView, view);
            });

        }else{
            //subject.button.addEventHandler(MouseEvent.MOUSE_CLICKED);
        }
    }
}
