import java.io.*;
import java.util.*;

/**
 * Models hurricane information, works with Hurricane class
 * and the user to manipulate an arraylist of hurricane data.
 * 
 * Data came from 
 *      http://www.aoml.noaa.gov/hrd/tcfaq/E23.html except for 2018.
 * 2018 data came from 
 *      https://en.wikipedia.org/wiki/2018_Atlantic_hurricane_season.
 *      
 * @author Arnav Dani
 * @version 2.20.20
 *
 */
public class HurricaneOrganizerArrayListArnav
{
    private ArrayList<Hurricane> hurricanes;
    /**
     * Reads the inputted file
     * 
     * @throws IOException  if file with the hurricane 
     *      information cannot be found
     * @param filename string to extract data from file
     */
    public HurricaneOrganizerArrayListArnav(String filename)throws IOException
    {
        readFile(filename);   
    }

    
    /**
     * Reads through the file, takes in the input
     *      and saves the data from the file for future use
     * 
     * @param filename to extract file
     */
    public void readFile(String filename) throws IOException
    {
        int hurYear;
        int hurPressure;
        int hurSpeed;
        String hurName;
        String hurMonth;
        Scanner inFile = new Scanner(new File(filename));
        hurricanes = new ArrayList<Hurricane>();

        while (inFile.hasNextLine())
        {
            hurYear = inFile.nextInt();
            hurMonth = inFile.next();
            hurPressure = inFile.nextInt();
            hurSpeed = inFile.nextInt();
            String tempName = inFile.nextLine();
            hurName = "";
            for (int k = 0; k < tempName.length(); k++)
            {
                char c = tempName.charAt(k);
                if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z'))
                    hurName += c;
            }
            Hurricane h = new Hurricane(hurYear, hurMonth, 
                    hurPressure, hurSpeed, hurName);
            hurricanes.add(h);
        }
        inFile.close();
    }

    /**
     * Finds the maximum windspeed of
     *      all the hurricanes in the arraylist
     * 
     * @return int max windspeed
     */
    public int findMaxWindSpeed( )
    {
        int maxSpeed = hurricanes.get(0).getSpeed();
        for (int i = 1; i < hurricanes.size(); i++)
        {
            maxSpeed = Math.max(maxSpeed, hurricanes.get(i).getSpeed());
        }
        return maxSpeed;
    }

    /**
     * Finds the minimum windspeed of
     *      all the hurricanes in the arraylist
     *  
     *  @return int minimum windspeed
     */
    public int findMinWindSpeed( )
    {
        int minSpeed = hurricanes.get(0).getSpeed();
        for (int i = 1; i < hurricanes.size(); i++)
        {
            minSpeed = Math.min(minSpeed, hurricanes.get(i).getSpeed());
        }
        return minSpeed;
    }

    /**
     * Finds the maximum pressure of
     *      all the hurricanes in the arraylist
     * 
     * @return int max pressure
     */
    public int findMaxPressure( )
    {
        int maxPress = hurricanes.get(0).getPressure();
        for (int i = 1; i < hurricanes.size(); i++)
        {
            maxPress = Math.max(maxPress, hurricanes.get(i).getPressure());
        }
        return maxPress;
    }

    /**
     * Finds the minimum pressure of 
     *      all the hurricanes in the arraylist
     * 
     * @return int minimum pressure
     */
    public int findMinPressure( )
    {
        int minPress = hurricanes.get(0).getPressure();
        for (int i = 1; i < hurricanes.size(); i++)
        {
            minPress = Math.min(minPress, hurricanes.get(i).getPressure());
        }
        return minPress;
    }

    /**
     * Calculates the average windspeed
     *      for each hurricane in the arraylist
     * 
     * @return double average windspeed
     */
    public double calculateAverageWindSpeed( )
    {
        int sum = 0;
        for (int i = 0; i < hurricanes.size(); i++)
        {
            sum += hurricanes.get(i).getSpeed();
        }
        return (double)sum / hurricanes.size();
    }

    /**
     * Calculates the average pressure 
     *      for each hurricane in the arraylist
     * 
     * @return double average pressure
     */
    public double calculateAveragePressure( )
    {
        int sum = 0;
        for (int i = 0; i < hurricanes.size(); i++)
        {
            sum += hurricanes.get(i).getPressure();
        }
        return (double)sum / hurricanes.size();
    }

    /**
     * Calcuates the average category
     *      for each hurricane in the arraylist
     * 
     * @return double average category
     */
    public double calculateAverageCategory( )
    {
        int sum = 0;
        for (int i = 0; i < hurricanes.size(); i++)
        {
            sum += hurricanes.get(i).getCategory();
        }
        return (double)sum / hurricanes.size();
    }

