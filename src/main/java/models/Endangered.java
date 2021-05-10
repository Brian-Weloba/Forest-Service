package models;

public class Endangered extends Animal{
    public static final String animalType = "Endangered";

    public Endangered(String name, String health, String age){
        this.name = name;
        this.health = health;
        this.age = age;
        this.type = animalType;
    }
}
