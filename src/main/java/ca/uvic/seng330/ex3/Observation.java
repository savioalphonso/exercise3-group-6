package ca.uvic.seng330.ex3;
import java.util.Date;

/**
 * Whale observation details and associated methods
 */
public class Observation {

    private User reporter;
    private long observationId;
    private Date sightingTime;
    private Species species;
    private Direction direction;
    private String conditions;

    /**
     * Default constructor
     */
    public Observation(){
        reporter = null;
        observationId = 0;
        sightingTime = null;
        species = Species.UNKNOWN;
        direction = Direction.UNKNOWN;
        conditions = "";
    }

    /**
     * Get Reporter of Observation
     * @return reporter - Reporter of Observation
     */
    public User getReporter() {
        System.out.println("Getting Reporter");
        return reporter;
    }

    /**
     * Set Reporter of Observation
     * @param User - Reporter of Observation
     */
    public void setReporter(User reporter) {
        this.reporter = reporter;
        System.out.println("Setting Reporter");
    }

    /**
     * Get ObservationId of Observation
     * @return long - ObservationId number
     */
    public long getObservationId() {
        System.out.println("Getting Observation Id");
        return observationId;
    }

    /**
     * Set ObservationId of Observation
     * @param observationId - ObservationId number
     */
    public void setObservationId(long observationId) {
        System.out.println("Setting Observation Id");
        this.observationId = observationId;
    }

    /**
     * Get sightingTime of Observation
     * @return Date - sightingTime date
     */
    public Date getSightingTime() {
        System.out.println("Getting Sighting Time");
        return sightingTime;
    }

    /**
     * Set sightingTime of Observation
     * @param sightingTime - date of Observation
     */
    public void setSightingTime(Date sightingTime) {
        System.out.println("Setting Sighting Time");
        this.sightingTime = sightingTime;
    }

    /**
     * Get whale species seen in Observation
     * @return species - Species of whale observed
     */
    public Species getSpecies() {
        System.out.println("Getting Species");
        return species;
    }

    /**
     * Set whale species seen in Observation
     * @param species - Species of whale observed
     */
    public void setSpecies(Species species) {
        System.out.println("Setting Species");
        this.species = species;
    }

    /**
     * Get direction of whale movement in Observation
     * @return direction - Direction of observed whale movement
     */
    public Direction getDirection() {
        System.out.println("Getting Direction");
        return direction;
    }

    /**
     * Set direction of whale movement in Observation
     * @param direction - Direction of observed whale movement
     */
    public void Direction(Direction direction) {
        System.out.println("Setting Direction");
        this.direction = direction;
    }

    /**
     * Get condition of whale(s) observed during Observation
     * @return condition - Condition of whale(s) observed
     */
    public String getConditions() {
        System.out.println("Getting Conditions");
        return conditions;
    }

    /**
     * Set condition of whale(s) observed during Observation
     * @param conditions - Condition of whale(s) observed
     */
    public void setConditions(String conditions) {
        System.out.println("Setting Conditions");
        this.conditions = conditions;
    }

    /**
     * Copy constructor. Copies field variables
     * @param other - Observation object to be copied
     */
    public Observation(Observation other){
        if(other != null){
            this.reporter = new User(other.reporter);
            this.observationId = other.observationId;
            this.sightingTime = new Date(other.sightingTime.getTime());
            this.species = other.species;
            this.direction = other.direction;
            this.conditions = other.conditions;
        }
    }

    public Observation(long id, User reporter, Date time, Species species, Direction direction, String conditions){
        this.reporter = new User(reporter);
        this.observationId = id;
        this.sightingTime = new Date(time.getTime());
        this.species = species;
        this.direction = direction;
        this.conditions = conditions;

        System.out.print("Observed a whale");
    }
}
