import java.util.ArrayList;
import java.util.Collections;

public class PackingTeam {

    private ArrayList <Packer> Packers;

    public PackingTeam () {
        this.Packers = new ArrayList<>();
    }

    public ArrayList<Packer> getPackers() {
        return Packers;
    }

    public void setPackers(ArrayList<Packer> packers) {
        Packers = packers;
    }

    public void addPacker (Packer newPacker) {
        this.Packers.add (newPacker);
    }

    public int getTotalPacked() {

        int packed = 0;

        for (Packer s: this.Packers) {
            packed += s.getPacked();
        }

        return packed;
    }


    public int getTotalWages() {

        int wages = 0;

        for (Packer s: this.Packers) {
            wages += s.getTotalWage();
        }

        return wages;
    }

    public int setWages() {
        for (Packer s: this.Packers) {
            s.setTotalWage();
        }
        return getTotalWages();
    }

    public void sortPackers() {
        Collections.sort (this.Packers);
    }

    public void printPackers() {
        for (Packer s: this.Packers)
            System.out.println(s);
    }


}
