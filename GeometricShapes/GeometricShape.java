
/**
 * Abstract class GeometricShape - write a description of the class here
 * 
 * @author Arnav Dani
 * @version 10/24/19
 */
public abstract class GeometricShape implements 
                                    Comparable,
                                    AnotherComparable, Nearable
{
    /**
     * variables
     */
    public static final double EPSILON = 1.0e-5;
    private String name = "";
    /**
     * Initializes a GeometricShape, storing a name.
     * 
     * @param shapeName     The name assigned to name.
     */
    public GeometricShape(String shapeName)
    {
        name = shapeName;
    }

    /**
     * Gets the name of the object assigned.
     * 
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name to the new value passed in
     * 
     * @param shapeName     name that user wants to give shape
     */
    public void setName(String shapeName)
    {
        name = shapeName;
    }

    /**
     * Returns the area of the shape
     * 
     * @return  the area
     */
    public abstract double getArea();

    /**
     * Gets perimeter of the shape
     * 
     * @return perimeter
     */
    public abstract double getPerimeter();

    /**
     * Compares the shapes of the geometric shapes
     *      The comparison depends on shapes.
     *      For example, circles are compared using radii.
     * 
     * @param obj       object being compared to this
     * @return  0 if the shapes are identical
     *          1 if "this" shapes is greater
     *          -1 if "this" shapes is less
     */
    @Override
    public abstract int compareTo(Object obj);

    /**
     * Compares the two GeometricShapes using their areas/
     * 
     * @param obj       object being compared in another way
     *                  to this
     * 
     * @return      0 if the shapes are nearly equal
     *              -1 if "this" shape is less than obj
     *               1 if "this" shape is greater than obj
     */
    @Override
    public int compareAnotherWay(Object obj)
    {
        if (obj instanceof GeometricShape)
        {
            double thisArea = this.getArea();
            double objArea = ( (GeometricShape)obj).getArea();
            double diff = thisArea - objArea;
            if (isNearlyEqual(thisArea, objArea))
            {
                return 0;
            }
            else if (diff < 0)
            {
                return -1;
            }
            else
            {
                return 1;
            }
        }
        else
            throw new IllegalArgumentException("Needs to be a GeometricShape");

    }
    /**
     * Checks if two doubles are within an epsilon difference
     * 
     * @param x Double object to be tested to be close to another Double object
     * @param y Double object to be tested to be close to another Double object
     * 
     * @return  true if the difference between the two doubles
     *          is consequential
     *          
     * @throws IllegalArgumentException if x or y isn't a double
     */
    @Override
    public boolean isNearlyEqual(Object x, Object y)
    {
        if (x instanceof Double && y instanceof Double)
        {
            double xD = (Double)x;
            double yD = (Double)y;
            double diff = Math.abs(xD - yD);
            
            return diff <= EPSILON * Math.max(Math.abs(xD), Math.abs(yD));
        }
        else
            throw new IllegalArgumentException("Needs to be a Double");
    }
    /**
     * Checks if object is a polygon
     * 
     * @return true if object is a polygon; otherwise
     *          false;
     */
    public abstract boolean isPolygon();
    
    /**
     * Outputs a string of the object
     * 
     * @return a string relevant to the object
     */
    @Override
    public String toString()
    {
        return String.format("%15s %-7s perimeter = %10.5f  area = %10.5f ", 
                            getClass().getName(),
                            getName(),
                            getPerimeter(),
                            getArea() );
    }
    
}
