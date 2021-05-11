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

    @Test
    public void endangeredAnimal_instantiatesCorrectly_true() {
        Endangered testEndangered = createEndangeredAnimal();
        assertTrue(testEndangered instanceof Endangered);
    }

    @Test
    public void endangeredAnimal_instantiatesWithAllProperties_true(){
        Endangered testEndangered = createEndangeredAnimal();
        assertEquals("Koala", testEndangered.getName());
        assertEquals("Okay", testEndangered.getHealth());
        assertEquals("Young", testEndangered.getAge());
        assertTrue(testEndangered.animalType.equals("Endangered"));
    }

    @Test
    public void equals_ReturnsTrueIfNameAndTypeAreSame_true() {
        Endangered testAnimal = createEndangeredAnimal();
        Endangered anotherAnimal = createEndangeredAnimal();
        assertEquals(testAnimal, anotherAnimal);
        assertEquals(testAnimal.animalType, anotherAnimal.animalType);
    }

    @Test
    public void save_SuccessfullyAddsAnimalToDatabaseList() {
        Endangered testAnimal =  createEndangeredAnimal();
        testAnimal.save();
        assertTrue(Endangered.getAll().get(0).equals(testAnimal));
    }

    @Test
    public void save_assignsIdToEndangeredAnimal() {
        Endangered testAnimal = createEndangeredAnimal();
        testAnimal.save();
        Endangered savedAnimal = Endangered.getAll().get(0);
        assertEquals(testAnimal.getId(), savedAnimal.getId());
    }

    @Test
    public void all_returnsAllInstancesOfEndangered_true() {
        Endangered firstAnimal = createEndangeredAnimal();
        firstAnimal.save();
        Endangered secondAnimal = new Endangered("Rhino","Ill", "Old");
        secondAnimal.save();
        assertTrue(Endangered.getAll().get(0).equals(firstAnimal));
        assertTrue(Endangered.getAll().get(1).equals(secondAnimal));
    }

    @Test
    public void find_returnsEndangeredWithSameId_secondAnimal() {
        Endangered firstAnimal = new Endangered("Koala","Okay", "Young");
        firstAnimal.save();
        Endangered secondAnimal = new Endangered("Rhino","Ill", "Old");
        secondAnimal.save();
        assertEquals(Endangered.findById(secondAnimal.getId()), secondAnimal);
    }

    @Test
    public void update_changesExistingEndangeredAnimalName_Lion(){
        Endangered testAnimal = createEndangeredAnimal();
        String oldName = testAnimal.getName();
        testAnimal.save();
        Endangered.update(testAnimal.getId(), "Lion","Healthy","Young");
        int sameId = testAnimal.getId();
        assertEquals(sameId, Endangered.findById(testAnimal.getId()).getId());
        assertEquals("Lion", Endangered.findById(testAnimal.getId()).getName());
        assertEquals("Healthy", Endangered.findById(testAnimal.getId()).getHealth());
        assertEquals("Young", Endangered.findById(testAnimal.getId()).getAge());
        assertNotEquals(oldName, Endangered.findById(testAnimal.getId()).getName());
    }

    @Test
    public void deleteEndangeredAnimal_removesEndangeredAnimalFromDatabase(){
        Endangered testAnimal = createEndangeredAnimal();
        testAnimal.save();
        Endangered otherAnimal = createEndangeredAnimal();
        otherAnimal.save();
        otherAnimal.delete();
        assertEquals(1,Endangered.getAll().size());
    }

    private Endangered createEndangeredAnimal(){
        return new Endangered("Koala","Okay", "Young");
    }

}