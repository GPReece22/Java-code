import java.text.NumberFormat;
import java.util.Locale;

public class Output {

    public static void main(String[] args) {
        Locale locale = new Locale("en", "GB");
        NumberFormat cf = NumberFormat.getCurrencyInstance(locale);

        PackingTeam packingTeam = new PackingTeam();

        packingTeam.addPacker(new Packer("Steve", 127, 0));
        packingTeam.addPacker(new Packer("Gary", 103, 0));
        packingTeam.addPacker(new Packer("Tony", 473, 0));
        packingTeam.addPacker(new Packer("Saad", 129, 0));
        packingTeam.addPacker(new Packer("Rubiya", 117, 0));

        packingTeam.setWages();
        packingTeam.sortPackers();
        packingTeam.printPackers();
        System.out.println("Total crackers packed: " + packingTeam.getTotalPacked());
        System.out.println("Total wages to pay: " + cf.format(packingTeam.getTotalWages()));
    }
}
