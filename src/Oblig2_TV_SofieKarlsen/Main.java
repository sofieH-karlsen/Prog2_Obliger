package Oblig2_TV_SofieKarlsen;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Oppgave 2.2
        TvSerie csm = new TvSerie("Chainsaw Man","Denji is a young boy who works as a Devil Hunter with the “Chainsaw Devil” Pochita. One day, as he was living his miserable life trying to pay off the debt he inherited from his parents, he got betrayed and killed. As he was losing his consciousness, he made a deal with Pochita, and got resurrected as the “Chainsaw Man”: the owner of the Devil’s heart.", LocalDate.of(2022,10,12),new ArrayList<Episode>() );
        csm.leggTilEpisode(new Episode("Dog & Chanisaw", 1, 1, 25 ));
        csm.leggTilEpisode(new Episode("Arrival in Tokyo", 2, 1, 23 ));
        csm.leggTilEpisode(new Episode("Meowy's Wherabouts", 3, 1, 23 ));

        System.out.println(csm.getEpisoder());
    }
}
