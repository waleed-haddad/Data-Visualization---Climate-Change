package src;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The Country class to test the Country object for Data-Visualisation purposes.
 * Tests various components of the class.
 */
public class CountryTest {

    @Test
    void ContinentTest() {
        Country Canada = new Country("Canada", 1.5);
        assertEquals("Americas", Canada.Continent);
    }
}
