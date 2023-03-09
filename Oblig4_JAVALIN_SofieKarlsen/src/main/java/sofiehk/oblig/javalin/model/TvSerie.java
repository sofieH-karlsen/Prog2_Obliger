package sofiehk.oblig.javalin.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class TvSerie implements Comparable<TvSerie>{
    private String tittel;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList <Episode> episoder;

    private String gjennomsnittligSpilletid;
    private int sumSpilletid;
     float gjennomsnittligSekunder;
     int gjennomsnittMinutter;

    private int antallSesonger;

    private String bildeUrl;



    public TvSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato, ArrayList episoder, String bildeUrl){
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        this.episoder = episoder;
        this.bildeUrl = bildeUrl;
    }

   public void leggTilEpisode(Episode episode){

       if (episode.getSesongNr() == antallSesonger + 1) {
           episoder.add(episode);
           oppdaterGjennomsnittligSpilletid(episode);
           antallSesonger = episode.getSesongNr();
       }
       else if (episode.getSesongNr() <= 0) {
           System.out.println("Er ikke mulig å registrere episoder med sesongNr null eller lavere");
       }
       else if (episode.getSesongNr() <= antallSesonger) {
           episoder.add(episode);
           oppdaterGjennomsnittligSpilletid(episode);
       }
       else {
           System.out.println("Går ikke ann å registrere episoder med sesongNr høyere enn " + (antallSesonger+1) + " på denne serien ");
       }
   }

    public ArrayList<Episode> hentEpisoderISesong(int sesong){
        ArrayList <Episode> episoderISesong = new ArrayList<>();
        for(Episode enEpisode : episoder){
            if(enEpisode.getSesongNr() == sesong){
                episoderISesong.add(enEpisode);
            }
        }
        return  episoderISesong;
    };

    private void oppdaterGjennomsnittligSpilletid(Episode ep){
        sumSpilletid += ep.getSpilletid();
        gjennomsnittMinutter = sumSpilletid / episoder.size();
        gjennomsnittligSekunder = ((sumSpilletid % episoder.size()) * 60) / episoder.size();
        gjennomsnittligSpilletid = gjennomsnittMinutter + " minutter og " + gjennomsnittligSekunder + " sekunder";

        // System.out.println("\n Episode: " + ep.getTittel() + "\n Spilletid: "+ ep.getSpilletid() + "\n Total serie spilletid: " + sumSpilletid + "\n Gjennomsnitt " + gjennomsnittligSpilletid);
    };


    public ArrayList<Rolle> hentRollebesetning(){
        ArrayList <Rolle> karaktererISerie = new ArrayList<>();
        for(Episode enEpisode : episoder){
            karaktererISerie.addAll(enEpisode.getRolleBesetning());
        }

        return  karaktererISerie;
    };

    @Override
    public int compareTo(TvSerie serien) {
        return this.tittel.compareTo(serien.getTittel());
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public ArrayList getEpisoder() {
        return episoder;
    }

    public void setEpisoder(ArrayList episoder) {
        this.episoder = episoder;
    }

    public String getGjennomsnittligSpilletid() {
        return gjennomsnittligSpilletid;
    }
    public int getSumSpilletid() {
        return sumSpilletid;
    }

    public int getAntallSesonger() {
        return antallSesonger;
    }

    public String getBildeUrl() {
        return bildeUrl;
    }

    public void setBildeUrl(String bildeUrl) {
        this.bildeUrl = bildeUrl;
    }

    @Override
    public String toString(){
        return "\n" + tittel + "\n" + beskrivelse + "\n Utgitt: " + utgivelsesdato + "\n";
    }


}
