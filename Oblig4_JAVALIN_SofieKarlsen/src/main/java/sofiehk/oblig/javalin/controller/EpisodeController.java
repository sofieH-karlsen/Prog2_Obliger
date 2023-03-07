package sofiehk.oblig.javalin.controller;

import io.javalin.http.Context;
import sofiehk.oblig.javalin.model.Episode;
import sofiehk.oblig.javalin.repo.TvSerieRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;

public class EpisodeController {

    private TvSerieRepository tvSerieRepository;
    public EpisodeController(TvSerieRepository tvSerieRepository){
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getEpisoderISesong(Context context){
        String serieTittel = context.pathParam("tvserie-id");
        int sesong = Integer.parseInt(context.pathParam("sesong-nr"));
        String sortering = context.queryParam("sortering");

        ArrayList<Episode> episoderISesong = tvSerieRepository.getEpisoderISesong(serieTittel,sesong);


        switch (sortering) {
            case "episodenr" -> episoderISesong.sort(new Comparator<Episode>() {
                @Override
                public int compare(Episode ep1, Episode ep2) {
                    return ep1.getEpisodeNr() - ep2.getEpisodeNr();
                }
            });
            case "tittel" -> episoderISesong.sort(new Comparator<Episode>() {
                @Override
                public int compare(Episode ep1, Episode ep2) {
                    return ep1.getTittel().compareTo(ep2.getTittel());
                }
            });
            case "spilletid" -> episoderISesong.sort(new Comparator<Episode>() {
                @Override
                public int compare(Episode ep1, Episode ep2) {
                    return ep1.getSpilletid() - ep2.getSpilletid();
                }
            });
        }


        context.json(episoderISesong);


    }

    public void getEpisode(Context context){
        String serieTittel = context.pathParam("tvserie-id");
        int sesong = Integer.parseInt(context.pathParam("sesong-nr"));
        int episode = Integer.parseInt(context.pathParam("episode-nr"));

        Episode ep = tvSerieRepository.getEpisode(serieTittel,sesong,episode);

        context.json(ep);
    }


}
