package Oblig.seks;

public abstract class Animal {

    public enum DietType {
        Herbivore, Carnivore, Omnivore;
    }

    private String name, favoriteFood;
    private DietType dietType;
    private int age;

    public Animal(String name, DietType dietType,String favoriteFood, int age) {
        this.name = name;
        this.dietType = dietType;
        this.favoriteFood = favoriteFood;
        this.age = age;
    }

    public abstract double calculateSpeed();

    @Override
    public String toString() {
        return "\n"+getClass().getSimpleName() + " - " + name + "\nage: " + age + " year(s) old " + "\nHas a(n) " + dietType + " diet, a favorite is " + favoriteFood +"\nSpeed is " + calculateSpeed() + " km/h\n";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteFood() {
        return favoriteFood;
    }

    public void setFavoriteFood(String favoriteFood) {
        this.favoriteFood = favoriteFood;
    }

    public DietType getDietType() {
        return dietType;
    }

    public void setDietType(DietType dietType) {
        this.dietType = dietType;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
