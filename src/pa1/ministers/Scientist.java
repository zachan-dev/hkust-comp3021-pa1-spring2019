package pa1.ministers;


import pa1.City;

public class Scientist extends Minister {

    /**
     * Calls the superclass' constructor
     *
     * @param intelligence
     * @param experience
     * @param leadership
     */
    public Scientist(int intelligence, int experience, int leadership) {
        // TODO DONE
        super(intelligence, experience, leadership);
    }


    /**
     * @return tech discount rate equals to 1 - (intelligence + experience) / 1500
     */
    @Override
    public double getTechDiscountRate() {
        // TODO DONE
        return 1 - (intelligence + experience) / 1500;
    }

    /**
     * @param city to collect science points from
     * @return 1.5 times the amount collected by other types of minister
     */
    @Override
    public int collectSciencePoints(City city) {
        // TODO DONE
        return Math.round(1.5f * super.collectSciencePoints(city));
    }

    /**
     * Example string representation:
     * "Scientist | intelligence: 100 | experience: 100 | leadership: 100 | READY" - when isReady() == true
     * "Scientist | intelligence: 100 | experience: 100 | leadership: 100 | DONE" - when isReady() == false
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
