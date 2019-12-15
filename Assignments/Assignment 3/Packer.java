import java.util.ArrayList;
import java.util.Arrays;
import java.text.NumberFormat;
import java.util.Locale;

public class Packer {
    private String name;
    private int packed;
    private double totalWage;



    public Packer(String name, int packed) {
        this.name = name;
        this.packed = packed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPacked() {
        return packed;
    }

    public void setPacked(int packed) {
        this.packed = packed;
    }

    public double getTotalWage() {
        return totalWage;
    }

    public void setTotalWage() {
        if (packed <= 50) {
            this.totalWage = 1.11 * packed;
        }
        else {
        this.totalWage = ((packed - 50) * 1.25) + (50 * 1.11);
        }
    }

    @Override
    public String toString() {
        return "Packer{" +
                "name='" + name + '\'' +
                ", packed=" + packed +
                '}';
    }

    public static void main(String[] args) {
        Locale locale = new Locale ("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance (locale);

        Packer steve = new Packer("Steve", 127);
        steve.setTotalWage();
        Packer gary = new Packer("Gary", 103);
        gary.setTotalWage();
        Packer tony = new Packer("Tony", 473);
        tony.setTotalWage();
        Packer saad = new Packer("Saad", 129);
        saad.setTotalWage();
        Packer rubiya = new Packer("Rubiya", 117);
        rubiya.setTotalWage();

        System.out.println(steve);
        System.out.println("Steve's total wages are " + cf.format(steve.getTotalWage()));
    }
}

