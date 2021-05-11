package models;

import org.junit.Rule;
import org.junit.Test;

import java.sql.Timestamp;

import static org.junit.Assert.*;

public class SightingTest {

    private Sighting createNewSighting(){
        return new Sighting(1,1,1);
    }

    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void sighting_instantiatesCorrectly_true() {
        Sighting testSighting = createNewSighting();
        assertEquals(true, testSighting instanceof Sighting);
        assertEquals(1, testSighting.getAnimal_id());
        assertEquals(1, testSighting.getRanger_id());
        assertEquals(1, testSighting.getLocation_id());
    }

    @Test
    public void sighting_InstantiatesWithSightingTime() {
        Sighting testSighting = createNewSighting();
        testSighting.save();
        Timestamp rightNow = new Timestamp(System.currentTimeMillis());
        rightNow.setNanos(0);
        Timestamp sightTime = Sighting.findById(testSighting.getId()).getCreated_At();
        sightTime.setNanos(0);
        assertEquals(rightNow, sightTime);
    }

    @Test
    public void equals_ReturnsTrueIfNamesAreSame_true() {
        Sighting testSighting = createNewSighting();
        Sighting anotherSighting = createNewSighting();
        assertEquals(testSighting, anotherSighting);
    }

    @Test
    public void all_returnsAllInstancesOfSighting_true() {
        Sighting firstSighting =  createNewSighting();
        firstSighting.save();
        Sighting secondSighting = new Sighting(2,2,2);
        secondSighting.save();
        assertTrue(Sighting.getAll().get(0).equals(firstSighting));
        assertTrue(Sighting.getAll().get(1).equals(secondSighting));
        assertEquals(2, Sighting.getAll().size());
    }

    @Test
    public void save_SuccessfullyAddsSightingToDatabaseList() {
        Sighting testSighting =  createNewSighting();
        testSighting.save();
        assertTrue(Sighting.getAll().get(0).equals(testSighting));
    }

    @Test
    public void save_assignsIdToSighting() {
        Sighting testSighting =  createNewSighting();
        testSighting.save();
        Sighting savedSighting = Sighting.getAll().get(0);
        assertEquals(testSighting.getId(), savedSighting.getId());
    }

    @Test
    public void find_returnsSightingWithSameId_secondSighting() {
        Sighting firstSighting = createNewSighting();
        firstSighting.save();
        Sighting secondSighting = new Sighting(2,2,2);
        secondSighting.save();
        assertEquals(Sighting.findById(secondSighting.getId()), secondSighting);
    }

    @Test
    public void update_changesExistingSighting_2(){
        Sighting testSighting = createNewSighting();
        int oldLocation = testSighting.getLocation_id();
        testSighting.save();

        Sighting.update(testSighting.getId(), 2,2,2);

        int sameId = testSighting.getId();

        assertEquals(sameId, Sighting.findById(testSighting.getId()).getId());
        assertEquals(2, Sighting.findById(testSighting.getId()).getAnimal_id());
        assertNotEquals(oldLocation, Sighting.findById(testSighting.getId()).getLocation_id());
    }

    @Test
    public void deleteSighting_removesSightingFromDatabase(){
        Sighting testSighting = createNewSighting();
        testSighting.save();
        Sighting otherSighting = createNewSighting();
        otherSighting.save();
        otherSighting.delete();
        assertEquals(1, Sighting.getAll().size());
    }


}