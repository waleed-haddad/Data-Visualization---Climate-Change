package src;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class NightModeDisplayTest {
    /**
     * Must comment out UI components in order run tests
     */
    @Test
    void NightModeDisplayTest1() {
        MapView mapView = new MapView();
        Color L = App.world.Countries.get("Canada").color;
        NightModeDisplay dl = new NightModeDisplay(mapView);
        dl.updateDisplay();
        Color L2 = App.world.Countries.get("Canada").color;
        assertNotEquals(L, L2);
    }

    @Test
    void NightModeDisplayTest2() {
        MapView mapView = new MapView();
        Color L = App.world.Countries.get("Panama").color;
        NightModeDisplay dl = new NightModeDisplay(mapView);
        dl.updateDisplay();
        Color L2 = App.world.Countries.get("Panama").color;
        assertNotEquals(L, L2);
    }
}
