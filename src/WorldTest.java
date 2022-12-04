package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The WorldTest class to test the World object for Data-Visualisation purposes.
 * Tests various components of the class.
 */
public class WorldTest {

    @Test
    void ContinentsTest() {
        World hehe = new World();
        assertTrue(hehe.Countries.containsKey("Canada"));
    }

    @Test
    void C02Test() {
        World hehe2 = new World();
        assertEquals(hehe2.Countries.get("Canada").getCO2_Emission(), 15.4306128276297);
    }
}