    /**
     * Sorts ascending based upon the hurricanes' years,
     * The algorithm is selection sort.
     */
    public void sortYears()
    {
        int mindex;

        for (int outer = 0; outer < hurricanes.size() - 1; outer++)
        {
            mindex = outer;
            for (int inner = outer + 1; inner < hurricanes.size(); inner++)
            {
                if (hurricanes.get(mindex).compareYearTo(hurricanes.get(inner)) 
                        > 0)
                {
                    mindex = inner;
                }
            }

            Hurricane temp = hurricanes.get(outer);
            hurricanes.set(outer, hurricanes.get(mindex));
            hurricanes.set(mindex, temp);
        }
    }

    /**
     * Lexicographically sorts hurricanes based on the hurricanes' name, 
     * using insertion sort.
     */
    public void sortNames()
    {
        for (int outer = 1; outer < hurricanes.size(); outer++)
        {
            Hurricane temp = hurricanes.get(outer);
            int index = outer - 1;
            while (index >= 0 && hurricanes.get(index).compareNameTo(temp) > 0)
            {
                hurricanes.set(index + 1, hurricanes.get(index));
                index--;
            }
            hurricanes.set(index + 1, temp);
        }
    }

    /**
     * Sorts descending based upon the hurricanes' categories,
     * using selection sort.
     */
    public void sortCategories()
    {
        int maxdex;

        for (int outer = 0; outer < hurricanes.size() - 1; outer++)
        {
            maxdex = outer;
            for (int inner = outer + 1; inner < hurricanes.size(); inner++)
            {
                if (hurricanes.get(maxdex).compareCategoryTo(
                            hurricanes.get(inner)) 
                        < 0)
                {
                    maxdex = inner;
                }
            }

            Hurricane temp = hurricanes.get(outer);
            hurricanes.set(outer, hurricanes.get(maxdex));
            hurricanes.set(maxdex, temp);
        }
    }

    /**
     * Sorts descending based upon pressures using a non-recursive merge sort.
     */
    public void sortPressures()
    {
        int len = hurricanes.size();
        int mid = len / 2;
        sortPressuresHelper(0, mid);
        sortPressuresHelper(mid, len);
        ArrayList<Hurricane> merged = new ArrayList<Hurricane>(len);
        int findex = 0;
        int sindex = mid;
        for (int index = 0; index < len; index++)
        {
            if (findex >= mid)
            {
                merged.add(hurricanes.get(sindex));
                sindex++;
            }
            else if (sindex >= len)
            {
                merged.add(hurricanes.get(findex));
                findex++;
            }
            else if (hurricanes.get(findex).comparePressureTo(
                    hurricanes.get(sindex)) > 0)
            {
                merged.add(hurricanes.get(findex));
                findex++;
            }
            else
            {
                merged.add(hurricanes.get(sindex));
                sindex++;
            }
        }
        hurricanes = merged;
    }

    /**
     * Sorts descending a portion of arraylist based upon pressure, 
     * using selection sort.
     * 
     * @param   start   the first index to start the sort
     * @param   end     one past the last index to sort; hence, end position
     *                  is excluded in the sort
     */
    private void sortPressuresHelper (int start, int end)
    {
        for (int outer = start; outer < end - 1; outer++)
        {
            int mindex = outer;
            for (int inner = outer + 1; inner < end; inner++)
            {
                if (hurricanes.get(mindex).comparePressureTo(
                            hurricanes.get(inner)) < 0)
                    mindex = inner;
            }
            Hurricane temp = hurricanes.get(outer);
            hurricanes.set(outer, hurricanes.get(mindex));
            hurricanes.set(mindex, temp);
        }
    }

    /**
     * Sorts ascending based upon wind speeds using a recursive merge sort. 
     * @param   low low
     * @param   high high
     */
    public void sortWindSpeeds(int low, int high /*both inclusive*/)
    {
        if (high == low)
            return;
        int mid = (high + low) / 2;
        sortWindSpeeds(low, mid);
        sortWindSpeeds(mid + 1, high);
        mergeWindSpeedsSortHelper(low, mid + 1, high);
    }

