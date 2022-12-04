import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import org.controlsfx.control.WorldMapView;

public class SearchButtonListener implements EventListener {
    public boolean observerState;
    public SearchButton subject;
    public SearchButtonHandler handler;


    public SearchButtonListener(SearchButton subject){
        observerState = false;
        this.subject = subject;
        handler = subject.handler;
    }

    public void update(boolean state){
        observerState = state;
        if(!state){
            subject.button.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);

        }else{
            subject.button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        }
    }

}
