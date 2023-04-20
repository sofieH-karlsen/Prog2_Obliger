package Oblig.seks;

public class MountainHare extends  Animal{
    public MountainHare(String name, DietType dietType, String favoriteFood, int age) {
        super(name, dietType, favoriteFood, age);
    }

    @Override
    public double calculateSpeed() {
        double maxSpeed = 72.42;
        return Math.min(maxSpeed,getAge() * 25);
    }
}
