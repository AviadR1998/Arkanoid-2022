// Name: Aviad Ravid
// ID: 209321108
package Logics;

/**
 * The Counter class makes a specific counter that can increase or decrease its value
 * by a given amount.
 *
 * @author Aviad Ravid
 */
public class Counter {
    private int number;

    /**
     * This method is used as a constructor to initialize a Counter's instance values.
     *
     * @param number - a given int.
     */
    public Counter(int number) {
        this.number = number;
    }

    /**
     * This method adds number to current count.
     *
     * @param number - a given number.
     */
    public void increase(int number) {
        this.number += number;
    }

    /**
     * This method subtracts number from current count.
     *
     * @param number - a given number.
     */
    public void decrease(int number) {
        this.number -= number;
    }

    /**
     * This method returns the current count.
     *
     * @return - an int parameter.
     */
    public int getValue() {
        return this.number;
    }
}
