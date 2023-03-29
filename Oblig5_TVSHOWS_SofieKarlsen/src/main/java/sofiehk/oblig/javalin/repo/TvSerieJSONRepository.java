package sofiehk.oblig.javalin.repo;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import sofiehk.oblig.javalin.model.Episode;
import sofiehk.oblig.javalin.model.Person;
import sofiehk.oblig.javalin.model.TvSerie;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TvSerieJSONRepository implements TvSerieRepository{
    List<TvSerie> tvSerierJSON = new ArrayList<>();

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
    public static void writeToJson(List<TvSerie> tvSeries, String filepath){
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File(filepath);

        try {
            objectMapper.registerModule(new JavaTimeModule());
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(file,tvSeries);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public TvSerieJSONRepository(){
        tvSerierJSON.addAll(getData("src/main/resources/JSON/tvshows_10_with_roles.json"));
    };
    @Override
    public List<TvSerie> getAlleTvSerier() {
        return tvSerierJSON;
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

    @Override
    public void lesDataIgjen() {
        tvSerierJSON.addAll(getData("src/main/resources/JSON/tvshows_10_with_roles.json"));

    }

    @Override
    public Episode newEpisode(String serieTittel, String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid,LocalDate utgivelsesdato, String bildeUrl) {
        Episode ep = new Episode(tittel,beskrivelse,episodeNummer,sesongNummer,spilletid,utgivelsesdato,new Person(),new ArrayList<>(),bildeUrl);
        getTvSerie(serieTittel).leggTilEpisode(ep);
        writeToJson(tvSerierJSON, "src/main/resources/JSON/tvshows_10_with_roles.json");
        return ep;
    }

    @Override
    public void updateEpisode() {

    }

    @Override
    public Episode deleteEpisode(String serieTittel, int sesong, int episode) {
        Episode ep = getEpisode(serieTittel,sesong,episode);
        getTvSerie(serieTittel).getEpisoder().remove(ep);
        writeToJson(tvSerierJSON, "src/main/resources/JSON/tvshows_10_with_roles.json");
        return ep;

    }
}
