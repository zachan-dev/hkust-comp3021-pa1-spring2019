package pa1;

/**
 * A class that represents a city in the game
 */
public class City {

    // TODO: define instance variables according to the UML DONE
    // Metadata
    private final int id;
    private final String name;

    // Attributes
    private int population;
    private int troops;
    private int cropYields;

    // Improvements
    private int banks = 0;
    private int roads = 0;
    private int universities = 0;


    public City(int id, String name, int population, int troops, int cropYields) {
        this.id = id;
        this.name = name;
        this.population = population;
        this.troops = troops;
        this.cropYields = cropYields;
    }

    /**
     * Adds number of banks by one
     */
    public void addBank() {
        // TODO DONE
        banks++;
    }

    /**
     * Adds number of roads by one
     */
    public void addRoad() {
        // TODO DONE
        roads++;
    }

    /**
     * Adds number of universities by one
     */
    public void addUniversity() {
        // TODO DONE
        universities++;
    }

    /**
     * Adds number of troops by specified increment.
     * If the increment is negative, invoke decreaseTroops() within this method instead.
     *
     * @param increment
     */
    public void addTroops(int increment) {
        // TODO DONE
        if (increment < 0) decreaseTroops(-increment);
        else troops = troops + increment;
    }

    /**
     * Decreases number of troops by the amount specified
     * Caps the number of troops at 0
     *
     * @param decrement
     */
    public void decreaseTroops(int decrement) {
        // TODO DONE
        troops = Math.max(0, troops - decrement);
    }

    /**
     * Add to crop yields the amount specified
     *
     * @param addition
     */
    public void improveCrops(int addition) {
        // TODO DONE
        cropYields = cropYields + addition;
    }


    /**
     * Checks whether two cities are equal
     * Two cities are equal when they have the same id
     * Return false if Object o is not an instance of City
     *
     * @param o object to be compared
     * @return result of equality check
     */
    @Override
    public boolean equals(Object o) {
        // TODO DONE
        if (o instanceof City) return id == ((City) o).id;
        else return false;
    }

    /**
     * Increases population by increment = round(excess crops * 0.5)
     * If the increment turns out to be negative, leave population unchanged
     * Print a line that says:
     * "Turn end: [city name]'s population has grown by [increment]
     * e.g. "Turn end: HK's population has grown by 50"
     */
    public void growAtTurnEnd() {
        // TODO DONE
        int increment = Math.max(0, Math.round(getExcessCrops() * 0.5f));
        population = population + increment;
        if (increment > 0) System.out.println("Turn end: "+ name +"'s population has grown by " + increment);
    }

    /**
     * Invoke a random event at the end of turn.
     * There are two types of events, a disaster and baby boom.
     * A disaster happens when rand <= 0.4, it halves the population.
     * A baby boom happens when rand > 0.4 AND rand <= 0.8 it multiplies the population by 1.5.
     * Otherwise the population is left unchanged
     * <p>
     * Print a message in the following format when each event happens
     * "Random event: A disaster in [city name] has happened, population was reduced significantly"
     * "Random event: A baby boom in [city name] has happened, population was increased significantly"
     *
     * @param rand random number between 0 and 1 supplied by the function caller
     */
    public void invokeRandomEvent(double rand) {
        // TODO DONE
        if (rand <= 0.4) {
            population = Math.round(population/2);
            System.out.println("Random event: A disaster in " + name + " has happened, population was reduced significantly");
        }
        if (rand > 0.4 && rand <= 0.8) {
            population = Math.round(population * 1.5f);
            System.out.println("Random event: A baby boom in " + name + " has happened, population was increased significantly");
        }
    }

    /**
     * Cost of building a bank
     * gold = production points = (# of banks + 1) * 400
     *
     * @return Cost object encapsulating the gold and production costs
     */
    public Cost getBankCost() {
        // TODO DONE
        int cost = (banks + 1) * 400;
        return new Cost(cost, cost, 0);
    }

    /**
     * Cost of building a road
     * gold = production points = (# of roads + 1) * 100
     *
     * @return Cost object encapsulating the gold and production costs
     */
    public Cost getRoadCost() {
        // TODO DONE
        int cost = (roads + 1) * 100;
        return new Cost(cost, cost, 0);
    }

    /**
     * Cost of building a university
     * gold = production points = (# of universities + 1) * 1500
     *
     * @return Cost object encapsulating the gold and production costs
     */
    public Cost getUniversityCost() {
        // TODO DONE
        int cost = (universities + 1) * 1500;
        return new Cost(cost, cost, 0);
    }

    /**
     * Calculates excess crops.
     *
     * @return crop yields - population - 2 * troops
     */
    public int getExcessCrops() {
        // TODO DONE
        return Math.max(0, cropYields - population - 2 * troops);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    public int getTroops() {
        return troops;
    }

    public int getCropYields() {
        return cropYields;
    }

    public int getBanks() {
        return banks;
    }

    public int getRoads() {
        return roads;
    }

    public int getUniversities() {
        return universities;
    }

    public String getMapRepresentation(String playerName) {
        return String.format("[%s:%s]", playerName, getName());
    }

    @Override
    public String toString() {
        return String.format("%s | population: %d | troops: %d | crop yields: %d | excess crops: %d | # of banks: %d | # of roads: %d | # of universities: %d",
                name, population, troops, cropYields, getExcessCrops(), banks, roads, universities);
    }

}
