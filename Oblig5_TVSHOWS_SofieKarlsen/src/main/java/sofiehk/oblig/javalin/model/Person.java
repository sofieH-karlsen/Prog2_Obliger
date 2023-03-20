package sofiehk.oblig.javalin.model;

import java.time.LocalDate;

public class Person {
    private String fornavn;
    private String etternavn;
    private LocalDate fodselsDato;


    public Person() {
    }

    public Person(String fornavn, String etternavn, LocalDate fodselsAr) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsDato = fodselsAr;
    }

    public String getFornavn() {
        return fornavn;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public String getEtternavn() {
        return etternavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public String getFulltNavn(){
        return fornavn + " " + etternavn;
    };

    public LocalDate getFodselsDato() {
        return fodselsDato;
    }

    public void setFodselsDato(LocalDate fodselsDato) {
        this.fodselsDato = fodselsDato;
    }

}
