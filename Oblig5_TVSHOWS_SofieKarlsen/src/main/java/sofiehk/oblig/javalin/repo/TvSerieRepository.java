package sofiehk.oblig.javalin.repo;

import sofiehk.oblig.javalin.model.Episode;
import sofiehk.oblig.javalin.model.TvSerie;

import java.util.ArrayList;

public interface TvSerieRepository {
    ArrayList<TvSerie> getAlleTvSerier();

    TvSerie getTvSerie(String serieTittel);

    ArrayList<Episode> getEpisoderISesong(String serieTittel, int sesong);

    Episode getEpisode(String serieTittel, int sesong, int episode);

    void lesInnData();

}
