
/**
 * Circle object with a radius used to compare to others 
 * 
 * @author Arnav Dani 
 * @version 10/24/19
 */
public class Circle extends GeometricShape 
{
    double radius;
    String name;

    /**
     * Constructor for objects of class Circle
     * 
     * @param name  what user wants to name circle object
     * @param rad   what user wants radius of circle object to be
     */
    public Circle(String name, double rad)
    {
        super(name);
        setRadius(rad);

    }

    /**
     * Constructor for objects of class Circle
     * 
     * @param name  what user wants to name this cicle object
     */
    public Circle(String name)
    {
        this(name, 1.0);
    }

    /**
     * Gets the perimeter of the circle
     * 
     * @return perimeter as a double
     */
    @Override
    public double getPerimeter()
    {
        return (2 * radius) * Math.PI;
    }

    /**
     * Gets the area of the circle
     * 
     * @return area as a double
     */
    @Override
    public double getArea()
    {
        return (radius * radius) * Math.PI;
    }

    /**
     * Gets the radius of the circle
     * 
     * @return the radius as an double
     */
    public double getRadius()
    {
        return radius;
    }

    /**
     * Modifies the radius value of a circle
     * 
     * @param rad the proposed length of new radius
     * 
     * @throws IllegalArgumentException if value inputted 
     *          is not a double or >= 0
     */
    public void setRadius(double rad)
    {
        if (rad > 0 && (Double)(rad) instanceof Double)
        {
            radius = rad;
        }
        else
        {
            throw new IllegalArgumentException("Your radius value " +
                "must be greater than 0");
        }
    }

    /**
     * Determines whether the circle object is a polygon
     * 
     * @return false because circles aren't polyons.
     */
    @Override
    public boolean isPolygon()
    {
        return false;
    }

    /**
     * Compares two circle objects using their radii
     * 
     * @param circle being compares to this circle
     * @return 0 if the radii are the same; otherwise
     *         -1 if "this" radius is smaller; otherwise
     *         1 if "this" radius is bigger
     *         -999 if object is not a circle
     */
    @Override
    public int compareTo(Object circle)
    {
        if (circle instanceof Circle)
        {
            Circle circ = ((Circle)circle);
            if (this.getRadius() == circ.getRadius())

                return 0;
            if (this.getRadius() >= circ.getRadius())
                return 1;
            if (this.getRadius() <= circ.getRadius())
                return -1;
        }
        else
            return -999;
        return -999;    
    }

    /**
     * Checks whether 2 circle objects are equal to each other
     *        using thier radius because same rad = same area etc
     * 
     * @param obj object being tested if it is equal to "this"
     * 
     * @return true if the circles have the same radius; otherwise,
     *          false
     */
    @Override
    public boolean equals(Object obj)
    {
        return (this.compareTo(obj) == 0);
    }

    /**
     * Provides a string of information pertinent to the circle
     * 
     * @return String with info about Circle
     */
    @Override
    public String toString()
    {
        return super.toString() + 
        String.format("\n\t\t\tradius=%10.5f", this.getRadius());               
    }

}
