package src.CommandOperation;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.controlsfx.control.WorldMapView;
import src.MapView;
import src.Country;

public class FilterCommand implements Command{

    private Label countryLabel;
    public MapView subject;

    public MapEditor editor;

    public WorldMapView.CountryView view1;

    public Country country;

    public FilterCommand(Label countryLabel, MapView subject, WorldMapView.CountryView view,
                         MapEditor editor, Country tempCountry) {
        this.subject = subject;
        this.countryLabel = countryLabel;
        this.view1 = view;
        this.editor = editor;
        this.country = tempCountry;
    }

    @Override
    /**
     * Implements the filter command as based on specifications.
     */
    public void execute() {
        editor.FilterCountry(view1);
        if(!country.printed){
            editor.updateDisplay(countryLabel);
            country.printed = true;
        }
    }

    /**
     * Undos the filter command as based on specifications.
     */
    @Override
    public void unexecute() {
        ((VBox) subject.splitPane.getItems().get(0)).getChildren().remove(countryLabel);
        System.out.println(view1.getName());
        view1.setFill(Color.LIGHTGREEN);
    }

    @Override
    /**
     * Getter-method for the command's specific info.
     * @return Label - the countryLabel which contains the country's name, etc.
     */
    public Country getInfo(){
        return this.country;
    }
}
