package sofiehk.oblig.javalin.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import sofiehk.oblig.javalin.model.Episode;
import sofiehk.oblig.javalin.model.TvSerie;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TvSerieJSONRepository implements TvSerieRepository{
    List<TvSerie> tvSerierJSON = new ArrayList<>(getData("src/main/resources/JSON/tvshows_10.json"));

    public List<TvSerie> getData(String filepath){
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            objectMapper.registerModule(new JavaTimeModule());
            TvSerie[] serieArray = objectMapper.readValue(new File(filepath), TvSerie[].class);
            return Arrays.asList(serieArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
            return new ArrayList<>();
    };

    @Override
    public ArrayList<TvSerie> getAlleTvSerier() {
        return new ArrayList<>(tvSerierJSON);
    }

    @Override
    public TvSerie getTvSerie(String serieTittel) {
        for (TvSerie serie : tvSerierJSON) {
            if (serie.getTittel().equalsIgnoreCase(serieTittel)){
                return serie;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Episode> getEpisoderISesong(String serieTittel, int sesong) {
        return getTvSerie(serieTittel).hentEpisoderISesong(sesong);

    }

    @Override
    public Episode getEpisode(String serieTittel, int sesong, int episode) {
        return getTvSerie(serieTittel).getEpisode(sesong,episode);
    }
}
