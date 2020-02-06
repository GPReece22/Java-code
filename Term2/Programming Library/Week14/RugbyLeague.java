public class RugbyLeague {
    public static void main(String[] args) {

        RugbyLeague superLeague = new RugbyLeague();

        RugbyTeam stHelens= new RugbyTeam("St Helens");
        RugbyTeam hullFc= new RugbyTeam("Hull FC");
        RugbyTeam huddersfieldGiants= new RugbyTeam("Huddersfield Giants");
        RugbyTeam hullKingstonRovers= new RugbyTeam("Hull Kingston Rovers");
        RugbyTeam castelefordTigers= new RugbyTeam("Casteleford Tigers");
        RugbyTeam wiganWarriors= new RugbyTeam("Wigan Warriors");
        RugbyTeam warringtonWolves= new RugbyTeam("Warrington Wolves");
        RugbyTeam wakefieldTrinity= new RugbyTeam("Wakefield Trinity");
        RugbyTeam torontoWolfpack= new RugbyTeam("Toronto Wolfpack");
        RugbyTeam catalanDragons= new RugbyTeam("Catalan Dragons");
        RugbyTeam leedsRhinos= new RugbyTeam("Leeds Rhinos");
        RugbyTeam salfordRedDevils= new RugbyTeam("Salford Red Devils");

        superLeague.addTeam(stHelens);
        superLeague.addTeam(hullFc);
        superLeague.addTeam(huddersfieldGiants);
        superLeague.addTeam(hullKingstonRovers);
        superLeague.addTeam(castelefordTigers);
        superLeague.addTeam(wiganWarriors);
        superLeague.addTeam(warringtonWolves);
        superLeague.addTeam(wakefieldTrinity);
        superLeague.addTeam(torontoWolfpack);
        superLeague.addTeam(catalanDragons);
        superLeague.addTeam(leedsRhinos);
        superLeague.addTeam(salfordRedDevils);

        huddersfieldGiants.playMatch(23,21);
        hullFc.playMatch(21,23);

        huddersfieldGiants.playMatch(34,12);
        leedsRhinos.playMatch(12,34);

        RugbyTeams.sortleague();

        System.out.println("The league table is as follows:");
        System.out.println();
        RugbyTeams.printLeague() ;
    }

    private void addTeam(RugbyTeam stHelens) {
    }
}
