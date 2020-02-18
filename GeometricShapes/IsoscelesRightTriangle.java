
/**
 * Provides description and basic methods for a
 *                          right triangle with 2 sides having
 *                          the same length
 * 
 * @author Arnav Dani
 * @version 10/29/19
 */
public class IsoscelesRightTriangle extends Triangle
{

    /**
     * Constructor for objects of class IsoscelesRightTriangle
     * 
     * @param name  name user wants to assign to object
     * 
     * @param leg   int value that user wants the leg of the new 
     *                  IsoRightTriangle to have
     */
    public IsoscelesRightTriangle(String name, double leg)
    {
        super(name, leg * Math.sqrt(2), leg, leg);

    }

    /**
     * Sets the length of the longest side aka the hypotenuse.
     *          Since a is the longest side, setA can be overrided
     *          to set the hypotenuse. Also sets the length of the leg side.
     * @param hypot     double value to set the hypoty
     *                  or sideA to
     */
    @Override
    public void setSideA(double hypot)
    {
        super.setSideA(hypot);
        orderSides(hypot, this.getSideB(), this.getSideC());
    }

    /**
     * Sets length of b to legs
     * Since a is the longest side, setB can be overrided
     *          to set the legs. Since triangle is isosceles,
     *          sideB = sideC at all times, so sideC also has to 
     *          be set to the leg length.
     *          
     * @param leg       value to set to sideB
     */
    @Override
    public void setSideB(double leg)
    {
        double hypot = leg * Math.sqrt(2);
        orderSides(hypot, leg, leg);
    }

    /**
     * Sets length of c to legs
     * Since a is the longest side, setB can be overrided
     *          to set the legs. Since triangle is isosceles,
     *          sideB = sideC at all times, so sideC also has to 
     *          be set to the leg length.
     * @param leg       value to set to sideC
     */
    @Override
    public void setSideC(double leg)
    {
        double hypot = leg * Math.sqrt(2);
        orderSides(hypot, leg, leg);
    }

    
}
