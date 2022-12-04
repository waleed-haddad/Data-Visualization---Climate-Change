package views;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MapViewerTest {

    @Test
    void RegisteringEventListenersTest() {
        MapView mapTest = new MapView();
        MapListener listener = new MapListener(mapTest);
        MapListener listener2 = new MapListener(mapTest);
        mapTest.register(listener);
        mapTest.register(listener2);
        assertEquals(mapTest.eventListeners.size(), 2);
        mapTest.unregister(listener);
        assertEquals(mapTest.eventListeners.size(), 1);
    }

    @Test
    void EventListenersStateTest() {
        MapView mapTest = new MapView();
        MapListener listener = new MapListener(mapTest);
        mapTest.register(listener);
        mapTest.setState(false);
        assertFalse(mapTest.getState());
        mapTest.setState(true);
        assertTrue(mapTest.getState());
        mapTest.setState(false);
        assertFalse(mapTest.getState());
    }
}
