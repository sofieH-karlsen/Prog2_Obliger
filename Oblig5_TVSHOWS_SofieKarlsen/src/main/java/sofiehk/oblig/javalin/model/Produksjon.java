package sofiehk.oblig.javalin.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.time.LocalDate;
import java.util.ArrayList;

@JsonTypeInfo(use= JsonTypeInfo.Id.DEDUCTION)
@JsonSubTypes({
        @JsonSubTypes.Type(Film.class),
        @JsonSubTypes.Type(Episode.class)
})
public abstract class Produksjon {
    private String tittel;
    private String beskrivelse;
    private int spilletid;
    private LocalDate utgivelsesdato;
    private Person regissor;
    private ArrayList<Rolle> rolleListe;
    private String bildeUrl;

    public void leggTilEnRolle(Rolle enRolle){
        this.rolleListe.add(enRolle);
    };

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){
        this.rolleListe.addAll(flereRoller);
    };

// Konstruktører


    public Produksjon() {
    }

    public Produksjon(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor, ArrayList<Rolle> rolleListe, String bildeUrl) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsesdato = utgivelsesdato;
        this.regissor = regissor;
        this.rolleListe = rolleListe;
        this.bildeUrl = bildeUrl;
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

    public int getSpilletid() {
        return spilletid;
    }

    public void setSpilletid(int spilletid) {
        this.spilletid = spilletid;
    }

    public LocalDate getUtgivelsesdato() {
        return utgivelsesdato;
    }

    public void setUtgivelsesdato(LocalDate utgivelsesdato) {
        this.utgivelsesdato = utgivelsesdato;
    }

    public Person getRegissor() {
        return regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    public ArrayList<Rolle> getRolleListe() {
        return rolleListe;
    }

    public void setRolleListe(ArrayList<Rolle> rolleListe) {
        this.rolleListe = rolleListe;
    }

    public String getBildeUrl() {
        return bildeUrl;
    }

    public void setBildeUrl(String bildeUrl) {
        this.bildeUrl = bildeUrl;
    }
}
