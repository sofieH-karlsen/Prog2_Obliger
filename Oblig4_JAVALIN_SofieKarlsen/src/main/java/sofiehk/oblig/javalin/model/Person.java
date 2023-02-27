package sofiehk.oblig.javalin.model;

public class Person {
    private String fulltNavn;
    private String fodselsAr;



    public Person(String fulltNavn,String fodselsAr) {
        this.fulltNavn = fulltNavn;
        this.fodselsAr = fodselsAr;
    }

    public String getFulltNavn() {
        return fulltNavn;
    }

    public void setFulltNavn(String fulltNavn) {
        this.fulltNavn = fulltNavn;
    }

    public String getFodselsAr() {
        return fodselsAr;
    }

    public void setFodselsAr(String fodselsAr) {
        this.fodselsAr = fodselsAr;
    }

    @Override
    public String toString() {
    return getFulltNavn()+"(f." + getFodselsAr() + ")";
    }
}
