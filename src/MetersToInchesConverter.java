

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.GregorianCalendar;

class MetersToInchesConverter {

    static boolean processRepeatConversion (String userInput) {
        boolean repeatConversion = false;
        if (((userInput.equals("y")) || (userInput.equals("Y")))) {
            repeatConversion = true;
        }
        return repeatConversion;
    }

    static String[] convertMetersToInches (String metersToConvertString) {
        String[] conversionResult = new String[2];
        double conversionFactor = 39.37;
        try {
            double metersToConvertDouble = Double.parseDouble(metersToConvertString);
            double inchesDouble = metersToConvertDouble*conversionFactor;
            String inchesString = Double.toString(inchesDouble);
            conversionResult[0] = "CONVERSION RESULT: " + metersToConvertString + " m = " + inchesString + " inches";
            conversionResult[1] = "Do you want to convert another number?";
        } catch (NumberFormatException nfe) {
            if (nfe.getMessage().equals("empty String")) {
                conversionResult[0] = "CONVERSION FAILED: " + "You forgot to specify the number of meters.";
            } else {
                conversionResult[0] = "CONVERSION FAILED: " + "\"" + metersToConvertString + "\" is not a number.";
            }
            conversionResult[1] = "Do you want to try once more?";
        }
        return conversionResult;

    }


    public static void main (String[] args) throws IOException {
        String s;
        System.out.println("METERS TO INCHES CONVERTER WELCOMES YOU!");
        do {
            BufferedReader buff = new BufferedReader(
                    new InputStreamReader(System.in));
            System.out.print("Enter the number of meters (m) to convert into inches: ");
            System.out.flush();
            s = buff.readLine();
            String result[] = convertMetersToInches (s);
            System.out.println(result[0]);
            System.out.print(result[1] + " (Type \"y\" for \"yes\", any other symbol for \"no\".): ");
            System.out.flush();
            s = buff.readLine();
        } while (processRepeatConversion(s));
        System.out.println("THANKS FOR USING OUR CONVERTER. BYE!");


    }
}































