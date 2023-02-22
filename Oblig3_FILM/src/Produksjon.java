

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Produksjon {
    private String tittel;
    private String beskrivelse;
    private int spilletid;
    private LocalDate utgivelsedato;
    private Person regissor;
    private ArrayList<Rolle> rolleBesetning;

    public void leggTilEnRolle(Rolle enRolle){
        this.rolleBesetning.add(enRolle);
    };

    public void leggTilMangeRoller(ArrayList<Rolle> flereRoller){
        this.rolleBesetning.addAll(flereRoller);
    };

// Konstruktører
    public Produksjon(String tittel, String beskrivelse,int spilletid, LocalDate utgivelsedato, Person regissor,ArrayList<Rolle> rolleBesetning) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsedato = utgivelsedato;
        this.regissor = regissor;
        this.rolleBesetning = rolleBesetning;
    }
    public Produksjon(String tittel, String beskrivelse,int spilletid, LocalDate utgivelsedato, Person regissor) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
        this.utgivelsedato = utgivelsedato;
        this.regissor = regissor;
    }

    public Produksjon(String tittel, String beskrivelse,int spilletid) {
        this.tittel = tittel;
        this.beskrivelse = beskrivelse;
        this.spilletid = spilletid;
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

    public LocalDate getUtgivelsedato() {
        return utgivelsedato;
    }

    public void setUtgivelsedato(LocalDate utgivelsedato) {
        this.utgivelsedato = utgivelsedato;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public Person getRegissor() {
        return regissor;
    }

    public void setRegissor(Person regissor) {
        this.regissor = regissor;
    }

    public ArrayList<Rolle> getRolleBesetning() {
        return rolleBesetning;
    }

    public void setRolleBesetning(ArrayList<Rolle> rolleBesetning) {
        this.rolleBesetning = rolleBesetning;
    }
}
