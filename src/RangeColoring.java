package src;

import java.awt.*;

public class RangeColoring {

    public static void main(String[] args) {
        CountryIteratorBasic basicIterator = new CountryIteratorBasic(new World());

        Color range1Color = new Color(51, 204, 255);
        Color range2Color = new Color(51, 153, 255);
        Color range3Color = new Color(0, 0, 255);
        Color range4Color = new Color(0, 0, 204);
        Color range5Color = new Color(0, 0, 153);

        Country currCountry;

        while(basicIterator.hasNext()){
            currCountry = basicIterator.getNext();
            if(currCountry.getCO2_Emission() < 2.29) currCountry.color = range1Color;
            if(currCountry.getCO2_Emission() < 5.35) currCountry.color = range2Color;
            if(currCountry.getCO2_Emission() < 9.02) currCountry.color = range3Color;
            if(currCountry.getCO2_Emission() < 15.0) currCountry.color = range4Color;
            if(currCountry.getCO2_Emission() > 15.0) currCountry.color = range5Color;
            currCountry.is_selected = true;
        }

    }

}
