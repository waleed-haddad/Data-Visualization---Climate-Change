package src;

import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;
import src.CommandOperation.Command;
import src.CommandOperation.FilterCommand;
import src.CommandOperation.MapEditor;

import java.util.Objects;

import static src.MapListener.history;
import static src.MapListener.mapFunction;


public class SearchButtonHandler implements EventHandler<MouseEvent> {

    public SearchButton subject;
    public MapView mapView;

    /**
     * Constructor for SearchButtonHandler
     * @param subject - SearchButton object
     * @param mapView - MapView object, necessary in order to make changes to the display
     */
    public SearchButtonHandler(SearchButton subject, MapView mapView){
        this.subject = subject;
        this.mapView = mapView;
    }

    /**
     * Handler function for SearchButton
     * @param mouseEvent - Handles function on certain mouse function.
     */
    @Override
    public void handle(MouseEvent mouseEvent) {
        String input = subject.textField.getText();
        if(!App.world.Countries.containsKey(input)){
            Alert a = new Alert(Alert.AlertType.NONE, "Country not Found!", ButtonType.CLOSE);
            a.show();
        }else{
            Country countryVal = App.world.Countries.get(input);
            countryVal.selected = true;

            mapView.worldMapView.setCountryViewFactory(country -> {
                WorldMapView.CountryView view = new WorldMapView.CountryView((WorldMapView.Country) country);
                String countryName = view.getCountry().getLocale().getDisplayCountry();

                if(App.world.Countries.containsKey(countryName)) {
                    Country tempCountry = App.world.Countries.get(countryName);
                    Command tempC = new FilterCommand(new Label(tempCountry.getName() + " : " + tempCountry.getCO2_Emission()),
                            mapView, view, mapView.editor, tempCountry);
                    if (tempCountry.selected) {
                        if(history.getCommandHashMap().containsKey(tempCountry.getName())){
                            FilterCommand c = ((FilterCommand) history.getCommandHashMap().get(tempCountry.getName()));
                            c.view1 = view;
                            c.execute();
                        }
                        if(Objects.equals(tempCountry.getName(), countryVal.getName())){
                            history.addCommand(tempC);
                            tempC.execute();
                        }
                    }
                }
                return helper(mapView, view);
                /*
                view.setOnMouseClicked(evt -> {
                    Country tempCountry = App.world.Countries.get(countryName);
                    Command tempC = new FilterCommand(new Label(tempCountry.getName() + " : " + tempCountry.getCO2_Emission()),
                            mapView, view, mapView.editor, tempCountry);
                    if(tempCountry.selected){
                        history.removeCommand(tempC).unexecute();
                        tempCountry.selected = false;
                        tempCountry.printed = false;
                    } else {
                        history.addCommand(tempC);
                        tempCountry.selected = true;
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
                */

            });
        }
    }


    public static WorldMapView.CountryView helper(MapView mapView, WorldMapView.CountryView view){
        String countryName = view.getCountry().getLocale().getDisplayCountry();

        view.setOnMouseClicked(evt -> {
            Country tempCountry = App.world.Countries.get(countryName);
            Command tempC = new FilterCommand(new Label(tempCountry.getName() + " : " + tempCountry.getCO2_Emission()),
                    mapView, view, mapView.editor, tempCountry);
            if(tempCountry.selected){
                history.removeCommand(tempC).unexecute();
                tempCountry.selected = false;
                tempCountry.printed = false;
            } else {
                history.addCommand(tempC);
                tempCountry.selected = true;
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
    }
}
