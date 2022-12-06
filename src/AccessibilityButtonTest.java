package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AccessibilityButtonTest {

    /**
     * Must comment out UI components in order run tests
     */
    @Test
    void RegisteringEventListenersTest() {
        MapView mapView = new MapView();
        AccessibilityButton accessibilityButton = new AccessibilityButton(mapView);
        AccessibilityButtonListener listener = new AccessibilityButtonListener(accessibilityButton, mapView);
        AccessibilityButtonListener listener2 = new AccessibilityButtonListener(accessibilityButton, mapView);
        accessibilityButton.register(listener);
        accessibilityButton.register(listener2);
        assertEquals(accessibilityButton.eventListeners.size(), 2);
        accessibilityButton.unregister(listener);
        assertEquals(accessibilityButton.eventListeners.size(), 1);
    }

    @Test
    void EventListenersStateTest() {
        MapView mapView = new MapView();
        AccessibilityButton accessibilityButton = new AccessibilityButton(mapView);
        AccessibilityButtonListener listener = new AccessibilityButtonListener(accessibilityButton, mapView);
        accessibilityButton.register(listener);
        accessibilityButton.setState(false);
        assertFalse(accessibilityButton.getState());
        accessibilityButton.setState(true);
        assertTrue(accessibilityButton.getState());
        accessibilityButton.setState(false);
        assertFalse(accessibilityButton.getState());
    }
}
