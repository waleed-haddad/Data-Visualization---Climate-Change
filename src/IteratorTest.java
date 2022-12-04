package src;

import org.junit.jupiter.api.Test;

/**
 * The WorldTest class to test the World object for Data-Visualisation purposes.
 * Tests various components of the class.
 */
public class IteratorTest {

    @Test
    void BasicTest() {
        World basicWorld = new World();
        CountryIteratorBasic basicIterator = new CountryIteratorBasic(basicWorld);
        System.out.print(basicIterator.getNext());
//        assertTrue(hehe.Countries.containsKey("Canada"));
    }

    @Test
    void CarbonIteratorTest() {
        World carbonWorld = new World();
        CarbonIterator carbonIteratorTester = new CarbonIterator(carbonWorld);
//        assertEquals(hehe2.Countries.get("Canada").getCO2_Emission(), 15.4306128276297);
    }
}
