
/**
 * Describes and specifies information about equaliteral triangle object
 * 
 * @author Arnav Dani
 * @version 10/29/19
 */
public class Equilateral extends Triangle
{
    // instance variables - replace the example below with your own   

    /**
     * Constructor for objects of class Equilateral
     * 
     * @param   name to name object
     * @param   len is the length of all 3 sides
     */
    public Equilateral(String name, double len)
    {
        super(name, len, len, len);
    }
    /**
     * Sides side A to a value and then
     *          sets the other sides to that value 
     *          because the triangle is equilateral
     * 
     * @param len length to set to a
     */    
    @Override
    public void setSideA(double len)
    {
        setSides(len, len, len);
    }
    /**
     * Sides side B to a value and then
     *          sets the other sides to that value 
     *          because the triangle is equilateral
     *@param len length to set to b
     */
    @Override
    public void setSideB(double len)
    {
        orderSides(len, len, len);
    }
    /**
     * Sides side C to a value and then
     *          sets the other sides to that value 
     *          because the triangle is equilateral
     *@param len length to set to c
     */
    @Override
    public void setSideC(double len)
    {
        orderSides(len, len, len);
    }

    
}
