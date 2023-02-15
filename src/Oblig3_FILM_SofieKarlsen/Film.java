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
        return "\n\tTittel: " + getTittel() + "\n\t\"" + getBeskrivelse() + "\" \n\tUtgitt: " + getUtgivelsedato() + "\n\tSpilletid: " + getSpilletid() + " minutter" + "\n\tRegissør: " + getRegissor() + "\n\tRollebesetning: \n\t"+ getRolleBesetning() + "\n";
    }

}
