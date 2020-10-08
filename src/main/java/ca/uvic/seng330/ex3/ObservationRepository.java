package ca.uvic.seng330.ex3;
import java.util.*;

public class ObservationRepository implements Repository<Observation> {

    private List<Observation> observations;

    public ObservationRepository(List<Observation> observations) {
        this.observations = new ArrayList<>(observations);
    }

    public ObservationRepository(){}

    public ObservationRepository(ObservationRepository other){
        if (other.observations == null)
            throw new NullPointerException("Repository to copy is null");

        this.observations = new ArrayList<>(other.observations);
    }

    /**
     * Fina all the observations on a certain date
     * @param date - desired date of any given observation
     * @return collection of observations submitted on the date <code>date</code>
     */
    public List<Observation> getByDate(Date date){

        if (date == null)
            throw new NullPointerException();

        Comparator<Observation> byDate = new Observation.compareByDate();
        List<Observation> sortedObservations = getSortedList(byDate);
        List<Observation> result = new LinkedList<>();

        Observation key = new Observation();
        key.setSightingTime(date);

        int lower_bound = Collections.binarySearch(sortedObservations, key, byDate);

        if (lower_bound >= 0){
            int upper_bound = lower_bound + 1;
            Observation cur = new Observation(key);

            while (key.compareTo(cur) == 0){
                cur = sortedObservations.get(upper_bound);
                result.add(new Observation(cur));
                upper_bound++;
            }
        } else {
            throw new NoSuchElementException("No Observations dated: " + date.toString());
        }

        return result;
    }

    public void sortByDate(){
        observations =  getSortedList(new Observation.compareByDate());
    }

    private List<Observation> getSortedList(Comparator<Observation> comparator){
        List<Observation> sortedObservations = new ArrayList<>(observations);
        sortedObservations.sort(comparator);
        return sortedObservations;
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

        if (id < 0 || id > observations.size())
            throw new IllegalArgumentException("Id must be greater than 0 but less than " + observations.size());

        List<Observation> sortedObservations = new ArrayList<>(observations);
        Collections.sort(sortedObservations);
        Observation search = new Observation();
        search.setObservationId(id);

        int index = Collections.binarySearch(sortedObservations, search);

        if (index < 0)
            throw new NoSuchElementException("No Element with id " + id);

        return sortedObservations.get(index);
    }

    public List<Observation> getObservations() {
        return new ArrayList<>(observations);
    }

    /**
     * Add a specific observation to the collection
     * @param observation the observation to be added
     */
    public void add(Observation observation) {

        Observation copy = new Observation(observation);
        observations.add(copy);
    }

    @Override
    public Iterator<Observation> iterator() {
        return observations.iterator();
    }

}
