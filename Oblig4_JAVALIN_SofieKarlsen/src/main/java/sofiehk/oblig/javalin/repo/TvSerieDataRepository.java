package sofiehk.oblig.javalin.repo;
import sofiehk.oblig.javalin.model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class TvSerieDataRepository implements TvSerieRepository{
    private ArrayList<TvSerie> tvSerier = new ArrayList<>();

    public TvSerieDataRepository(){
        createData();
    };
    public void createData() {
        ArrayList<Episode> csmEp = new ArrayList<>();

        TvSerie csm = new TvSerie("Chainsaw Man","Denji is a young boy who works as a Devil Hunter with the “Chainsaw Devil” Pochita. One day he got betrayed and killed. As he was losing his consciousness, he made a deal with Pochita, and got resurrected as the “Chainsaw Man”: the owner of the Devil’s heart.", LocalDate.of(2022,10,12),csmEp);

        Episode csmEp1 = new Episode("Dog & Chainsaw","Denji is a teenager who lives his life as a Devil Hunter, to pay off his fathers debt, with his buddy, the chainsaw devil Pochita. He gets betrayed and killed by the yakuza. As Denji starts passing out, he hears someone calling from inside his head...",
                1, 1, 25,LocalDate.of(2022,10,11),
                new Person("Ryuu Nakayama","1990"),new ArrayList<Rolle>());

        Episode csmEp2 = new Episode("Arrival in Tokyo","Denji arrives at the Devil Hunters Headquarters in Tokyo, and gets introduced to Aki Hayakawa, a senior hunter that he was supposed to partner with. But then Hayakawa beats Denji up, and demands that he “quit this job”...",
                2, 1, 23,LocalDate.of(2022,10,18),
                new Person("Touko Yatabe","na"),new ArrayList<Rolle>());

        Episode csmEp3 = new Episode("Meowy's Wherabouts",
                "Denji decides that his new dream is. His partner, Power the Blood Fiend, offers to help him realise it, only if he rescues her old pet cat Meowy from a devil. With his dream in sight, Denji is all fired up and ready to go, until...",
                3, 1, 23, LocalDate.of(2022,10,25),
                new Person("Hironori Tanaka","1984"),new ArrayList<Rolle>());

        csm.leggTilEpisode(csmEp1);
        csm.leggTilEpisode(csmEp2);
        csm.leggTilEpisode(csmEp3);

        ArrayList<Episode> jjkEp = new ArrayList<>();

        TvSerie jjk = new TvSerie("Jujutsu Kaisen","The heroic tale of a boy who became a curse to exorcise a curse, a life from which he could never turn back.",LocalDate.of(2020,10,3),jjkEp);

        Random random = new Random();
        for (int s =1; s < 3 ; s++) {
            for (int i = 1; i < 6; i++) {
                String t = Integer.toString(i);
                jjk.leggTilEpisode(new Episode("Episode " + t,"beskrivelse", i, s, random.nextInt((30 - 20) + 20),LocalDate.of(2020,s,i),new Person("Gege Akutami","ukjent"), new ArrayList<Rolle>()));
            }
        }

        tvSerier.add(csm);
        tvSerier.add(jjk);

    }

    @Override
    public ArrayList<TvSerie> getAlleTvSerier() {
       return tvSerier;
    }

    @Override
    public TvSerie getTvSerie(String serieTittel) {
        for (TvSerie serie : tvSerier) {
            if (serie.getTittel().equalsIgnoreCase(serieTittel)){
                return serie;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Episode> getEpisoderISesong(String serieTittel, int sesong) {
        ArrayList<Episode> epISerie = getTvSerie(serieTittel).getEpisoder();
        ArrayList<Episode> episoderISesong = new ArrayList<>();

        for (Episode ep : epISerie){
            if (ep.getSesongNr() == sesong){
                episoderISesong.add(ep);
            }
        }
        return episoderISesong;
    }

    @Override
    public Episode getEpisode(String serieTittel, int sesong, int episode) {
        ArrayList<Episode> sesongEpisoder = getEpisoderISesong(serieTittel,sesong);

        for (Episode ep : sesongEpisoder){
            if (ep.getEpisodeNr() == episode){
                return ep;
            }
        }
        return null;
    }
}
