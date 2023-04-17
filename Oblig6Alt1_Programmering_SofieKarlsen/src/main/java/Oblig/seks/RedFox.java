package Oblig.seks;

public class RedFox extends Animal{

    public RedFox(String name, DietType dietType,String favoriteFood, int age) {
        super(name,dietType,favoriteFood,age);
    }

    @Override
    public double calculateSpeed() {
        double maxSpeed = 50.0;
        return Math.min(maxSpeed,getAge() * 40);
    }
}
