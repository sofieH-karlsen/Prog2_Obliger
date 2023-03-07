package sofiehk.oblig.javalin.controller;

import io.javalin.http.Context;
import sofiehk.oblig.javalin.model.Episode;
import sofiehk.oblig.javalin.repo.TvSerieRepository;

import java.util.ArrayList;

public class EpisodeController {

    private TvSerieRepository tvSerieRepository;
    public EpisodeController(TvSerieRepository tvSerieRepository){
        this.tvSerieRepository = tvSerieRepository;
    }

    public void getEpisoderISesong(Context context){
        String serieTittel = context.pathParam("tvserie-id");
        int sesong = Integer.parseInt(context.pathParam("sesong-nr"));

        ArrayList<Episode> episoderISesong = tvSerieRepository.getEpisoderISesong(serieTittel,sesong);

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
