package pa1.ministers;


import pa1.City;
import pa1.Cost;
import pa1.Player;
import pa1.exceptions.TooPoorException;

public class Economist extends Minister {

    /**
     * Call the superclass' constructor
     * @param intelligence
     * @param experience
     * @param leadership
     */
    public Economist(int intelligence, int experience, int leadership) {
        // TODO DONE
        super(intelligence, experience, leadership);
    }

    /**
     * @return improvement discount rate equals to 1 - (intelligence + experience) / 1500
     */
    @Override
    public double getImprovementDiscountRate() {
        // TODO DONE
        return 1 - (intelligence + experience) / 1500;
    }

    /**
     * @param city to collect gold from
     * @return 1.5 times the amount collected by other types of minister
     */
    @Override
    public int collectTax(City city) {
        // TODO DONE
        return Math.round(1.5f * super.collectTax(city));
    }


    /**
     * Economists get a bonus when doing crops improvements
     * Crop improvement still costs 500 gold
     * Crop is improved by 50 + round((intelligence + experience + leadership) * 0.2)
     * If the player does not have enough gold, throw an exception
     * Else decrease 500 golds from the player and improves crops by the calculated amount
     *
     * @param player
     * @param city
     * @throws TooPoorException
     */
    @Override
    public void improveCropYield(Player player, City city) throws TooPoorException {
        // TODO DONE
        Cost cost = new Cost(500, 0, 0);
        if (player.getGold() < cost.getGold()) throw new TooPoorException(player, cost);
        else {
            player.decreaseGold(500);
            city.improveCrops(50 + Math.round(0.2f * (intelligence + experience + leadership)));
        }
    }

    /**
     * Example string representation:
     * "Economist | intelligence: 100 | experience: 100 | leadership: 100 | READY" - when isReady() == true
     * "Economist | intelligence: 100 | experience: 100 | leadership: 100 | DONE" - when isReady() == false
     *
     * @return string representation of this object
     */
    @Override
    public String toString() {
        // TODO DONE
        return String.format("%s | intelligence: %d | experience: %d | leadership: %d | %s",
                getClass().getSimpleName(), intelligence, experience, leadership, isReady()?"READY":"DONE");
    }
}
