
/**
 * Outlines the method isNearlyEqual
 * 
 * @author Arnav Dani
 * @version 10/24/19
 */
public interface Nearable
{
    /**
     * Compares two objects to an extent so see if they are within an 
     *                an epsilon difference of each other
     * @param  obj1   the first object tested as close to another  object
     * @param obj2    the second object tested as close to another object
     * 
     * @return true   if the quantities are close to each other; otherwise
     *        false
     */
    boolean isNearlyEqual(Object obj1, Object obj2);
    
}
