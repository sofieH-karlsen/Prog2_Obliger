package Oblig.seks;

public class BrownBear extends Animal{

    public BrownBear(String name, DietType dietType, String favoriteFood, int age) {
        super(name, dietType, favoriteFood, age);
    }

    @Override
    public double calculateSpeed() {
        double maxSpeed = 56.0;
        return Math.min(maxSpeed,getAge() * 5);
    }
}
