package Oblig2_TV_SofieKarlsen;

import java.time.LocalDate;
import java.util.ArrayList;

//Oppgave 2.1
public class TvSerie {
    private String tittel;
    private String beskrivelse;
    private LocalDate utgivelsesdato;
    private ArrayList <Episode> episoder;


    public TvSerie(String tittel, String beskrivelse, LocalDate utgivelsesdato, ArrayList episoder){
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.utgivelsesdato = utgivelsesdato;
        this.episoder = episoder;
    }

   public void leggTilEpisode(Episode episode){
        episoder.add(episode);

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

    // Oppgave 2.3
    @Override
    public String toString(){
        return "";
    }
}
