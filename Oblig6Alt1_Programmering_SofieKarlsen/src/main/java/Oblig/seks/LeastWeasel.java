package Oblig.seks;

public class LeastWeasel extends Animal{
    // aka Snømus :)


    public LeastWeasel(String name, DietType dietType, String favoriteFood, int age) {
        super(name, dietType, favoriteFood, age);
    }

    @Override
    public double calculateSpeed() {
        double maxSpeed = 24.14;
        return Math.min(maxSpeed,getAge() * 10);
    }
}
