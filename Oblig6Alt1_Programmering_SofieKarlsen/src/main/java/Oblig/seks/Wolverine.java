package Oblig.seks;

public class Wolverine extends Animal{

    public Wolverine(String name, DietType dietType, String favoriteFood, int age) {
        super(name, dietType, favoriteFood, age);
    }

    @Override
    public double calculateSpeed() {
        double maxSpeed = 48.28;
        return Math.min(maxSpeed,getAge() * 40);
    }
}
