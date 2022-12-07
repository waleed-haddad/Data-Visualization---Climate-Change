package src;

import javafx.scene.paint.Color;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResetDisplayTest {
    /**
     * Must comment out UI components in order run tests
     */
    @Test
    void ResetDisplayTest1() {
        MapView mapView = new MapView();
        Color L = App.world.Countries.get("Panama").color;
        ColourBlindDisplay dl = new ColourBlindDisplay(mapView);
        dl.updateDisplay();
        ResetDisplay dl2 = new ResetDisplay(mapView);
        dl2.updateDisplay();
        Color L2 = App.world.Countries.get("Panama").color;
        assertEquals(L, L2);
    }

    @Test
    void ResetDisplayTest2() {
        MapView mapView = new MapView();
        Color L = App.world.Countries.get("Panama").color;
        NightModeDisplay dl = new NightModeDisplay(mapView);
        dl.updateDisplay();
        ResetDisplay dl2 = new ResetDisplay(mapView);
        dl2.updateDisplay();
        Color L2 = App.world.Countries.get("Panama").color;
        assertEquals(L, L2);
    }
}
