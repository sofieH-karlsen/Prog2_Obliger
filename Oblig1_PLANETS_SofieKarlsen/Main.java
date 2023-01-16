public class Main {
    public static void main(String[] args) {
        // Oppg 2.1
        System.out.println("Hello World!");

        // Oppg 2.1
        weight(70);
    }
     // Oppg 2.2
     public static void weight(float earthWeight){
        float moonGravity = 0.17F;
        float moonWeight = earthWeight * moonGravity;

         System.out.println("Vekt på jorden: " + earthWeight + "kg");
         System.out.println("Vekt på månen: " + moonWeight + "kg");
     }
}