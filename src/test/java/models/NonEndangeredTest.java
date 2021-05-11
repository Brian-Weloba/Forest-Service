package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class NonEndangeredTest {

    private NonEndangered createNewNonEndangered(){
        return new NonEndangered("Lesser Kudu");
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();


    @Test
    public void nonEndangered_InstantiatesCorrectly_true() {
        NonEndangered testNonEndangered = createNewNonEndangered();
        assertTrue(testNonEndangered instanceof NonEndangered);
    }

    @Test
    public void nonEndangered_InstantiatesWithType_NonEndangered() {
        NonEndangered testNonEndangered = createNewNonEndangered();
        assertEquals("Non-Endangered", testNonEndangered.getType());
    }

    @Test
    public void equals_ReturnsTrueIfNameAndTypeAreSame_true() {
        NonEndangered testNonEndangered = createNewNonEndangered();
        NonEndangered anotherNonEndangered = createNewNonEndangered();
        assertEquals(testNonEndangered, anotherNonEndangered);
        assertEquals(testNonEndangered.animalType, anotherNonEndangered.animalType);
    }

    @Test
    public void save_SuccessfullyAddsNonEndangeredToDatabaseList() {
        NonEndangered testNonEndangered =  createNewNonEndangered();
        testNonEndangered.save();
        assertTrue(NonEndangered.getAll().get(0).equals(testNonEndangered));
    }

    @Test
    public void save_assignsIdToObject() {
        NonEndangered testNonEndangered = createNewNonEndangered();
        testNonEndangered.save();
        NonEndangered savedNonEndangered = NonEndangered.getAll().get(0);
        assertEquals(testNonEndangered.getId(), savedNonEndangered.getId());
    }

    @Test
    public void all_returnsAllInstancesOfNonEndangered_true() {
        NonEndangered firstNonEndangered = createNewNonEndangered();
        firstNonEndangered.save();
        NonEndangered secondNonEndangered = new NonEndangered("Thomson’s Gazelle");
        secondNonEndangered.save();
        assertEquals(true, NonEndangered.getAll().get(0).equals(firstNonEndangered));
        assertEquals(true, NonEndangered.getAll().get(1).equals(secondNonEndangered));
    }

    @Test
    public void find_returnsNonEndangeredWithSameId_secondNonEndangered() {
        NonEndangered firstNonEndangered = createNewNonEndangered();
        firstNonEndangered.save();
        NonEndangered secondNonEndangered = new NonEndangered("Thomson’s Gazelle");
        secondNonEndangered.save();
        assertEquals(NonEndangered.findById(secondNonEndangered.getId()), secondNonEndangered);
    }

    @Test
    public void update_changesExistingNonEndangeredName_Lion(){
        NonEndangered testNonEndangered = createNewNonEndangered();
        String oldName = testNonEndangered.getName();
        testNonEndangered.save();
        NonEndangered.update(testNonEndangered.getId(), "Hirola");
        int sameId = testNonEndangered.getId();
        assertEquals(sameId, NonEndangered.findById(testNonEndangered.getId()).getId());
        assertEquals("Hirola", NonEndangered.findById(testNonEndangered.getId()).getName());
        assertNotEquals(oldName, NonEndangered.findById(testNonEndangered.getId()).getName());
    }

    @Test
    public void deleteNonEndangered_removesNonEndangeredFromDatabase(){
        NonEndangered testNonEndangered = createNewNonEndangered();
        testNonEndangered.save();
        NonEndangered otherNonEndangered = createNewNonEndangered();
        otherNonEndangered.save();
        otherNonEndangered.delete();
        assertEquals(1,NonEndangered.getAll().size());
    }
}