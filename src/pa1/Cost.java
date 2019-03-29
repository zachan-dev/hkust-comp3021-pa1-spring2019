package pa1;


/**
 * An immutable class that encapsulates the gold, science and production costs.
 */
public class Cost {

    private final int gold, production, science;

    public Cost(int gold, int production, int science) {
        this.gold = gold;
        this.production = production;
        this.science = science;
    }

    public int getGold() {
        return gold;
    }

    public int getProduction() {
        return production;
    }

    public int getScience() {
        return science;
    }

    /**
     * Get a new Cost object with applied discount rate
     *
     * @param rate discount rate
     * @return Discounted Cost = round(rate * current cost)
     */
    public Cost getDiscountedCost(double rate) {
        // TODO DONE
        return new Cost(Math.round((float)(gold*rate)), Math.round((float)(production*rate)), Math.round((float)(science*rate)));
    }

    /**
     * Two Cost objects are equal if their
     * gold costs AND production costs AND science costs
     * are equal
     * <p>
     * Return false if obj is not an instance of Cost
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        // TODO DONE
        if (obj instanceof Cost) return (gold==((Cost) obj).gold && production==((Cost) obj).production && science==((Cost) obj).science);
        else return false;
    }
}
