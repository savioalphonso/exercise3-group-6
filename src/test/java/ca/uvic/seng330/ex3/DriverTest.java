/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ca.uvic.seng330.ex3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.desktop.SystemSleepEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    private WhaleRepository whales;
    private Whale whale1;
    private Whale whale2;
    private Whale whale3;
    private Whale whale4;
    private ObservationRepository observations;
    private Observation observation1;
    private Observation observation2;
    private Observation observation3;

    //In JUnit5 @Before and @After no longer exists, use @BeforeEach and @AfterEach instead.
    @BeforeEach
    void before(){
        whale1 = new Whale(5, "Moby Dick", Gender.MALE, "White", Species.UNKNOWN);
        whale2 = new Whale(0, "Sam", Gender.MALE, "Gray", Species.UNKNOWN);
        whale3 = new Whale(2, "Ralph", Gender.MALE, "Gray", Species.UNKNOWN);
        whale4 = new Whale(1, "Sam", Gender.MALE, "Gray", Species.UNKNOWN);

        whales = new WhaleRepository();
        whales.add(whale1);
        whales.add(whale2);
        whales.add(whale3);
        whales.add(whale4);

        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
        try {
            observation1 = new Observation();
            observation1.setSightingTime(format.parse("2020-10-01")); //2020-10-1
            observation2 = new Observation();
            observation2.setSightingTime(format.parse("2020-09-01")); //2020-9-1
            observation3 = new Observation();
            observation3.setSightingTime(format.parse("2020-09-05")); //2020-9-5
        }catch (Exception e){
            System.out.println(e);
        }
        List<Observation> list = new ArrayList<>();
        list.add(observation1);
        list.add(observation2);
        list.add(observation3);

        observations = new ObservationRepository(list);
    }

    @Test void appHasAGreeting() {
        Driver classUnderTest = new Driver();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }

    @Test void whale1IsGreater() {
        Whale.CompareById comparer = new Whale.CompareById();
        int x = comparer.compare(whale1, whale2);
        assertEquals(5, x);
    }

    @Test void sortWhalesById() {
        whales.sortById();

        List<Whale> ans = new ArrayList();
        ans.add(whale2);
        ans.add(whale4);
        ans.add(whale3);
        ans.add(whale1);
        assertEquals(ans, whales.getWhales());
    }

    @Test void searchById(){
        Whale result = whales.getById(2);
        assertNotEquals(null, result);
        assertEquals("Ralph", result.getName());
    }

    @Test void searchByGender(){
        List<Whale> result = whales.getByGender(Gender.MALE);
        assertNotEquals(null, result);
        assertEquals(4, result.size());
    }

    @Test void searchBySpecies(){
        List<Whale> result = whales.getBySpecies(Species.UNKNOWN);
        assertNotEquals(null, result);
        assertEquals(4, result.size());
    }

    @Test void sortObservationRepositoryByDate() {
        List<Observation> list = new ArrayList<>();
        list.add(observation2);
        list.add(observation3);
        list.add(observation1);
        observations.sortByDate();
        assertEquals(list, observations.getObservations());
    }

    @Test void searchByDate(){
        SimpleDateFormat format = new SimpleDateFormat( "yyyy-MM-dd" );
        Date date = new Date();
        try{
            date = format.parse("2020-09-01");
        }catch (Exception e){
            System.out.println(e);
            assertTrue(false);
        }
        List<Observation> list = new ArrayList<>();
        list.add(observation1);
        List<Observation> search = new ArrayList<>();
        try {
            search = observations.getByDate(date);
        }catch (Exception e){
            assertTrue(false);
        }
        assertEquals(1, search.size());
        assertEquals(date, search.get(0).getSightingTime());
    }
}
