
/**
 * Describes the methods of the square object
 * @author Arnav Dani 
 * @version 11/1/19
 */
public class Square extends Rectangle
{
    

    /**
     * Constructor for objects of class Square
     * @param name  name of the square
     */
    public Square(String name)
    {
        this(name, 1);
    }
    /**
     * Constructor for objects of class Square
     * @param name  name of the square
     * @param len   length of the side
     */
    public Square(String name, double len)
    {
        super(name, len, len);
    }
    /**
     * Sets the length of the square and adjusts both sides
     * 
     * @param len   the length of the side
     */
    @Override
    public void setLength(double len)
    {
        super.setLength(len);
        super.setWidth(len);
    }
    /**
     * Sets the wdith of the square and adjusts both sides
     * 
     * @param len   the width of the side
     */
    @Override
    public void setWidth(double len)
    {
        super.setLength(len);
        super.setWidth(len);
    }
    
    
}



