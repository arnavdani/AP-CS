
/**
 * Defines methods of a Triangle Object.
 * 
 * @author Arnav Dani
 * @version 11/4/19
 */
public class Triangle extends Polygon

{
    // instance variables - replace the example below with your own
    double sideA = 0;
    double sideB = 0;
    double sideC = 0;

    /**
     * Constructor for objects of class Triangle
     * 
     * @param name  name of object
     * @param a     double length of side a
     * @param b     double length of side b
     * @param c     double length of side c
     */
    public Triangle(String name, double a, double b, double c)
    {
        super(name);
        orderSides(a, b, c);
    }

    /**
     * Orders the side lengths inputted and sets the 
     *      side lengths to the numbers 
     *      with A getting the largest number, b getting the middle, 
     *      and c getting the smallest
     * 
     * @postcondition doubles are ordered with 
     *      a being greatest and c being smallest
     * 
     * @param a     double length of side a
     * @param b     double length of side b
     * @param c     double length of side c
     * 
     */
    public void orderSides(double a, double b, double c)
    {        
        sideA = Math.max(a, Math.max(b, c));
        sideC = Math.min(a, Math.min(b, c));
        sideB = a + b + c - sideA - sideC;           
        if (sideA >= sideB + sideC || sideC <= 0)
            throw new IllegalArgumentException("Invalid side lengths");

    }
    /**
     * Gets the length of sideA
     * 
     * @return int length of sideA
     */
    public double getSideA()
    {
        return sideA;
    }

    /**
     * Gets the length of sideB
     * 
     * @return int length of sideB
     */
    public double getSideB()
    {
        return sideB;
    }

    /**
     * Gets the length of sideC
     * 
     * @return int length of sideC
     */
    public double getSideC()
    {
        return sideC;
    }

    /**
     * Modifies the values of the all the sidelengths
     * 
     * @param a     double length of side a
     * @param b     double length of side b
     * @param c     double length of side c
     * 
     */
    public void setSides(double a, double b, double c)
    {
        orderSides(a, b, c);
    }

    /**
     * Sets the value of sideA
     * 
     * @param a     double length of side a
     * 
     */
    public void setSideA(double a)
    {
        setSides(a, sideB, sideC);
    }

    /**
     * Sets the value of sideB
     * 
     * @param b     double length of b
     */
    public void setSideB(double b)
    {
        setSides(sideA, b, sideC);
    }

    /**
     * Sets the value of sideB
     * 
     * @param c     double length of c
     */
    public void setSideC(double c)
    {
        setSides(sideA, sideB, c);
    }

    /**
     * Returns the perimeter of the triangle
     * 
     * @return double perimeter
     */
    @Override
    public double getPerimeter()
    {
        return sideA + sideB + sideC;
    }

    /**
     * Gets the area of the triangle using herons formula
     * 
     * @return double area of triangle
     */
    @Override
    public double getArea()
    {
        double s = getPerimeter() / 2;
        return Math.sqrt(s * (s - sideA) * (s - sideB) * (s - sideC));

    }

    /**
     * Checks whether two triangles are approximately equal within EPSILON
     * 
     * @return true if object is a triangle and has approximately
     *                  equal side lengths; otherwise,
     *                  false
     * @param obj       object being compared as equal to this
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj instanceof Triangle)
        {
            Triangle tri = (Triangle)obj;
            if (isNearlyEqual(this.getSideA(), tri.getSideA()))
                if (isNearlyEqual(this.getSideB(), tri.getSideB()))
                    if (isNearlyEqual(this.getSideC(), tri.getSideC()))
                        return true;
        }
        return false;
    }

    /**
     * Compares the triangles using their sides in alphabetical order
     * 
     * @param obj  An object being compared to "this"
     * 
     * @return 0 if all the side of the triangle are nearly the same; otherwise
     *         -1 if all the sides smaller; otherwise
     *         1 if this.sideA is bigger, 
     *              if this.sideB is bigger than triangle.sideB while 
     *              this.sideA nearly equals triangle.sideA
     *              if this.sideC is bigger than triangle.sideC while 
     *              this.sideB,A nearly equals triangle.sideB,A
     *         -999 if object is not a triangle 
     */
    @Override
    public int compareTo(Object obj)
    {
        if (obj instanceof Triangle)
        {
            Triangle tri = (Triangle) obj;
            if (this.equals(tri))
                return 0;

            Double a = this.getSideA();
            Double b = this.getSideB();
            Double c = this.getSideC();
            Double triA = tri.getSideA();
            Double triB = tri.getSideB();
            Double triC = tri.getSideC();

            if (!isNearlyEqual(a, triA))
            {
                if (a < triA)
                    return -1;
                return 1;
            }
            if (!isNearlyEqual(b, triB))
            {
                if (b < triB)
                    return -1;
                return 1;
            }

            if (c < triC)
                return -1;
            return 1;

        }        
        return -999;
    }

    /**
     * Checks whether the sides of the triangle are nearly equal,
     *              making it regular
     *              
     * @return true if the triangle is regular; otherwise,
     *              false
     */
    @Override
    public boolean isRegular()
    {
        if (isNearlyEqual(this.getSideA(), this.getSideC()))
            return true;

        return false;
    }

    /**
     * Prints a string for the triangle class that specifies the data
     * 
     * @return string with information of the class.
     */
    @Override
    public String toString()
    {
        String str = "\n\t\t\ta = %8.5f\tb = %8.5f\tc = %8.5f" +
            "\n\t\t\tregular: %b\tside count = %d";

        return super.toString() + 
        String.format(str, getSideA(),
            getSideB(), getSideC(), isRegular(), 
            numsides());
    }

    /**
     * Provides the number of side for a triangle, aka 3
     * 
     * @return 3
     */
    @Override
    public int numsides()
    {
        return 3;
    }
}
