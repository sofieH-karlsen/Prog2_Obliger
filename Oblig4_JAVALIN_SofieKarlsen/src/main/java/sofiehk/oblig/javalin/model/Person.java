package sofiehk.oblig.javalin.model;

public class Person {
    private String fornavn;
    private String etternavn;
    private String fodselsAr;


    public String getFullName(){
        return fornavn + " " + etternavn;
    }

    public Person(String fornavn, String etternavn, String fodselsAr) {
        this.fornavn = fornavn;
        this.etternavn = etternavn;
        this.fodselsAr = fodselsAr;
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

    public String getFodselsAr() {
        return fodselsAr;
    }

    public void setFodselsAr(String fodselsAr) {
        this.fodselsAr = fodselsAr;
    }

    @Override
    public String toString() {
    return getFullName()+"(f." + getFodselsAr() + ")";
    }
}
