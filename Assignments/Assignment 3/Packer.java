import java.util.ArrayList;
import java.util.Arrays;

public class Packer {
    private String name;
    private double wagePerBox;
    private int packed;



    public Packer(String name, double wagePerBox, int packed) {
        this.name = name;
        this.wagePerBox = wagePerBox;
        this.packed = packed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWagePerBox() {
        return wagePerBox;
    }

    public void setWagePerBox(double wagePerBox) {
        this.wagePerBox = wagePerBox;
    }

    public int getPacked() {
        return packed;
    }

    public void setPacked(int packed) {
        this.packed = packed;
    }

    public double totalWage() {
        this.totalWage(getWagePerBox() * getPacked());
    }

    public static void main(String[] args) {
        Packer bob = new Packer("Bob", 1.55, 100);

    }
}