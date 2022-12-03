package src.CommandOperation;

import javafx.scene.control.Alert;
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

    public FilterCommand(Label countryLabel, MapView subject, WorldMapView.CountryView view, MapEditor editor) {
        this.subject = subject;
        this.countryLabel = countryLabel;
        this.view1 = view;
        this.editor = editor;
    }

    @Override
    /**
     * Implements the filter command as based on specifications.
     */
    public void execute() {
        editor.FilterCountry(view1, countryLabel);
    }

    /**
     * Undos the filter command as based on specifications.
     */
    @Override
    public void unexecute() {
        ((VBox) subject.splitPane.getItems().get(0)).getChildren().remove(countryLabel);
        view1.setFill(Color.LIGHTGREEN);
    }
}
