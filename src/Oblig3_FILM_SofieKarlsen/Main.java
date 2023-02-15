package Oblig3_FILM_SofieKarlsen;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random random = new Random();

        // Personer
        Person ghibli = new Person("Hayao","Miyazaki", "1941");
        Person yoshihara = new Person("Tatsuya","Yoshihara","1988");

        Person kimura = new Person("Takuya","Kimura", "1972");
        Person baishou = new Person("Chieko","Baishou","1941");

        Person toya = new Person("Kikunosuke","Kikunosuke", "1998");
        Person ai = new Person("Fairouz","Ai","1993");
        Person sakata =new Person("Shougo","Shougo", "1998");
        Person izawa = new Person("Shiori","Izawa ", "1987");

        // Serier
        TvSerie csm = new TvSerie("Chainsaw Man","Denji is a young boy who works as a Devil Hunter with the “Chainsaw Devil” Pochita. One day he got betrayed and killed. As he was losing his consciousness, he made a deal with Pochita, and got resurrected as the “Chainsaw Man”: the owner of the Devil’s heart.", LocalDate.of(2022,10,12),new ArrayList<Episode>() );

        TvSerie jjk = new TvSerie("Jujutsu Kaisen","The heroic tale of a boy who became a curse to exorcise a curse, a life from which he could never turn back.",LocalDate.of(2020,10,3),new ArrayList<Episode>() );

        //Episoder
        Episode csmEp1 = new Episode("Dog & Chainsaw","Denji is a teenager who lives his life as a Devil Hunter, to pay off his fathers debt, with his buddy, the chainsaw devil Pochita. He gets betrayed and killed by the yakuza. As Denji starts passing out, he hears someone calling from inside his head...",
                1, 1, 25,LocalDate.of(2022,10,11),
                new Person("Ryuu","Ryuu","1990"),new ArrayList<Rolle>());

        csm.leggTilEpisode(csmEp1);

        csm.leggTilEpisode(new Episode("Arrival in Tokyo","Denji arrives at the Devil Hunters Headquarters in Tokyo, and gets introduced to Aki Hayakawa, a senior hunter that he was supposed to partner with. But then Hayakawa beats Denji up, and demands that he “quit this job”...",
                2, 1, 23,LocalDate.of(2022,10,18),
                new Person("Touko","Yatabe","na"),new ArrayList<Rolle>()));

        csm.leggTilEpisode(new Episode("Meowy's Wherabouts",
                "Denji decides that his new dream is. His partner, Power the Blood Fiend, offers to help him realise it, only if he rescues her old pet cat Meowy from a devil. With his dream in sight, Denji is all fired up and ready to go, until...",
                3, 1, 23, LocalDate.of(2022,10,25),
                new Person("Hironori","Tanaka","1984"),new ArrayList<Rolle>()));

        csm.leggTilEpisode(new Episode("Rescue","After a fierce battle, Denji defeats the “Bat Devil” and rescues Power even after she had trapped him. As Denji gets thrilled with the idea of his dream coming true, he faces a sudden attack from out of nowhere...",
                4, 2,24,LocalDate.of(2022,11,1),yoshihara,new ArrayList<Rolle>()));


        for (int s =1; s < 6 ; s++) {
            for (int i = 1; i < 21; i++) {
                String t = Integer.toString(i);
                jjk.leggTilEpisode(new Episode("Episode " + t,"beskrivelse", i, s, random.nextInt(30 - 20) + 20));
            }
        }

        // Filmer
        Film kikisDelivery = new Film("Kiki's Delivery Service","A young witch, on her mandatory year of independent life, finds fitting into a new community difficult while she supports herself by running an air courier service.",103,LocalDate.of(1989,7,29),ghibli,new ArrayList<Rolle>());

        Film howlsCastle = new Film("Howl's Moving Castle","When an unconfident young woman is cursed with an old body by a spiteful witch, her only chance of breaking the spell lies with a self-indulgent yet insecure young wizard and his companions in his legged, walking castle.",119,LocalDate.of(2004,11,20),ghibli, new ArrayList<Rolle>());

        // Roller
        Rolle howl = new Rolle("Howl","", kimura);
        Rolle sophie = new Rolle("Sophie", "Hatter",baishou);
        ArrayList<Rolle> castleCast = new ArrayList<>();
            castleCast.add(howl);
            castleCast.add(sophie);
        howlsCastle.leggTilMangeRoller(castleCast);

        kikisDelivery.leggTilEnRolle(new Rolle("Kiki", "",new Person("Minami","Takayama", "1964")));

        Rolle sawBoi = new Rolle("Denji","", toya);
        Rolle fiend = new Rolle("Power", "", ai);
        Rolle gun = new Rolle("Aki", "Hayakawa",sakata);
        ArrayList<Rolle> csmCast = new ArrayList<>();
            


        csmEp1.leggTilEnRolle(sawBoi);
        csmEp1.leggTilEnRolle(new Rolle("Pochita","", izawa));





        // Utskrifter / Tester
        System.out.println(csm);
        System.out.println();

        /*
        ArrayList <Episode> episoderSesong4 = new ArrayList<>(jjk.hentEpisoderISesong(4));
        System.out.println("Alle episodene i sesong 4:\n" + episoderSesong4);
        */

        System.out.println();

        System.out.println("Tv-serien " + jjk.getTittel() + " har en total spilletid på " + jjk.getSumSpilletid() + " minutter, hvor episodene har en gjennomsnittlig spilletid på " + jjk.getGjennomsnittligSpilletid());

        System.out.println();

        csm.leggTilEpisode(new Episode("feil","FEIL", 23, 6,20));
        csm.leggTilEpisode(new Episode("feil","FEIL", 23, 0,20));
        jjk.leggTilEpisode(new Episode("feil","FEIL", 11, 12,20));
        jjk.leggTilEpisode(new Episode("Episode 21","Beskrivelse",21, 5,random.nextInt(30 - 20) + 20));

        System.out.println();

        System.out.println(kikisDelivery + "\n" + howlsCastle);



    }
}
