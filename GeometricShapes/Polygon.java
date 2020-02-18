
/**
 * Abstract way to group all polygon type shapes
 * 
 * @author Arnav Dani
 * @version 10/24/19
 */
public abstract class Polygon extends GeometricShape 
{
    
    /**
     * Initializes a polygon
     * 
     * @param name the name user wants polygon to have
     */
    public Polygon(String name)
    {
        super(name);
        
    }
    /**
     * Checks if the polygon is a polygon
     * 
     * @return true if object is a polygon; otherwise,
     *          false
     */
    @Override
    public boolean isPolygon()
    {
        return true;
    }
    
    /**
     * Checks whether the polygon is regular
     * 
     * @return true if polygon is reulgar; otherwise,
     *          false
     */
    public abstract boolean isRegular();
    
    /**
     * Returns the number of sides
     * 
     * @return the number of sides
     */
    public abstract int numsides();
}