    /**
     * Merges two consecutive parts of an arraylist, 
     *  using wind speed as a criteria
     * and a temporary arraylist.  
     * The merge results in an ascending sort between
     * the two given indices.
     * 
     * @precondition the two parts are sorted ascending based upon wind speed
     * 
     * @param low   the starting index of one part of the arraylist.
     *              This index is included in the first half.
     * @param mid   the starting index of the second part of the arraylist.
     *              This index is included in the second half.
     * @param high  the ending index of the second part of the arraylist.  
     *              This index is included in the merge.
     */
    private void mergeWindSpeedsSortHelper(int low, int mid, int high
            /* both inclusive */)
    {
        ArrayList<Hurricane> merge = new ArrayList<Hurricane>(high - low + 1);
        int size = high - low + 1;
        int findex = low;
        int sindex = mid;
        for (int index = 0; index < size; index++)
        {
            if (findex >= mid)
            {
                merge.add(hurricanes.get(sindex));
                sindex++;
            }
            else if (sindex > high)
            {
                merge.add(hurricanes.get(findex));
                findex++;
            }
            else if (hurricanes.get(findex).compareSpeedTo(
                    hurricanes.get(sindex)) < 0)
            {
                merge.add(hurricanes.get(findex));
                findex++;
            }
            else
            {
                merge.add(hurricanes.get(sindex));
                sindex++;
            }
        }

        for (int index = 0; index < size; index++)
        {
            hurricanes.set(index + low, merge.get(index));
        }
    }

    /**
     * Sequential search for all the hurricanes in a given year.
     * 
     * 
     * @return  an arraylist of objects in Hurricane that occured in
     *          the parameter year
     * @param year year
     */
    public ArrayList<Hurricane> searchYear(int year)
    {
        int counter = 0;
        int len = hurricanes.size();
        ArrayList<Hurricane> h = new ArrayList<Hurricane>();
        for (int i = 0; i < len; i++)
        {
            if (hurricanes.get(i).getYear() == year)
            {
                h.add(hurricanes.get(i));
            }
        }

        return h;
    }

    /**
     * Binary search for a hurricane name.
     * 
     * @param  name   hurricane name being search
     * @return a Hurricane arraylist of all objects in 
     *      hurricanes with specified name. 
     *         Returns null if there are no matches
     */
    public ArrayList<Hurricane> searchHurricaneName(String name)
    {
        sortNames();
        return searchHurricaneNameHelper(name, 0, hurricanes.size() - 1);
    }

    /**
     * Recursive binary search for a hurricane name.  This is the helper
     * for searchHurricaneName.
     * 
     * @precondition  the arraylist must be presorted by the hurricane names
     * 
     * @param   name  hurricane name to search for
     * @param   low   the smallest index that needs to be checked
     * @param   high  the highest index that needs to be checked
     * @return  a Hurricane arraylist of all 
     *          Hurricane objects with a specified name. 
     *          Returns null if there are no matches
     */
    private ArrayList<Hurricane> searchHurricaneNameHelper(String name, 
    int low , int high /* both inclusive */)
    {
        if (low == high)

        {
            if (hurricanes.get(low).getName().equals(name))
            {
                ArrayList<Hurricane> first = new ArrayList<Hurricane>();
                first.add(hurricanes.get(low));
                return first;
            }
            return null;
        }
        int mid = (low + high) / 2;
        int compare = hurricanes.get(mid).getName().compareTo(name);
        if (compare == 0)
            return retrieveMatchedNames(name, mid);

        if (compare > 0)
        {
            return searchHurricaneNameHelper(name, low, mid - 1);
        }

        return searchHurricaneNameHelper(name, mid + 1, high);
    }

    /**
     * Supports Binary Search method to get the full range of matches.
     * 
     * @precondition  the arraylist must be presorted by the hurricane names
     * 
     * @param   name hurricane name being search for
     * @param   index  the index where a match was found
     * @return  a Hurricane arraylist with objects from 
     *          hurricanes with specified name. 
     *          Returns null if there are no matches
     */
    private ArrayList<Hurricane> retrieveMatchedNames (String name, int index)
    {
        int findex = index - 1;
        while (findex >= 0 && hurricanes.get(findex).getName().equals(name))
        {
            findex--;
        }
        findex++;

        int lindex = index + 1;
        while (lindex < hurricanes.size() && 
            hurricanes.get(lindex).getName().equals(name))
        {
            lindex++;
        }
        lindex--;

        ArrayList<Hurricane> match = new ArrayList<Hurricane>();
        int size = lindex - findex + 1;
        for (int i = 0; i < size; i++)
            match.add(hurricanes.get(i + findex));

        return match;

    }

