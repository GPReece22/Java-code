import java.util.ArrayList;
import java.util.Arrays;
import java.text.NumberFormat;
import java.util.Locale;

public class Packer implements Comparable <Packer> {
    private String name;
    private int packed;
    private double totalWage;



    public Packer(String name, int packed, int totalWage) {
        this.name = name;
        this.packed = packed;
        this.totalWage = totalWage;
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
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);
        return "Packer{" +
                "name='" + name + '\'' +
                ", packed='" + packed + '\'' +
                ", wages='" + cf.format(totalWage) + '\'' +
                '}';
    }

    @Override
    public int compareTo(Packer packer) {
        return packer.packed - this.packed;
    }
}
