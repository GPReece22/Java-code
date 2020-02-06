public class RugbyTeam implements Comparable <RugbyTeam> {

    private String teamName;
    private int gamesPlayed;
    private int gamesWon;
    private int gamesLost;
    private int gamesDrawn;

    private int points;
    private int ptsFor;
    private int ptsAgainst;
    private int ptsDiff;



    public RugbyTeam (String teamName){

        this.teamName = teamName;
        this.gamesPlayed = 0;
        this.gamesWon = 0;
        this.gamesLost = 0;
        this.gamesDrawn = 0;
        this.points = 0;
        this.ptsFor = 0;
        this.ptsAgainst = 0;
        this.ptsDiff =0;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    public int getGamesLost() {
        return gamesLost;
    }

    public int getGamesDrawn() {
        return gamesDrawn;
    }

    public int getPoints() {
        return points;
    }

    public int getPtsFor() {
        return ptsFor;
    }

    public int getPtsAgainst() {
        return ptsAgainst;
    }

    public int getPtsDiff() {
        return ptsDiff;
    }

    public void playMatch(int scored, int conceded) {

        this.ptsFor += scored;
        this.ptsAgainst += conceded;

        if (scored > conceded){
            gamesWon += 1;
        }

        if (scored < conceded){
            gamesLost += 1;
        }
        else {
            gamesDrawn +=1;
        }
    }

    @Override
    public int compareTo(RugbyTeam rugbyTeam) {
        if (rugbyTeam.points > this.points) {
            return 1;
        }
        if (rugbyTeam.points < this.points) {
            return -1;
        }
        else {
            return 0;
        }
    }
    public void printTableLine(){
        final String formatString = "%-15s %2d %2d %2d %4d %4d %4d %3d";
    }
}

