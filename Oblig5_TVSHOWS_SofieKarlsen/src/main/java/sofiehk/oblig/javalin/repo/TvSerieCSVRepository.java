package sofiehk.oblig.javalin.repo;

import sofiehk.oblig.javalin.model.Episode;
import sofiehk.oblig.javalin.model.Person;
import sofiehk.oblig.javalin.model.TvSerie;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class TvSerieCSVRepository implements TvSerieRepository{

    HashMap<Integer,TvSerie> tvSerieHashMap = new HashMap<>();

    public static ArrayList<TvSerie> readFromCSVFile(String filepath, String separator) {
        ArrayList<TvSerie> series = new ArrayList<>();
        ArrayList<Episode> alleEp = new ArrayList<>();
        ArrayList<Person> allePersoner = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))){
            String line;

            while((line = bufferedReader.readLine())!= null) {
                String[] parts = line.split(separator);

                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                // https://mkyong.com/java8/java-8-how-to-convert-string-to-localdate/

                String tv_name = parts[0];
                String tv_beskrivelse = parts[1];
                LocalDate tv_utgivelse = LocalDate.parse(parts[2], dateFormatter);
                String tv_bilde = parts[3];

                String ep_tittel = parts[4];
                String ep_beskrivelse = parts[5];
                int ep_episodeNr = Integer.parseInt(parts[6]);
                int ep_sesongNr = Integer.parseInt(parts[7]);
                int ep_spilletid = Integer.parseInt(parts[8]);
                LocalDate ep_utgivelse = LocalDate.parse(parts[9], dateFormatter);
                String ep_bilde = parts[10];

                String reg_fornavn = parts[11];
                String reg_etternavn = parts[12];
                LocalDate reg_fodselsDato = LocalDate.parse(parts[13], dateFormatter);


                TvSerie serie = new TvSerie(tv_name, tv_beskrivelse, tv_utgivelse, new ArrayList<Episode>(), tv_bilde);
                Episode ep = new Episode(ep_tittel, ep_beskrivelse, ep_episodeNr, ep_sesongNr, ep_spilletid, ep_utgivelse, new Person(), new ArrayList<>(), ep_bilde);
                Person pers = new Person(reg_fornavn, reg_etternavn, reg_fodselsDato);

                if(series.isEmpty()){
                    ep.setRegissor(pers);
                    serie.leggTilEpisode(ep);

                    alleEp.add(ep);
                    allePersoner.add(pers);

                    series.add(serie);
                }
                else if (!series.get(series.size()-1).getTittel().contains(serie.getTittel())) {

                    if (!allePersoner.get(allePersoner.size()-1).getFulltNavn().contains(pers.getFulltNavn())) {
                        allePersoner.add(pers);
                        ep.setRegissor(pers);
                    } else {
                        ep.setRegissor(allePersoner.get(allePersoner.size()-1));
                    }

                    serie.leggTilEpisode(ep);
                    series.add(serie);
                } else {
                    if (!allePersoner.get(allePersoner.size()-1).getFulltNavn().contains(pers.getFulltNavn())) {
                        allePersoner.add(pers);
                        ep.setRegissor(pers);
                    } else {
                        ep.setRegissor(allePersoner.get(allePersoner.size()-1));
                    }

                    series.get(series.size()-1).leggTilEpisode(ep);
                }



            }
        } catch (IOException e) {
            e.printStackTrace();
        }




        return series;
    }
    private static void writeToCSVFile (HashMap<Integer,TvSerie> tvserier, String filePath, String separator){
        //logikk til å skrive over til CSV
        // er inni try slik at det lukker seg automatisk når ferdig, uansett om feil eller ikke
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))){
            for (TvSerie serie: tvserier.values()) {
                for(Episode ep :serie.getEpisoder()){
                bufferedWriter.write(
                        serie.getTittel() + separator + serie.getBeskrivelse() + separator + serie.getUtgivelsesdato() + separator + serie.getBildeUrl() + separator + ep.getTittel() + separator + ep.getBeskrivelse() + separator + ep.getEpisodeNummer() + separator + ep.getSesongNummer() + separator + ep.getSpilletid() + separator + ep.getUtgivelsesdato() + separator + ep.getBildeUrl() + separator + ep.getRegissor().getFornavn() + separator + ep.getRegissor().getEtternavn() + separator + ep.getRegissor().getFodselsDato());
                bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }



    public TvSerieCSVRepository() {
        ArrayList<TvSerie> tvSerieArrayList = readFromCSVFile("src/main/resources/CSV/tvshows_10.csv",";");
        for (int i=1; i< tvSerieArrayList.size();i++){
            tvSerieHashMap.put(i,tvSerieArrayList.get(i-1));
        }
    }

    @Override
    public Collection<TvSerie> getAlleTvSerier() {
        return tvSerieHashMap.values();
    }

    @Override
    public TvSerie getTvSerie(String serieTittel) {
        for (TvSerie serie : tvSerieHashMap.values()) {
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

    }

    @Override
    public Episode newEpisode(String serieTittel, String tittel, String beskrivelse, int episodeNummer, int sesongNummer, int spilletid,LocalDate utgivelsesdato, String bildeUrl) {
        Episode ep = new Episode(tittel,beskrivelse,episodeNummer,sesongNummer,spilletid,utgivelsesdato,new Person(),new ArrayList<>(),bildeUrl);
        getTvSerie(serieTittel).leggTilEpisode(ep);
        return ep;
    }

    @Override
    public void updateEpisode() {

    }

    @Override
    public Episode deleteEpisode(String serieTittel, int sesong, int episode) {
        getTvSerie(serieTittel).getEpisoder().remove(getEpisode(serieTittel,sesong,episode));
        writeToCSVFile(tvSerieHashMap,"src/main/resources/CSV/tvshows_10.csv",";");
        return getTvSerie(serieTittel).getEpisode(sesong,episode);
    }
}
