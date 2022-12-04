

import java.util.ArrayList;

public abstract class Event {
    public boolean observableState;
    public ArrayList<EventListener> eventListeners;

    /**
     * Default Constructor for Event Objects
     */
    public Event(){
        observableState = true;
        eventListeners = new ArrayList<>();
    }

    /**
     * Adding EventListener to eventListeners list
     * @param e : EventListener object
     */
    public void register(EventListener e){
        eventListeners.add(e);
    }

    /**
     * Removing EventListener from eventListeners list
     * @param e : EventListener object
     */
    public void unregister(EventListener e){
        eventListeners.remove(e);
    }

    /**
     *
     * @param val : boolean value to set observable state
     */
    public void setState(boolean val){
        observableState = val;
    }

    /**
     *
     * @return observableState
     */
    public boolean getState(){
        return observableState;
    }

    /**
     * Notify Observer to act accordingly depending on Observable State
     * @param e : EventListener object
     */
    public void notifyObserver(EventListener e){
        e.update(observableState);
    }
}
