package src;

/**
 * Interface for CountryIterator. Contains the following methods to be overwritten:
 * - hasNext(): returns whether there exists a country next in the collection
 * - getNext(): returns the country next in the collection
 * - reset(): resets the iterator count so future iterations can start from the beginning of the collection
 */
public interface CountryIterator {
    public boolean hasNext();

    public Country getNext();

    public void reset();
}