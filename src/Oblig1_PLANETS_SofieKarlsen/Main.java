package Oblig1_PLANETS_SofieKarlsen;

public class Main {
    public static void main(String[] args) {
        // Oppg 2.1
        System.out.println("Oppgave 2.1");
        System.out.println("Hello World!");

        System.out.println();

        // Oppg 2.2
        System.out.println("Oppgave 2.2");
        weight(75);

        System.out.println();
    }
     // Oppg 2.2
     public static void weight(double earthWeight){
        double moonGravity = 0.17;
        double moonWeight = earthWeight * moonGravity;

         System.out.println("Vekt på jorden(kg): " + earthWeight );
         System.out.println("Vekt på månen(kg): " + moonWeight );
     }
}