package src;

import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * A Country class. Contains the following:
 *  - A Country has a name, unique to the country.
 *  - A Country has a respective continent to which it belongs.
 *  - A Country has CO2 emissions in kilotons.
 */

public class Country{

    private String Name;

    public String Continent;

    public boolean selected;

    public boolean printed;

    private double CO2_Emission;

    /**
     * Create a Country with the given CO2_Emission level.
     *
     * @param Name The name of the country, in String representation
     * @param CO2_Emission	The CO2 emmissions for the country in kilotons.
     */
     public Country(String Name, double CO2_Emission){
         this.Name = Name;
         this.CO2_Emission = CO2_Emission;
         this.Continent = CountryToContinent(this.Name);
         this.selected = false;
         this.printed = false;
     }


    /**
     * Helper method for the constructor which returns the respective Continent a country belongs to.
     *
     * @param Name The name of the country, in String representation
     * @return The String representation of the respective Continent, which the country belongs to. If no continent data
     * is present, returns N/A.
     */
    public static String CountryToContinent(String Name) {
        String result = "";
        String filename = "src/countryContinent.csv";
        String line = "";
        String[] tempArr;
        try {
            BufferedReader br = null;
            br = new BufferedReader(new FileReader(filename));
            StringBuffer sb = new StringBuffer();
            while ((line = br.readLine()) != null) {
                if (line.contains(Name)) {
                    tempArr = line.split(",");
                    try {
                        result = tempArr[5];
                    }
                    catch (IndexOutOfBoundsException e){
                        result = "N/A";
                    }

                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    /**
     * Get the country's CO2 Emissions.
     * @return the value, in double, of the country's CO2 Emissions.
     */
    public double getCO2_Emission() {
        return this.CO2_Emission;
    }
    /**
     * Get the country's name.
     * @return the value, in String representation, of the country's name.
     */
    public String getName() {
        return Name;
    }
    /**
     * Get the country's respective continent.
     * @return the value, in String representation, of the country's respective continent.
     */
    public String getContinent() {
        return Continent;
    }

}
