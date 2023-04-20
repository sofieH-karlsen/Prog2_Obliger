package Oblig.seks;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        HashMap<Integer,Animal> l =new HashMap<>();
        Zoo park = new Zoo(l);

        BrownBear lia = new BrownBear("Lia", Animal.DietType.Omnivore,"salmon", 2);
        LeastWeasel snow = new LeastWeasel("Snow", Animal.DietType.Carnivore,"mice", 2);
        Moose mike = new Moose("Mike", Animal.DietType.Herbivore,"pine needles", 9);
        MountainHare sprett = new MountainHare("Petter", Animal.DietType.Herbivore,"carrots",3);
        RedFox tod = new RedFox("Todd", Animal.DietType.Omnivore,"rabbit",4);
        Wolverine logan = new Wolverine("Logan", Animal.DietType.Omnivore,"deer",1);

        park.addAnimal(lia);
        park.addAnimal(mike);
        park.addAnimal(snow);
        park.addAnimal(sprett);
        park.addAnimal(tod);
        park.addAnimal(logan);

        System.out.println(park.zooAnimalsInfo());





    }
}
