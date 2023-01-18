public class Oppgave2_3 {
    // Neptun
    // WASP-39b
        //Radius 1.27 R(jup) = 90794.84
        //Masse - 0.28 M(jup) = 5.3144E26
    public static void main(String[] args) {
        Planet neptun = new Planet("Neptun", 24622, 1.024E26);
        Planet bocaprins = new Planet("WASP-39b", 90794.84, 5.3144E26);

        System.out.println();
        neptun.printPlanetInfo();
        System.out.println();
        bocaprins.printPlanetInfo();
    }

}
