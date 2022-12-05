package src;

import java.awt.*;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

/**
 * A Country class. Contains the following:
 *  - A Country has a name, unique to the country.
 *  - A Country has a respective continent to which it belongs.
 *  - A Country has CO2 emissions in kilotons.
 *  - A Country has a color representing the range its CO2 emissions lie in relation to the emissions of other countries
 *  - A Country has a boolean value is_selected which indicates whether it should be highlighted on a map
 *  - A Country has a rank indicating its placement on a sorted list containing every county and their CO2 emissions
 */

public class Country{

    private String Name;

    public String Continent;

    private double CO2_Emission;

    public Color color;

    public boolean is_selected;

    public int rank;

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
         this.color = Color.green;
         this.is_selected = false;
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

    /**
     * Get the country's respective color.
     * @return Color object representing the country's current color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * Set the country's respective color.
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Getter for is_selected.
     * @return boolean value representing whether the country was selected or not.
     */
    public boolean getSelected() {
        return this.is_selected;
    }

    /**
     * Setter for is_selected.
     */
    public void setSelected(boolean selection) {
        this.is_selected = selection;
    }

    /**
     * Get the country's ranking in the list of all countries and their CO2 emissions.
     * @return integer value representing the country's rank in the aforementioned list
     */
    public int getRank() { return this.rank; }

    /**
     * Set the country's ranking in the list of all countries and their CO2 emissions.
     */
    public void setRank(int rank) { this.rank = rank; }

}
