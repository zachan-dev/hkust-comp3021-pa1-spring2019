package pa1.technologies;


import pa1.Cost;

public class ManufacturingTech extends Technology {

    /**
     * @return production bonus equal to 1 + current level * 0.5
     */
    @Override
    public double getProductionBonus() {
        // TODO DONE
        return 1 + getLevel() * 0.5;
    }

    /**
     * Upgrade costs:
     * gold = production = (current level + 1) * 1000;
     * science = 0
     *
     * @return upgrade costs
     */
    @Override
    public Cost getUpgradeCost() {
        // TODO DONE
        int cost = (getLevel() + 1) * 1000;
        return new Cost(cost, cost, 0);
    }

    /**
     * Example string representation:
     * "ManufacturingTech | level: 1 | production bonus: 1.50"
     *
     * @return String representing this object
     */
    @Override
    public String toString() {
        // TODO DONE
        return String.format("%s | level: %d | production bonus: %.2f", getClass().getSimpleName(), getLevel(), getProductionBonus());
    }
}
