package sofiehk.oblig.javalin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;
import java.util.ArrayList;

public class Episode extends Produksjon implements Comparable<Episode>{
    private int episodeNummer, sesongNummer;

    public Episode(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor, ArrayList<Rolle> rolleBesetning, String bildeUrl) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor, rolleBesetning, bildeUrl);

    }

    public Episode(String tittel, String beskrivelse, int episodeNr, int sesongNr, int spilletid, LocalDate utgivelsesdato, Person regissor, ArrayList<Rolle> rolleBesetning, String bildeUrl) {
        super(tittel, beskrivelse, spilletid, utgivelsesdato, regissor, rolleBesetning, bildeUrl);

        this.episodeNummer = episodeNr;
        this.sesongNummer = sesongNr;
    }

    @Override
    public int compareTo(Episode episoden) {
        if(this.sesongNummer - episoden.getSesongNummer() == 0){
            return this.episodeNummer - episoden.getEpisodeNummer();
        } else{
            return this.sesongNummer - episoden.getSesongNummer();
        }
        //https://stackoverflow.com/questions/4805606/how-to-sort-by-two-fields-in-java
    }

    public int getEpisodeNummer() {
        return episodeNummer;
    }

    public void setEpisodeNummer(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }

    public int getSesongNummer() {
        return sesongNummer;
    }

    public void setSesongNummer(int episodeNummer) {
        this.episodeNummer = episodeNummer;
    }





    @Override
    public String toString() {
        return "E" + String.format("%02d", episodeNummer) + "S" + String.format("%02d", sesongNummer) + " - " + super.getTittel() + " - " + super.getSpilletid() + "min";
    }



}
