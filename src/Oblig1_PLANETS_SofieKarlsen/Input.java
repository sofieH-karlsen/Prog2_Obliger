package Oblig1_PLANETS_SofieKarlsen;

import java.util.Scanner;
//Bonus oppgave 3.1
// https://www.w3schools.com/java/java_user_input.asp
public class Input {
    public static void main(String[] args) {
        Scanner myObj  = new Scanner(System.in);

        System.out.println("Skriv inn navnet på planeten:");
        String name = myObj .nextLine();

        System.out.println("Skriv inn radiusen til planeten:");
        double r = myObj .nextDouble();

        System.out.println("Skriv inn massen til planeten:");
        double mass = myObj .nextDouble();

        Planet planet = new Planet(name, r, mass);

        planet.printPlanetInfo();
    }
}
