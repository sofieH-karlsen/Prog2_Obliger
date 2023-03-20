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

        TvSerie csm = new TvSerie("Chainsaw Man","Denji is a young boy who works as a Devil Hunter with the “Chainsaw Devil” Pochita. One day he got betrayed and killed. As he was losing his consciousness, he made a deal with Pochita, and got resurrected as the “Chainsaw Man”: the owner of the Devil’s heart.", LocalDate.of(2022,10,12),csmEp,"https://www.crunchyroll.com/imgsrv/display/thumbnail/1200x675/catalog/crunchyroll/ea075b926e1073f4eb016bff8cdb434c.jpe");

        Episode csmEp1 = new Episode("Dog & Chainsaw","Denji is a teenager who lives his life as a Devil Hunter, to pay off his fathers debt, with his buddy, the chainsaw devil Pochita. He gets betrayed and killed by the yakuza. As Denji starts passing out, he hears someone calling from inside his head...",
                1, 1, 25,LocalDate.of(2022,10,11),
                new Person("Ryuu", "Nakayama",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/9b90e481-4b79-47e1-a919-3d0a46752177/1200/1200/False/chainsaw-man-vol-1.jpg");

        Episode csmEp2 = new Episode("Arrival in Tokyo","Denji arrives at the Devil Hunters Headquarters in Tokyo, and gets introduced to Aki Hayakawa, a senior hunter that he was supposed to partner with. But then Hayakawa beats Denji up, and demands that he “quit this job”...",
                2, 1, 23,LocalDate.of(2022,10,18),
                new Person("Touko","Yatabe",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/05f086d4-0b95-4966-9ee1-861c30afd7ca/1200/1200/False/chainsaw-man-vol-2.jpg");

        Episode csmEp3 = new Episode("Meowy's Wherabouts",
                "Denji decides that his new dream is. His partner, Power the Blood Fiend, offers to help him realise it, only if he rescues her old pet cat Meowy from a devil. With his dream in sight, Denji is all fired up and ready to go, until...",
                3, 1, 24, LocalDate.of(2022,10,25),
                new Person("Hironori","Tanaka",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://www.matsurinerd.com/73013-large_default/Chainsaw-Man-Vol-3-ITA-.jpg");

        csm.leggTilEpisode(csmEp1);
        csm.leggTilEpisode(csmEp2);
        csm.leggTilEpisode(csmEp3);

        ArrayList<Episode> jjkEp = new ArrayList<>();

        TvSerie jjk = new TvSerie("Jujutsu Kaisen","The heroic tale of a boy who became a curse to exorcise a curse, a life from which he could never turn back.",LocalDate.of(2020,10,3),jjkEp,"https://oyster.ignimgs.com/wordpress/stg.ign.com/2021/02/jujutsu-kaisen.jpg");

        Episode jjke1 = new Episode("Ryomen Sukuna",
                "Itadori Yuji is a high school student with exceptional physical abilities. On the night his grandfather dies he meets Fushiguro Megumi from Jujutsu High. Fushiguro had come there to retrieve the cursed object that Itadori had picked up, but it was currently in the possession of Itadori's upperclassmen who were trying to remove its seal. The upperclassmen are then attacked by monsters drawn there by the cursed object as Itadori and Fushiguro race to their rescue.",
                1, 1, 24, LocalDate.of(2020,10,2),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/44717797-1fe9-475e-bca1-fe8aa6d0e7d8/1200/1200/False/jujutsu-kaisen-vol-1.jpg");
        Episode jjke2 = new Episode("For Myself",
                "Itadori wakes up in an unfamiliar room and before him rests Gojo Satoru, a teacher at Jujutsu High, who declares Itadori's secret execution has been decided upon. Gojo presents Itadori with two options. He can be executed immediately, or he can hunt down all 20 of Ryomen Sukuna's fingers and die after absorbing all of them...",
                2, 1, 23, LocalDate.of(2020,10,9),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"http://prodimage.images-bn.com/pimages/9781974710034_p0_v1_s1200x630.jpg");
        Episode jjke3 = new Episode("Girl of Steel",
                "Itadori, Fushiguro, and Gojo head out to meet up with the third first year, Kugizaki Nobara. Thereafter they head to an abandoned building where Gojo tasks Itadori and Kugizaki with exorcising the curses lurking inside. Once inside the building Itadori and Kugizaki split up to look for the curses and Kugizaki faces off against a cunning curse that takes a child hostage.",
                3, 1, 25, LocalDate.of(2020,10,16),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/47bf275b-1025-4ce4-bf29-416093f71b3f/353/569/90/False/jujutsu-kaisen-vol-3.jpg");
        Episode jjke4 = new Episode("Curse Womb Must Die",
                "An emergency breaks out at a juvenile detention center and Itadori, Fushiguro, and Kugisaki are dispatched to handle it. Their mission is to verify and rescue any survivors left inside with the curse womb that could develop into a special grade cursed spirit. Itadori and the others storm in to find a merciless reality waiting for them. Immediately thereafter, Kugisaki disappears and the special grade cursed spirit appears beside Itadori and Fushiguro.",
                4, 1, 23, LocalDate.of(2020,10,23),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/b9f52e71-0658-4e21-9d3c-d25d9a51fd21/1200/1200/False/jujutsu-kaisen-vol-4.jpg");
        Episode jjke5 = new Episode("Curse Womb Must Die -II-",
                "After retreating outside the juvenile detention center, Fushiguro notices the death of the special grade cursed spirit. The very next moment Ryomen Sukuna appears beside him, and rips Itadori's heart from his body to take him hostage. Fushiguro begins fighting Sukuna to prevent Itadori from dying when he regains control, but he becomes painfully aware of the difference in their strength.",
                5, 1, 22, LocalDate.of(2020,10,30),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://m.media-amazon.com/images/I/51ZJp3AdtWL._AC_UF1000,1000_QL80_.jpg");
        Episode jjke6 = new Episode("After Rain",
                "Gojo stews in his frustration over Itadori's death. Both Fushiguro and Nobara are depressed by their teammate's death, but they begin their special training with the second year students to get stronger. Meanwhile, Geto and the others begin to make their move. And during all of that, the dead Itadori...",
                1, 2, 23, LocalDate.of(2020,11,6),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/3bbd8ec8-6cb6-48e2-956b-7721e3bcca3c/1200/1200/False/jujutsu-kaisen-vol-6.jpg");
        Episode jjke7 = new Episode("Assault",
                "While in transit Gojo is suddenly attacked by the special grade cursed spirit Jogo. After launching several attacks that never hit--Jogo comes face to face with Gojo's strength. In an instant Gojo returns to Jujutsu High and easily picks up mid-training Itadori which causes Jogo's anger to erupt. He takes his next move, to which Gojo--",
                2, 2, 25, LocalDate.of(2020,11,13),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/38063b36-ba76-4cda-bcbc-096c1ea7adb1/1200/1200/False/jujutsu-kaisen-vol-7.jpg");
        Episode jjke8 = new Episode("Boredom",
                "While they're training for the exchange event, Kugisaki and Fushiguro come face to face with Kyoto's Jujutsu High second years - Zen'in Mai and Todo - who challenge them to a fight. Todo overwhelms Fushiguro with physical strength. Meanwhile, Kugisaki is disgusted by Mai's comments and says something to provoke her, but-",
                3, 2, 22, LocalDate.of(2020,11,20),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/22af78ba-0eeb-44e0-ab5e-20a4a890ade9/1200/1200/False/jujutsu-kaisen-vol-8.jpg");
        Episode jjke9 = new Episode("Small Fry and Reverse Retribution",
                "Yoshino Junpei skips school to go to a movie theater, but then he witnesses the classmates who bullied him getting their faces transfigured and dying. He chases after the culprit and calls out to them. Later, Itadori and the ex-salaryman first-grade jujutsu sorcerer, Nanami Kento, storm into the scene of the crime within the theater and encounter two cursed spirits.",
                4, 2, 24, LocalDate.of(2020,11,27),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://cdn.verasia.eu/17165-big_default_2x/jujutsu-kaisen-vol-9-sorcery-fight.jpg");
        Episode jjke10 = new Episode("Idle Transfiguration",
                "Itadori is placed in charge of investigating Yoshino, so he turns to his assistant supervisor, Ijichi for a plan. Their plan to have a low-level curse attack Yoshino and gauge his response fails, so Itadori speaks to him directly. After watching Itadori ultimately drive away the teacher he hated, Yoshino decides to hear him out. Meanwhile, Nanami has pinned down Mahito's base and he delves into the underground sewers to face Mahito.",
                5, 2, 25, LocalDate.of(2020,12,4),
                new Person("Gege","Akutami",LocalDate.of(2000, 9, 25)),new ArrayList<Rolle>(),"https://kbimages1-a.akamaihd.net/f27c8cab-7f00-46d6-b5d2-da78775ae154/1200/1200/False/jujutsu-kaisen-vol-10.jpg");

        jjk.leggTilEpisode(jjke1);
        jjk.leggTilEpisode(jjke2);
        jjk.leggTilEpisode(jjke3);
        jjk.leggTilEpisode(jjke4);
        jjk.leggTilEpisode(jjke5);
        jjk.leggTilEpisode(jjke6);
        jjk.leggTilEpisode(jjke7);
        jjk.leggTilEpisode(jjke8);
        jjk.leggTilEpisode(jjke9);
        jjk.leggTilEpisode(jjke10);

        tvSerier.add(csm);
        tvSerier.add(jjk);

    }

    @Override
    public ArrayList<TvSerie> getAlleTvSerier() {
       return new ArrayList<>(tvSerier);
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
        //return getTvSerie(serieTittel).hentEpisoderISesong(sesong);
        ArrayList<Episode> epISerie = getTvSerie(serieTittel).getEpisoder();
        ArrayList<Episode> episoderISesong = new ArrayList<>();

        for (Episode ep : epISerie){
            if (ep.getSesongNummer() == sesong){
                episoderISesong.add(ep);
            }
        }
        return episoderISesong;

    }

    @Override
    public Episode getEpisode(String serieTittel, int sesong, int episode) {
        return getTvSerie(serieTittel).getEpisode(sesong,episode);
    }
}
