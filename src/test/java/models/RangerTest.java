package models;

import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class RangerTest {

    private Ranger createNewRanger(){ return new Ranger("Johnson");}

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void ranger_instantiatesCorrectly_true(){
        Ranger testRanger = createNewRanger();
        assertTrue(testRanger instanceof Ranger);
        assertEquals("Johnson", testRanger.getName());
    }

    @Test
    public void equals_ReturnsTrueIfNamesAreSame_true() {
        Ranger testRanger = createNewRanger();
        Ranger anotherRanger = createNewRanger();
        assertEquals(testRanger, anotherRanger);
    }

    @Test
    public void save_SuccessfullyAddsRangerToDatabaseList() {
        Ranger testRanger =  createNewRanger();
        testRanger.save();
        assertTrue(Ranger.getAll().get(0).equals(testRanger));
    }

    @Test
    public void save_assignsIdToRanger() {
        Ranger testRanger = createNewRanger();
        testRanger.save();
        Ranger savedRanger = Ranger.getAll().get(0);
        assertEquals(testRanger.getId(), savedRanger.getId());
    }

    @Test
    public void all_returnsAllInstancesOfRanger_true() {
        Ranger firstRanger = createNewRanger();
        firstRanger.save();
        Ranger secondRanger = new Ranger("Carol");
        secondRanger.save();
        assertTrue(Ranger.getAll().get(0).equals(firstRanger));
        assertTrue(Ranger.getAll().get(1).equals(secondRanger));
        assertEquals(2, Ranger.getAll().size());
    }

    @Test
    public void find_returnsRangerWithSameId_secondRanger() {
        Ranger firstRanger = createNewRanger();
        firstRanger.save();
        Ranger secondRanger = new Ranger("Carol");
        secondRanger.save();
        assertEquals(Ranger.findById(secondRanger.getId()), secondRanger);
    }

    @Test
    public void update_changesExistingEndangeredRanger_Carol(){
        Ranger testRanger = createNewRanger();
        String oldName = testRanger.getName();
        testRanger.save();
        Ranger.update(testRanger.getId(), "Carol");
        int sameId = testRanger.getId();
        assertEquals(sameId, Ranger.findById(testRanger.getId()).getId());
        assertEquals("Carol", Ranger.findById(testRanger.getId()).getName());
        assertNotEquals(oldName, Ranger.findById(testRanger.getId()).getName());
    }

    @Test
    public void deleteRanger_removesRangerFromDatabase(){
        Ranger testRanger = createNewRanger();
        testRanger.save();
        Ranger otherRanger = createNewRanger();
        otherRanger.save();
        otherRanger.delete();
        assertEquals(1,Ranger.getAll().size());
    }
}