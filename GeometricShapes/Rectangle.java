
/**
 * Defines the methods of of a rectangle object
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rectangle extends Polygon
{
    // instance variables - replace the example below with your own
    private double length;
    private double width;

    /**
     * Constructor for objects of class Rectangle
     * 
     * @param name      String name of the object
     * @param len       double length of the rectangle
     * @param wid       double width of the rectangle
     */
    public Rectangle(String name, double len, double wid)
    {
        super(name);
        setLength(len);
        setWidth(wid);
    }

    /**
     * Sets length to a reasonable value >= 0
     * 
     * @param len       double len to set length of rect
     * @throw IllegalArg exception if input is less than 0
     */
 
    public void setLength(double len)
    {
        if (len > 0)
        {
            length = len;
        }
        else
        {
            throw new IllegalArgumentException("Length is not legal" +
                "for a rectangle");
        }
    }

    /**
     * Sets width to a reasonable value >= 0
     * 
     * @param wid       double to set width to
     * @throw IllegalArg exception if input is less than 0
     */

    public void setWidth(double wid)
    {
        if (wid > 0)
        {
            width = wid;
        }
        else
        {
            throw new IllegalArgumentException("Width is not legal" +
                "for a rectangle");
        }
    }

    /**
     * Gets the length
     * @return double length
     */
    public double getLength()
    {
        return length;
    }

    /**
     * Gets the wdith
     * @return double width
     */
    public double getWidth()
    {
        return width;
    }

    /**
     * Checks whether two rectangles are approximately equal within EPSILON
     * 
     * @param obj   Object being tested as equal
     * @return true if object is a rectangle and has approximately
     *                  equal side lengths; otherwise,
     *                  false
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Rectangle)
        {
            Rectangle rect = (Rectangle)obj;
            if (isNearlyEqual(this.getLength(), rect.getLength()))
                if (isNearlyEqual(this.getWidth(), rect.getWidth()))
                    return true;
        }
        return false;
    }

    /**
     * Compares the rectangles using their sides in alphabetical order
     * 
     * @param obj  An object being compared to "this"
     * 
     * @return 0 if all the side of the rectangle are nearly the same; otherwise
     *         -1 if all the sides smaller; otherwise
     *         1 if this.length is bigger, 
     *              if this.width is bigger than rectangle.sideB while 
     *              this.sideA nearly equals rect.sideA
     *             
     *         -999 if object is not a rectiangle 
     */
    @Override
    public int compareTo(Object obj)
    {
        if (obj instanceof Rectangle)
        {
            Rectangle rect = (Rectangle) obj;
            if (this.equals(rect))
                return 0;

            Double a = this.getLength();
            Double b = this.getWidth();
            Double rectA = rect.getLength();
            Double rectB = rect.getWidth();

            if (!isNearlyEqual(a, rectA))
            {
                if (a < rectA)
                    return -1;
                return 1;
            }
            if (!isNearlyEqual(b, rectB))
            {
                if (b < rectB)
                    return -1;
                return 1;
            }            

        }        
        return -999;
    }

    /**
     * Converts all the information about the
     *      rectangle object into a string form.
     * 
     * @return formatted information about the rectangle
     */
    @Override
    public String toString()
    {
        String str = "\n\t\t\twidth = %8.5f\tlength = %8.5f" +
            "\n\t\t\tregular: %b\tside count = %d";
        return super.toString() + 
        String.format(str, getWidth(), 
            getLength(),
            isRegular(),
            numsides());
    }

    /**
     * Sets numsides to 4
     * 
     * @return int 4
     */
    @Override
    public int numsides()
    {
        return 4;
    }

    /**
     * Checks whether the rectangle is regular by checking
     *              whether the lengths of both sides are nearly
     *              equal
     * @return true if rectangle is regular; otherwise
     *          false
     */
    @Override
    public boolean isRegular()
    {
        if (isNearlyEqual(this.getLength(), this.getWidth()))
            return true;

        return false;
    }

    /**
     * Gets the area of the rectangle
     *          by multiplying the 2 sides
     * @return      double with value of Area
     */
    @Override
    public double getArea()
    {
        return getWidth() * getLength();
    }

    /**
     * Gets the perimeter of the rectangle
     *          by adding sides
     * @return      double with value of per
     */
    @Override
    public double getPerimeter()
    {
        return 2 * getWidth() + 2 * getLength();
    }

}
