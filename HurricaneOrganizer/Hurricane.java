import java.io.*;

/**
 * Models hurricane information, including categories.  
 * Works with HurricaneOrganizer, provides object and comparison skeletons.
 * 
 * @author Susan King
 * @author Arnav Dani
 * @version January 17, 2020
 */
public class Hurricane
{
    //Instance variables
    private int year;
    private String month;
    private int pressure;
    private int speed;
    private String name;
    private int category;

    /**
     * Initializes a Hurricane object with no information.
     */
    public Hurricane( )
    {

    }

    /**
     * Initializes a Hurricane object with historical information.
     * 
     * @param year1      year the hurricane took place
     * @param month1     month in String format
     * @param pressure1  hurricane's pressure
     * @param speed1     hurricane's speed in knots
     * @param name1      hurricane's name
     */
    public Hurricane(int year1, String month1, 
    int pressure1, int speed1, String name1)
    {
        year = year1;
        month = month1;
        pressure = pressure1;
        speed = speed1;
        name = name1;
        this.category = determineCategory(speed);
    }

    /**
     * Based upon Saffir/Simpson Hurricane Scale, figures out
     * the category using wind speed in knots.
     * 
     * Use https://en.wikipedia.org/wiki/Saffir%E2%80%93Simpson_scale.
     * 
     * @param knots     wind speed in knots
     * @return Saffir/Simpson Hurricane Scale category
     */
    public int determineCategory(int knots)
    {
        if (knots >= 137)
            return 5;
        if (knots >= 113)
            return 4;
        if (knots >= 96)
            return 3;
        if (knots >= 83)
            return 2;
        if (knots >= 64)
            return 1;

        return 0;
    }

    //Getters

    /**
     * @return name
     */
    public String getName()
    {
        return name;
    }

    /**
     * @return month
     */
    public String getMonth()
    {
        return month;
    }

    /**
     * @return pressue
     */
    public int getPressure()
    {
        return pressure;
    }

    /**
     * @return speed
     */
    public int getSpeed()
    {
        return speed;
    }

    /**
     * @return speed
     */
    public int getYear()
    {
        return year;
    }

    /**
     * @return category
     */
    public int getCategory()
    {
        return category;
    }

    /**
     * Prints specific information about hurricanes
     */
    public void print()
    {
        System.out.println(toString( ));
    }

    /**
     * Formats a printable version
     *      of important information
     * @return formatted string
     */
    public String toString()
    {
        return String.format("%-4d %-5s %-15s %-5d %5d %5d ", 
            year, month, name, category, speed, pressure);
    }

    /**
     * @return 1 if year for this > h
     *          0 if equal
     *          -1 if < h
     * @param h hurricane to compare to
     */
    public int compareYearTo(Hurricane h)
    {
        return new 
            Integer(this.getYear()).compareTo(new Integer(h.getYear()));
    }

    /**
     * @return 1 if this.name > h.name
     *          0 if equal
     *          -1 if < h.name
     * @param h hurricane to compare to
     */
    public int compareNameTo(Hurricane h)
    {
        return 
            this.getName().toLowerCase().compareTo(h.getName().toLowerCase());
    }

    /**
     * @return 1 if pressure for this > h
     *          0 if equal
     *          -1 if < h
     * @param h hurricane to compare to
     */
    public int comparePressureTo(Hurricane h)
    {
        return new 
            Integer(this.getPressure()).compareTo(new Integer(h.getPressure()));
    }

    /**
     * @return 1 if speed for this > h
     *          0 if equal
     *          -1 if < h
     * @param h hurricane to compare to
     */
    public int compareSpeedTo(Hurricane h)
    {
        return new 
            Integer(this.getSpeed()).compareTo(new Integer(h.getSpeed()));
    }

    /**
     * @return 1 if category for this > h
     *          0 if equal
     *          -1 if < h
     * @param h hurricane to compare to
     */
    public int compareCategoryTo(Hurricane h)
    {
        return new 
            Integer(this.getCategory()).compareTo(new Integer(h.getCategory()));
    }

}
