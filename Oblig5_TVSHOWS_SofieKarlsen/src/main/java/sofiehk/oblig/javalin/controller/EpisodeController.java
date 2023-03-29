package sofiehk.oblig.javalin.controller;

import io.javalin.http.Context;
import sofiehk.oblig.javalin.model.Episode;
import sofiehk.oblig.javalin.model.Produksjon;
import sofiehk.oblig.javalin.repo.TvSerieRepository;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class EpisodeController {

    private TvSerieRepository tvSerieRepository;

    public EpisodeController(TvSerieRepository tvSerieRepository) {
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getEpisoderISesong(Context context) {
        String serieTittel = context.pathParam("tvserie-id");
        String sesong = context.pathParam("sesong-nr");
        String sortering = context.queryParam("sortering");

        int sesongNr = sesong.isEmpty() ? 1 : Integer.parseInt(sesong);

        ArrayList<Episode> episoderISesong = tvSerieRepository.getEpisoderISesong(serieTittel, sesongNr);

        if (sortering != null) {
            switch (sortering) {
                case "episodenr" -> Collections.sort(episoderISesong);
                case "tittel" -> episoderISesong.sort((e1, e2) -> e1.getTittel().compareTo(e2.getTittel()));
                case "spilletid" -> episoderISesong.sort(Comparator.comparingInt(Produksjon::getSpilletid));
            }
        }
        context.json(episoderISesong);


    }

    public void getEpisode(Context context) {
        String serieTittel = context.pathParam("tvserie-id");
        int sesong = Integer.parseInt(context.pathParam("sesong-nr"));
        int episode = Integer.parseInt(context.pathParam("episode-nr"));

        Episode ep = tvSerieRepository.getEpisode(serieTittel, sesong, episode);

        context.json(ep);
    }

    public void deleteEpisode(Context context) {
        String serieTittel = context.pathParam("tvserie-id");
        int sesong = Integer.parseInt(context.pathParam("sesong-nr"));
        int episode = Integer.parseInt(context.pathParam("episode-nr"));

        context.json(tvSerieRepository.deleteEpisode(serieTittel, sesong, episode));

    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public void newEpisode(Context context) {
    String serieTittel = context.pathParam("tvserie-id");

    String tittel = context.formParam("tittel");
    String beskrivelse = context.formParam("beskrivelse");
    int episodeNummer = Integer.parseInt(Objects.requireNonNull(context.formParam("episodeNummer")));
    int sesongNummer = Integer.parseInt(Objects.requireNonNull(context.formParam("sesongNummer")));
    int spilletid = Integer.parseInt(Objects.requireNonNull(context.formParam("spilletid")));
    LocalDate utgivelsesdato = LocalDate.parse(Objects.requireNonNull(context.formParam("utgivelsesdato")),formatter);
    String bildeUrl = context.formParam("bildeUrl");

    Episode ep = tvSerieRepository.newEpisode(serieTittel,tittel, beskrivelse, episodeNummer, sesongNummer, spilletid, utgivelsesdato, bildeUrl);
    context.json(ep);
    }

}
