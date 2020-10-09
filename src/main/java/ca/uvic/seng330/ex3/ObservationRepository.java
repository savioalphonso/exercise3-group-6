package ca.uvic.seng330.ex3;

import java.util.*;

public class ObservationRepository implements Repository<Observation> {

    private List<Observation> observations;

    public ObservationRepository(List<Observation> observations) {
        this.observations = new ArrayList<>(observations);
    }

    public ObservationRepository() {
    }

    public ObservationRepository(ObservationRepository other) {
        if (other.observations == null)
            throw new NullPointerException("Repository to copy is null");

        this.observations = new ArrayList<>(other.observations);
    }

    /**
     * Fina all the observations on a certain date
     *
     * @param date - desired date of any given observation
     * @return collection of observations submitted on the date <code>date</code>
     */
    public List<Observation> getByDate(Date date) {

        if (date == null)
            throw new NullPointerException();

        Comparator<Observation> dateComparator = new Observation.compareByDate();
        List<Observation> sortedObservations = new ArrayList<>(observations);
        sortedObservations.sort(dateComparator);

        List<Observation> result = new ArrayList<>();

        Observation key = new Observation();
        key.setSightingTime(date);

        int index = Collections.binarySearch(sortedObservations, key, dateComparator);
        if (index < 0) {
            throw new NoSuchElementException("No Observations dated: " + date.toString());
        } else {
            int startIndex = index;
            int endIndex = index;

            while (startIndex > 0 && dateComparator.compare(key, sortedObservations.get(startIndex - 1)) == 0) {
                startIndex--;
            }
            while (endIndex < sortedObservations.size() - 1 && dateComparator.compare(key, sortedObservations.get(endIndex + 1)) == 0) {
                endIndex++;
            }
            for (Observation current : sortedObservations.subList(startIndex, endIndex + 1)) {
                result.add(new Observation(current));
            }
        }
        return result;
    }

    public void sortByDate() {
        if (observations != null && observations.size() > 0)
            observations.sort(new Observation.compareByDate());
    }

    public void sortById() {
        if (observations != null && observations.size() > 0)
            Collections.sort(observations);
    }


    /**
     * Find all the observations on a species of whale
     *
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
     *
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
     *
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
