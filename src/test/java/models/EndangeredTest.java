package models;

import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {

    @Test
    public void save_insertsObjectIntoDatabase() {
        Endangered animal = new Endangered("White Rhino","Healthy","Old");
        animal.save();
        assertTrue(Endangered.all().get(0).eqals(animal));
    }
}