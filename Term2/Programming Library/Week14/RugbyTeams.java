import java.util.ArrayList;
import java.util.Collections;

public class RugbyTeams {

    private static final String LEAGUE_NAME = "Betfred Super League";
    private ArrayList <RugbyTeam> newLeague;
    public RugbyTeams() {
        this.newLeague = new ArrayList<> ();
    }

    public void addTeam (RugbyTeam rugbyTeam){
        this.newLeague.add(rugbyTeam);
    }
    public void sortLeague() {
        Collections.sort(newLeague);
    };
    public void printLeague(){
        for (RugbyTeam rugbyTeam: newLeague){
            rugbyTeam.printTableLine();
        }
    }
}
