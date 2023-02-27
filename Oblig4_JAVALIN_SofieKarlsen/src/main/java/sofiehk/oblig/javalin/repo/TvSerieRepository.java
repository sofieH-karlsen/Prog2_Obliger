package sofiehk.oblig.javalin.repo;

import sofiehk.oblig.javalin.model.TvSerie;

import java.util.ArrayList;

public interface TvSerieRepository {
    ArrayList<TvSerie> getAlleTvSerier();

    TvSerie getTvSerie(String serieTittel);


}
