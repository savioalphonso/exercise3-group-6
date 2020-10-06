package ca.uvic.seng330.ex3;

import java.util.*;

/**
 * A collection of whales and associated search methods on the
 * collection
 */
public class WhaleRepository implements Repository<Whale>, Iterable<Whale> {

    private List<Whale> whales;

    public WhaleRepository(){
        whales = new ArrayList<>();
    }

    public WhaleRepository(List<Whale> initialWhales){
        if (initialWhales != null) {
            this.whales = new ArrayList<>(initialWhales);
        }
    }

    /**
     * Copy Constructor. Copies the field variables
     * @param other WhaleRepository object.
     */
    public WhaleRepository(WhaleRepository other){
        if (other.whales != null) {
            this.whales = new ArrayList<>(other.whales);
        }
    }

    /**
     * Find the whale by its name inside the repository
     * @param name - name of a whale
     * @return Whale object whose name field variable matches the name parameter
     */
    public Whale getByName(String name) throws Exception {
        System.out.println("Getting Whale with name");
        return null;
    }

    /**
     * Finds all the whales by gender
     * @param gender (Gender) - MALE or FEMALE
     * @return List of whales with field variable gender <code>gender</code>
     */
    public List<Whale> getByGender(Gender gender){
        System.out.println("Getting Whales with gender");
        return null;
    }

    /**
     * Finds all the whales by species
     * @param species - species of whale declared by enum
     * @return List of whales with field variable species <code>species</code>
     */
    @Override
    public List<Whale> getBySpecies(Species species) {
        System.out.println("Getting Whales with gender");
        return null;
    }

    /**
     * Finds a specific whale with a specific id
     * @param id - id value of the desired whale
     * @return Specific Whale Object with id <code>id</code>
     */
    @Override
    public Whale getById(long id) throws Exception {
        System.out.println("Getting Whales with id" );
        Whale search = new Whale();
        search.setWhaleId(id);
        int index = Collections.binarySearch(whales, search, new Comparator<Whale>() {
            @Override
            public int compare(Whale o1, Whale o2) {
                return (int)(o1.getWhaleId() - o2.getWhaleId());
            }
        });
        if(index >= 0) return whales.get(index);
        throw new Exception("Getting Whales with id " + Long.toString(id) + " failed");
    }

    /**
     * Add a whale to the repository
     * @param whale A whale to add to the repository
     */
    @Override
    public void add(Whale whale) {
        whales.add(whale);
    }

    /**
     * @return Returns a Array List of the whales in the repository
     */
    public List<Whale> getWhales() {
        return new ArrayList<>(whales);
    }

    @Override
    public Iterator<Whale> iterator() {
        return whales.iterator();
    }

    public void sortById() {
        Collections.sort(whales, new Whale.CompareById());
    }
}
