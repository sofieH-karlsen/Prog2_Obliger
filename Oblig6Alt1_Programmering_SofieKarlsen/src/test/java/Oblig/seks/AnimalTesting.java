package Oblig.seks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTesting {
    private Animal test;

    @Test
    public void harePrimeSpeed(){
        test = new MountainHare( "tester", Animal.DietType.Omnivore,"food",4);
        double maxSpeed = 72.42;

        assertEquals(test.calculateSpeed(), maxSpeed);
    }

    @Test
    public void correctDiet(){
        test = new LeastWeasel("tester", Animal.DietType.Carnivore,"food",2);

        assertSame(test.getDietType(), Animal.DietType.Carnivore);
    }

    @Test
    public void livedLongerThanAverage(){
        test = new Moose("tester", Animal.DietType.Herbivore,"food",12);

        int averageLifespan = 8;

        assertTrue(test.getAge() > averageLifespan);
    }

}
