package sofiehk.oblig.javalin.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.ArrayList;

public class Film extends Produksjon {


    // Konstruktører
    public Film(String tittel, String beskrivelse, int spilletid, LocalDate utgivelsesdato, Person regissor, ArrayList<Rolle> rolleBesetning, String bildeUrl) {
        super(tittel, beskrivelse,spilletid,utgivelsesdato,regissor,rolleBesetning,bildeUrl);
    }

    @JsonIgnore
    @Override
    public String toString(){
        return "Tittel: " + getTittel() + "\n\t\"" + getBeskrivelse() + "\" \nUtgitt: " + getUtgivelsesdato() + "\nSpilletid: " + getSpilletid() + " minutter" + "\nRegissør: " + getRegissor() + "\nRollebesetning:"+ getRolleListe() + "\n";
    }

}
