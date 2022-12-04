package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SearchButtonTest {

    /**
     * Must comment out UI components in order ruin tests
     */
    @Test
    void RegisteringEventListenersTest() {
        MapView mapView = new MapView();
        SearchButton searchButton = new SearchButton(mapView);
        SearchButtonListener listener = new SearchButtonListener(searchButton);
        SearchButtonListener listener2 = new SearchButtonListener(searchButton);
        searchButton.register(listener);
        searchButton.register(listener2);
        assertEquals(searchButton.eventListeners.size(), 2);
        searchButton.unregister(listener);
        assertEquals(searchButton.eventListeners.size(), 1);
    }

    @Test
    void EventListenersStateTest() {
        MapView mapView = new MapView();
        SearchButton searchButton = new SearchButton(mapView);
        SearchButtonListener listener = new SearchButtonListener(searchButton);
        searchButton.register(listener);
        searchButton.setState(false);
        assertFalse(searchButton.getState());
        searchButton.setState(true);
        assertTrue(searchButton.getState());
        searchButton.setState(false);
        assertFalse(searchButton.getState());
    }
}
