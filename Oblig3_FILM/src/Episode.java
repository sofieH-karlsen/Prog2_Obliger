

import java.time.LocalDate;
import java.util.ArrayList;

public class Episode extends Produksjon{
    private int episodeNr;
    private int sesongNr;


    public Episode(String tittel, String beskrivelse, int episodeNr, int sesongNr, int spilletid, LocalDate utgivelsesdato, Person regissor, ArrayList<Rolle> rolleBesetning){
        super(tittel,beskrivelse,spilletid,utgivelsesdato,regissor,rolleBesetning);

        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }
    public Episode(String tittel, String beskrivelse, int episodeNr, int sesongNr, int spilletid, LocalDate utgivelsesdato, Person regissor){
        super(tittel,beskrivelse,spilletid,utgivelsesdato,regissor);

        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }

    public Episode(String tittel, String beskrivelse, int episodeNr, int sesongNr, int spilletid){
        super(tittel,beskrivelse,spilletid);

        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;
    }



    public int getEpisodeNr() {
        return episodeNr;
    }

    public void setEpisodeNr(int episodeNr) {
        this.episodeNr = episodeNr;
    }

    public int getSesongNr() {
        return sesongNr;
    }

    public void setSesongNr(int sesongNr) {
        this.sesongNr = sesongNr;
    }





    @Override
    public String toString(){
        return "\nTittel: " + getTittel() + "\nEpisode: " + episodeNr+ ", Sesong: " + sesongNr  + "\nSpilletid: " + getSpilletid() + " minutter \n\t\"" + getBeskrivelse()+ "\"\nRegissør: " + getRegissor() + "\nRollebesetning: \n"+ getRolleBesetning() +  "\n";
    }


}
