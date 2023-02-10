package Oblig3_FILM_SofieKarlsen;

public class Episode extends Produksjon{
    private int episodeNr;
    private int sesongNr;


    public Episode(String tittel, int episodeNr, int sesongNr, int spilletid){
        super(tittel,spilletid);

        this.episodeNr = episodeNr;
        this.sesongNr = sesongNr;

    }
    public Episode(String tittel, int episodeNr, int sesongNr){
        super(tittel);
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
        return "\n\tTittel: " + getTittel() + "\n\tEpisode: " + episodeNr+ ", Sesong: " + sesongNr  + "\n\tSpilletid: " + getSpilletid() + " minutter \n";
    }


}
