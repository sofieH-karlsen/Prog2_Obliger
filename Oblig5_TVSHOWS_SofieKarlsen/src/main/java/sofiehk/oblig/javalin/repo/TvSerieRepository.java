package sofiehk.oblig.javalin.repo;

import sofiehk.oblig.javalin.model.Episode;
import sofiehk.oblig.javalin.model.TvSerie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

public interface TvSerieRepository {
    Collection<TvSerie> getAlleTvSerier();

    TvSerie getTvSerie(String serieTittel);

    ArrayList<Episode> getEpisoderISesong(String serieTittel, int sesong);

    Episode getEpisode(String serieTittel, int sesong, int episode);

    void lesDataIgjen ();

    Episode newEpisode(String serieTittel, String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid, LocalDate utgivelsesdato, String bildeUrl);

    void updateEpisode();

    Episode deleteEpisode(String serieTittel, int sesong, int episode);

}
