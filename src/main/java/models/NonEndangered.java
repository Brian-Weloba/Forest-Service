package models;

public class NonEndangered extends Animal{
    public static final String animalType = "Non-Endangered";

    public NonEndangered(String name){
        this.name = name;
        this.type = animalType;
    }


}
