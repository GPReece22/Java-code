import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

public class Reader {

    public static void main (String[] args) {
        int noOfReadings = 5;
        ArrayList<Integer> temperatures = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String readingIn;
        int value;

        for (int i = 0; i < noOfReadings; i++) {
            try {
                System.out.println("Enter reading " + (i + 1));
                readingIn = scanner.nextLine();
                value = Integer.parseInt(readingIn.substring(0, readingIn.length() - 1));
                temperatures.add(value);
                }
            catch (NumberFormatException e){
                System.out.println("Wrong format");
                i--;
            }
        }
        int tempsSum = 0;
        for(int reading : temperatures){
            tempsSum += reading;
        }

        System.out.println(temperatures.size() + " Readings");
        System.out.println( "The minimum Temperature is: " + Collections.min(temperatures));
        System.out.println( "The maximum Temperature is: " + Collections.max(temperatures));
        System.out.println( "The average Temperature is: " + (tempsSum / temperatures.size()));
    }
}