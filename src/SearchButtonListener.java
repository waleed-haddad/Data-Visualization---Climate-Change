package src;

import javafx.scene.input.MouseEvent;

public class SearchButtonListener implements EventListener {
    public boolean observerState;
    public SearchButton subject;
    public SearchButtonHandler handler;

    /**
     * Constructor for SearchButtonListener
     * @param subject - SearchButton object
     */
    public SearchButtonListener(SearchButton subject){
        observerState = false;
        this.subject = subject;
        handler = subject.handler;
    }

    /**
     * Updates the EventHandler of the button based on the state
     * @param state : boolean value
     */
    public void update(boolean state){
        observerState = state;
        if(!state){
            subject.button.removeEventHandler(MouseEvent.MOUSE_CLICKED, handler);

        }else{
            subject.button.addEventHandler(MouseEvent.MOUSE_CLICKED, handler);
        }
    }

}
