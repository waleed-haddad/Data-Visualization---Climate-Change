import java.util.*;

// package any packages;

// import Country from Waleed's thing;

public class CountryIteratorImplementation implements CountryIterator {
//    private Collection world;  //collection of countries (collection)
    private int currentPosition = 0;
    private HashMap<String, List> countries = new HashMap();

    // idk if i need to iterate through a world attribute or if countries should be a separate hash map

    public CountryIteratorImplementation(HashMap<String, List> countries) {
        this.countries = countries;
    }

    private void lazyLoad() {
//        if (emails.size() == 0) {
//            List<String> profiles = facebook.requestProfileFriendsFromFacebook(this.email, this.type);
//            for (String profile : profiles) {
//                this.emails.add(profile);
//                this.profiles.add(null);
//            }
//        }
    }

    @Override
    public boolean hasNext() {
        lazyLoad();
        return currentPosition < countries.size();
    }

    @Override
    public Country getNext() {
        if (!hasNext()) {
            return null;
        }
        currentPosition++;
        return countries.keySet().stream().toList().get(currentPosition - 1);
    }

    @Override
    public void reset() {
        currentPosition = 0;
    }
}