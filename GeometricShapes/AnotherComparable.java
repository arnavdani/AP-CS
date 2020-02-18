
/**
 * Provides another way to compare objects.
 * 
 * @author Arnav Dani
 * @version 10/24/19
 */
public interface AnotherComparable
{
    /**
     * Compares two objects in a different way than compareTo does.
     * @param  obj    the other object
     * @return        0 if the two objects are sufficiently equal,
     *              > 0 if "this" object is determined to be greater,
     *              < 0 if "this" object is determined to be less than obj.
     */
    public abstract int compareAnotherWay(Object obj);
}
