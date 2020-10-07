package ca.uvic.seng330.ex3;
import java.util.*;

public class ObservationRepository implements Repository<Observation>, Iterable<Observation> {

    private List<Observation> observations;

    public ObservationRepository(List<Observation> observations) {
        this.observations = new ArrayList<>(observations);
    }

    public ObservationRepository(){}

    public ObservationRepository(ObservationRepository other){
        if (other.observations != null)
            this.observations = new ArrayList<>(other.observations);
    }

    /**
     * Fina all the observations on a certain date
     * @param date - desired date of any given observation
     * @return collection of observations submitted on the date <code>date</code>
     */
    public List<Observation> getByDate(Date date){
        System.out.println("Getting Observations by date");
        return null;
    }

    /**
     * Find all the observations on a certain reporter
     * @param reporter The desired reporter instance for any given observation
     * @return collection of observations submitted by the reporter <code>reporter</code>
     */
    public List<Observation> getByReporter(User reporter){
        System.out.println("Getting Observations by Reporter");
        return null;
    }

    /**
     * Find all the observations on a species of whale
     * @param species The desired species of whale
     * @return collection of observations on whale with species <code>species</code>
     */
    @Override
    public List<Observation> getBySpecies(Species species) {
        System.out.println("Getting Observations by Species");
        return null;
    }

    /**
     * Find a specific observation by id
     * @param id the id number of the observation
     * @return a observation on whale with id <code>id</code>
     */
    @Override
    public Observation getById(long id) {
        System.out.println("Getting Observations by Species");
        return null;
    }

    public List<Observation> getObservations() {
        return new ArrayList<>(observations);
    }

    /**
     * Add a specific observation to the collection
     * @param observation the observation to be added
     */
    @Override
    public void add(Observation observation) {
        observations.add(observation);
    }

    @Override
    public Iterator<Observation> iterator() {
        return observations.iterator();
    }

    public void sortByDate() {
        Collections.sort(observations, new Observation.compareByDate());
    }
}
