package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class EndangeredTest {

    @Rule
    public DatabaseRule databaseRule = new DatabaseRule();

    @Test
    public void save_insertsObjectIntoDatabase() {
        Endangered animal = new Endangered("White Rhino","Healthy","Old");
        animal.save();
        assertTrue(Endangered.getAll().get(0).equals(animal));
    }
}