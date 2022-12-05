package src;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 * A World class. The World class contains a Hashmap of Countries.
 **/
public class World {

    /**
     * Hashmap which contains a countries name, and it's respective Country object.
     */
    HashMap<String, Country> Countries;

    /**
     * Main method of the program, initializes the Countries Hashmap.
     */
    public World() {
        Countries = new HashMap<>();
        constructorHelper();
        this.setColors();
        this.setRank();
    }

    /**
     * Helper method for the constructor, goes through the .csv file containing CO2-Emissions for all countries
     * and updates the Countries hashmap accordingly.
     */
    private void constructorHelper() {
        String filename = "src/CO2-Emissions.csv";
        String line = "";
        String[] tempArr;
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(filename));
            StringBuffer sb = new StringBuffer();
            // loops through the first five lines of the csv file, which do not contain countries.
            for (int i = 0; i < 5; i++){
                br.readLine();
            }
            while ((line = br.readLine()) != null) {
                tempArr = line.split(",");
                try {
                    Countries.put(tempArr[0].replaceAll("\"", ""), new Country(tempArr[0].replaceAll("\"", ""),
                            Double.parseDouble(tempArr[63].replaceAll("\"", ""))));
                }
                catch (NumberFormatException e){
                    Countries.put(tempArr[0].replaceAll("\"", ""), new Country(tempArr[0].replaceAll("\"", ""),
                            0.0));
                }

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setColors() {
        CountryIteratorBasic basicIterator = new CountryIteratorBasic(this);

        Color range1Color = new Color(51, 204, 255);
        Color range2Color = new Color(51, 153, 255);
        Color range3Color = new Color(0, 0, 255);
        Color range4Color = new Color(0, 0, 204);
        Color range5Color = new Color(0, 0, 153);

        Country currCountry;

        while(basicIterator.hasNext()){
            currCountry = basicIterator.getNext();
            if(currCountry.getCO2_Emission() < 2.29) currCountry.setColor(range1Color);
            if(currCountry.getCO2_Emission() < 5.35) currCountry.setColor(range2Color);
            if(currCountry.getCO2_Emission() < 9.02) currCountry.setColor(range3Color);
            if(currCountry.getCO2_Emission() < 15.0) currCountry.setColor(range4Color);
            if(currCountry.getCO2_Emission() > 15.0) currCountry.setColor(range5Color);
            currCountry.setSelected(true);
        }
    }

    public void setRank() {
        CarbonIterator carbonIterationImpl = new CarbonIterator(this);
        Country currCarbonCountry;

        int rank = 0;
        while(carbonIterationImpl.hasNext()){
            currCarbonCountry = carbonIterationImpl.getNext();
            currCarbonCountry.setRank(rank);
            rank++;
        }
    }

}