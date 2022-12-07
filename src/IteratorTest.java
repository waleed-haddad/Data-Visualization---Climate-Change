package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * The WorldTest class to test the World object for Data-Visualisation purposes.
 * Tests various components of the class.
 */
public class IteratorTest {

    @Test
    void BasicTest() {
        World basicWorld = new World();
        CountryIteratorBasic basicIterator = new CountryIteratorBasic(basicWorld);
        basicIterator.getNext();
        assertEquals(basicIterator.getNext().getName(), "Cambodia");
    }

    @Test
    void CarbonIteratorTest() {
        World carbonWorld = new World();
        CarbonIterator carbonIteratorTester = new CarbonIterator(carbonWorld);
        carbonIteratorTester.getNext();
        assertEquals(carbonIteratorTester.getNext().getName(), "Kuwait");
    }
}
