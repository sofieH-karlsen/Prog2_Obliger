import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();


        TvSerie csm = new TvSerie("Chainsaw Man","Denji is a young boy who works as a Devil Hunter with the “Chainsaw Devil” Pochita. \nOne day he got betrayed and killed. \nAs he was losing his consciousness, he made a deal with Pochita, and got resurrected as the “Chainsaw Man”: the owner of the Devil’s heart.", LocalDate.of(2022,10,12),new ArrayList<Episode>() );

        csm.leggTilEpisode(new Episode("Dog & Chanisaw", 1, 1, 25 ));
        csm.leggTilEpisode(new Episode("Arrival in Tokyo", 2, 1, 23 ));
        csm.leggTilEpisode(new Episode("Meowy's Wherabouts", 3, 1, 23 ));

        System.out.println(csm.getTittel() + "\n '" + csm.getBeskrivelse() + "' \n " + csm.getEpisoder());
        System.out.println();


        TvSerie jjk = new TvSerie("Jujutsu Kaisen","The heroic tale of a boy who became a curse to exorcise a curse, a life from which he could never turn back.",LocalDate.of(2020,10,3),new ArrayList<Episode>() );

        for (int s =1; s < 6 ; s++) {
            for (int i = 1; i < 21; i++) {
                String t = Integer.toString(i);
                jjk.leggTilEpisode(new Episode("Episode " + t, i, s, random.nextInt(30 - 20) + 20));
            }
        }


        ArrayList <Episode> episoderSesong4 = new ArrayList<>(jjk.hentEpisoderISesong(4));
        System.out.println("Alle episodene i sesong 4:\n" + episoderSesong4);

        System.out.println();

        System.out.println("Tv-serien " + jjk.getTittel() + " har en total spilletid på " + jjk.getSumSpilletid() + " minutter, hvor episodene har en gjennomsnittlig spilletid på " + jjk.getGjennomsnittligSpilletid());

        System.out.println();

        csm.leggTilEpisode(new Episode("feil", 23, 6));
        csm.leggTilEpisode(new Episode("feil", 23, 0));
        jjk.leggTilEpisode(new Episode("feil", 11, 12));
        jjk.leggTilEpisode(new Episode("Episode 21", 21, 5,random.nextInt(30 - 20) + 20));

    }
}