    /**
     * Generates the header to define value to 
     *      each of the columns of data printed
     */
    public void printHeader()
    {
        System.out.println("\n\n");
        System.out.printf("%-4s %-5s %-15s %-5s %-5s %-5s \n", 
            "Year", "Mon.", "Name", "Cat.", "Knots", "Pressure");
    }

    /**
     * calls the overloaded printHurricanes method to print
     *      every term in the arary
     */
    public void printHurricanes()
    {
        printHurricanes(hurricanes);
    }

    /**
     * Prints the arraylist using a for:each loop
     * @param hurs hurs
     */
    public void printHurricanes(ArrayList<Hurricane> hurs)
    {
        if ( hurs == null || hurs.size() == 0 )
        {
            System.out.println("\nVoid of hurricane data.");
            return;
        }
        printHeader();
        for (Hurricane h : hurs)
        {
            System.out.println(h);
        }
    }

    /**
     * Generates the menu in the scanner for the 
     *  user to decide what he/she wants to do
     */
    public void printMenu()
    {
        System.out.println("\n\nEnter option: ");
        System.out.println("\t 1 - Print all hurricane data \n" +
            "\t 2 - Print maximum and minimum data \n" +
            "\t 3 - Print averages \n" +
            "\t 4 - Sort hurricanes by year \n" +
            "\t 5 - Sort hurricanes by name \n" +
            "\t 6 - Sort hurricanes by category, descending \n" +
            "\t 7 - Sort hurricanes by pressure, descending \n" +
            "\t 8 - Sort hurricanes by speed \n" + 
            "\t 9 - Search for hurricanes for a given year \n" +
            "\t10 - Search for a given hurricane by name \n" +
            "\t11 - Quit \n");
    }

    /**
     * Prints various max and min values using 
     *  methods made to calcuate the values
     */
    public void printMaxAndMin( )
    {
        System.out.println("Maximum wind speed is " + 
            findMaxWindSpeed( ) +
            " knots and minimum wind speed is " + 
            findMinWindSpeed( ) + " knots.");
        System.out.println("Maximum pressure is " + 
            findMaxPressure( ) +
            " and minimum pressure is " + 
            findMinPressure( ) + ".");
    }

    /**
     * Prints the average of multiple stats using 
     * the methods made to calcuate averages
     */
    public void printAverages( )
    {
        System.out.printf("Average wind speed is %5.2f knots. \n" , 
            calculateAverageWindSpeed( ));
        System.out.printf("Average pressure is %5.2f. \n" , 
            calculateAveragePressure( ));
        System.out.printf("Average category is %5.2f. \n" , 
            calculateAverageCategory( ));
    }

    /**
     * 
     * Decides how to act based on the user input taken from the scanner
     *
     * @return done when done
     */

    public boolean interactWithUser( )
    {
        Scanner in = new Scanner(System.in);
        boolean done = false;
        printMenu();
        int choice = in.nextInt();
        // clear the input buffer
        in.nextLine();

        if (choice == 1)
        {
            printHurricanes( ); 
        }
        else if (choice == 2)
        {
            printMaxAndMin( );
        }
        else if (choice == 3)
        {
            printAverages( );
        }
        else if (choice == 4)
        {
            sortYears();
            printHurricanes( );
        }
        else if (choice == 5)
        {
            sortNames();
            printHurricanes( );
        }
        else if (choice == 6)
        {
            sortCategories();
            printHurricanes( );
        }
        else if (choice == 7)
        {
            sortPressures();
            printHurricanes( );
        }
        else if (choice == 8)
        { 
            sortWindSpeeds(0, hurricanes.size() - 1);
            printHurricanes( );
        }
        else if (choice == 9)
        {
            System.out.print("\n\tWhich year do you want to search for?\n\t");
            int year = in.nextInt();
            printHurricanes(searchYear(year));
        }
        else if (choice == 10)
        {
            System.out.print("\n\tWhich name do you want to search for?\n\t");
            String name = in.next();
            printHurricanes(searchHurricaneName(name));
        }
        else if (choice == 11)
        {
            done = true;
        }  
        return done;
    }

    /**
     * Comment the method even though you did not write it.
     * 
     * @param args  user's information from the command line
     * 
     * @throws IOException  if file with the hurricane 
     *              information cannot be found
     */
    public static void main (String [] args) throws IOException
    {
        HurricaneOrganizerArrayListArnav cane = new 
            HurricaneOrganizerArrayListArnav("hurricanedata.txt");
        boolean areWeDoneYet = false;
        while ( !areWeDoneYet)
        {
            areWeDoneYet = cane.interactWithUser( );    
        }
    }

}
