package Oblig2_TV_SofieKarlsen;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Oppgave 2.2
        TvSerie csm = new TvSerie("Chainsaw Man","Denji is a young boy who works as a Devil Hunter with the “Chainsaw Devil” Pochita. One day he got betrayed and killed. As he was losing his consciousness, he made a deal with Pochita, and got resurrected as the “Chainsaw Man”: the owner of the Devil’s heart.", LocalDate.of(2022,10,12),new ArrayList<Episode>() );

        csm.leggTilEpisode(new Episode("Dog & Chanisaw", 1, 1, 25 ));
        csm.leggTilEpisode(new Episode("Arrival in Tokyo", 2, 1, 23 ));
        csm.leggTilEpisode(new Episode("Meowy's Wherabouts", 3, 1, 23 ));



        // Oppgave 2.4
        TvSerie serie = new TvSerie("Min favoritt","En veldig fin og kos beskrivelse av et fantastisk show",LocalDate.of(2000,9,25),new ArrayList<Episode>() );

        for (int s =1; s < 6 ; s++) {
            for (int i = 1; i < 21; i++) {
                String t = Integer.toString(i);
                serie.leggTilEpisode(new Episode("Episode " + t, i, s, 22));
            }
        }

        ArrayList <Episode> episoderSesong4 = new ArrayList<>(serie.hentEpisoderISesong(4));
        System.out.println(episoderSesong4);

        System.out.println(33/2);
        System.out.println(33%2);
    }
}
