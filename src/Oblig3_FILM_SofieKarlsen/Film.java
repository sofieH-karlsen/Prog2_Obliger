package Oblig3_FILM_SofieKarlsen;

import java.time.LocalDate;
import java.util.ArrayList;

public class Film extends Produksjon {


    // Konstruktører
    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor, ArrayList<Rolle> rolleBesetning) {
        super(tittel, beskrivelse,spilletid,utgivelsesdato,regissor,rolleBesetning);
    }
    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor) {
        super(tittel, beskrivelse,spilletid,utgivelsesdato,regissor);
    }

    @Override
    public String toString(){
        return "Tittel: " + getTittel() + "\n\t\"" + getBeskrivelse() + "\" \nUtgitt: " + getUtgivelsedato() + "\nSpilletid: " + getSpilletid() + " minutter" + "\nRegissør: " + getRegissor() + "\nRollebesetning:"+ getRolleBesetning() + "\n";
    }

}
