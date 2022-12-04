package src;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Concrete class for CountryIterator.
 * Iterates by carbon emission amount.
 */
public class CarbonIterator implements CountryIterator {

    /**
     * Hashmap which contains a collection of Country objects as values and keys representing the respective names as strings
     */
    private World countries;

    /**
     * ArrayList of countries used to sort the collection of Countries by carbon emissions.
     */
    private ArrayList<Country> countedCountryList = new ArrayList<Country>();

    /**
     * ArrayList of countries sorted by carbon emissions (highest to lowest).
     */
    private ArrayList<Country> sortedCountryList = new ArrayList<Country>();

    /**
     * ArrayList of carbon emission amounts used to sort the collection of Countries by carbon emissions.
     */
    private ArrayList<Double> carbonList = new ArrayList<Double>();

    /**
     * Integer which is used to index through the hashmap.
     */
    private int currentPosition = 0;

    /**
     * Constructor for the CarbonIterator
     * @param world Hashmap containing a collection of Countries as values and their respective names as a string
     */
    public CarbonIterator(World world) {
        this.countries = world;
        for(Country country: this.countries.Countries.values()){
            carbonList.add(country.getCO2_Emission());
        }
        Collections.sort(carbonList);
        for(double emission: carbonList){
            for(Country country: this.countries.Countries.values()){
                if(country.getCO2_Emission() == emission && !this.countedCountryList.contains(country)){
                    this.sortedCountryList.add(country);
                    this.countedCountryList.add(country);
                    break;
                }
            }
        }
    }

    /**
     * Overidden method used to return whether there exists a country with a lower carbon emission rate in the collection.
     * @return Boolean value representing whether there exists a country next for this iterator.
     */
    @Override
    public boolean hasNext() {
        return currentPosition < this.sortedCountryList.size();
    }

    /**
     * Overriden method used to return the next country in the collection (if it exists) based on carbon emissions.
     * @return Country object representing the next country in the collection for this iterator.
     */
    @Override
    public Country getNext() {
        if (!hasNext()) {
            return null; }
        currentPosition++;
        return sortedCountryList.get(currentPosition - 1);
    }

    /**
     * Overridden method used to reset the Iterator's indexing variable.
     * Allows the iterator to start from the beginning next time it is called.
     */
    @Override
    public void reset() {
        currentPosition = 0;
    }
}