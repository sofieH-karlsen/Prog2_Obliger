package Oblig3_FILM_SofieKarlsen;

public class Produksjon {
    private String tittel;

    private int spilletid;

    public Produksjon(String tittel, int spilletid) {
        this.tittel = tittel;
        this.spilletid = spilletid;
    }

    public Produksjon(String tittel) {
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }
}
