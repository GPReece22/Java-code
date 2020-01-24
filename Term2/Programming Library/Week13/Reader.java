import java.util.Scanner;
import java.util.ArrayList;

public class Reader {

    private ArrayList <Integer> temperatures;

    public Reader(ArrayList<Integer> temperatures) {
        this.temperatures = new ArrayList<>();
    }

    public ArrayList<Integer> getTemperatures() {
        return temperatures;
    }

    public void setTemperatures(ArrayList<Integer> temperatures) {
        this.temperatures = temperatures;
    }
    public void addTemperatures(temperatures newTemp) {
        this.temperatures.add (newTemp);
    }



    public static void main (String[] args) {

        Scanner in = new Scanner (System.in);

        System.out.print ("Enter the temperature: ");
        String s = in.nextLine ();

        //for loop in here
        for (int i = 0; 1 < 5;) {
            try {
                if (s.endsWith("C")) {
                    int temp = Integer.parseInt(s.substring(0, s.length() - 1));
                    temperatures.add(temp);
                    //System.out.println("temp = " + temp);
                    ++i;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.out.println("Wrong format");
            }
        }


    }
}
