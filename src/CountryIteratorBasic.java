package src;

/**
 * Concrete class for CountryIterator.
 * Iterates simply by indexing to the next country in the collection.
 */
public class CountryIteratorBasic implements CountryIterator {

    /**
     * Hashmap which contains a collection of Country objects as values and keys representing the respective names as strings
     */
    private World countries;

    /**
     * Integer which is used to index through the hashmap.
     */
    private int currentPosition = 0;

    /**
     * Constructor for the CountryIteratorBasic
     * @param world Hashmap containing a collection of Countries as values and their respective names as a string
     */
    public CountryIteratorBasic(World world) {
        this.countries = world;
    }

    /**
     * Overidden method used to return whether there exists a country next in the collection.
     * Checks the currentPosition index to do so.
     * @return Boolean value representing whether there exists a country next in the collection.
     */
    @Override
    public boolean hasNext() {
        return currentPosition < countries.Countries.size();
    }

    /**
     * Overriden method used to return the next country in the collection (if it exists)
     * Indexes through the HashMap to do so.
     * @return Country object representing the next country in the collection.
     */
    @Override
    public Country getNext() {
        if (!hasNext()) {
            return null; }
        currentPosition++;
        return countries.Countries.values().stream().toList().get(currentPosition - 1);
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
