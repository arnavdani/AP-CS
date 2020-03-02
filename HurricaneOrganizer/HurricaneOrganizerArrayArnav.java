import java.io.*;
import java.util.*;

/**
 * Models hurricane information, works with Hurricane class
 * and the user to manipulate an array of hurricane data.
 * 
 * Data came from 
 *      http://www.aoml.noaa.gov/hrd/tcfaq/E23.html except for 2018.
 * 2018 data came from 
 *      https://en.wikipedia.org/wiki/2018_Atlantic_hurricane_season.
 *
 * @author Susan King 
 * @author Arnav Dani
 * @version January 17, 2020
 */
public class HurricaneOrganizerArrayArnav
{
    private Hurricane [] hurricanes;

    /**
     * Reads the inputted file
     * 
     * @throws IOException  if file with the hurricane 
     *      information cannot be found
     * @param filename string to extract data from file
     */
    public HurricaneOrganizerArrayArnav(String filename)throws IOException
    {
        readFile(filename);   
    }

    /**
     * Determines the length of the array of the hurricanes
     * because arrays have predetermined justified lengths
     * 
     * @param filename file with hurricanes
     * @throws IOException  if file with the hurricane 
     *          information cannot be found
     */
    private static int determineFileLength(String filename) throws IOException
    {
        Scanner inFile = new Scanner(new File(filename));
        int counter = 0;

        while (inFile.hasNextLine())
        {
            counter++;
            inFile.nextLine();
        }
        inFile.close();
        return counter;
    }

    /**
     * Reads through the file, takes in the input
     *      and saves the data from the file for future use
     * 
     * @param filename to extract file
     */
    public void readFile(String filename) throws IOException
    {
        hurricanes = new Hurricane [determineFileLength(filename)];
        int hurYear;
        int hurPressure;
        int hurSpeed;
        String hurName;
        String hurMonth;
        Scanner inFile = new Scanner(new File(filename));

        for (int i = 0; i < hurricanes.length; i++)
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
            hurricanes [i] = h;
        }
        inFile.close();
    }

    /**
     * Finds the maximum windspeed of
     *      all the hurricanes in the array
     * 
     * @return int max windspeed
     */
    public int findMaxWindSpeed( )
    {
        int maxSpeed = hurricanes[0].getSpeed();
        for (int i = 1; i < hurricanes.length; i++)
        {
            maxSpeed = Math.max(maxSpeed, hurricanes[i].getSpeed());
        }
        return maxSpeed;
    }

    /**
     * Finds the maximum pressure of
     *      all the hurricanes in the array
     * 
     * @return int max pressure
     */
    public int findMaxPressure( )
    {
        int maxPress = hurricanes[0].getPressure();
        for (int i = 1; i < hurricanes.length; i++)
        {
            maxPress = Math.max(maxPress, hurricanes[i].getPressure());
        }
        return maxPress;
    }

    /**
     * Finds the minimum windspeed of
     *      all the hurricanes in the array
     *  
     *  @return int minimum windspeed
     */
    public int findMinWindSpeed( )
    {
        int minSpeed = hurricanes[0].getSpeed();
        for (int i = 1; i < hurricanes.length; i++)
        {
            minSpeed = Math.min(minSpeed, hurricanes[i].getSpeed());
        }
        return minSpeed;
    }

    /**
     * Finds the minimum pressure of 
     *      all the hurricanes in the array
     * 
     * @return int minimum pressure
     */
    public int findMinPressure( )
    {
        int minPress = hurricanes[0].getPressure();
        for (int i = 1; i < hurricanes.length; i++)
        {
            minPress = Math.min(minPress, hurricanes[i].getPressure());
        }
        return minPress;
    }

    /**
     * Calculates the average windspeed
     *      for each hurricane in the array
     * 
     * @return double average windspeed
     */
    public double calculateAverageWindSpeed( )
    {
        int sum = 0;
        for (int i = 0; i < hurricanes.length; i++)
        {
            sum += hurricanes[i].getSpeed();
        }
        return (double)sum / hurricanes.length;
    }

    /**
     * Calculates the average pressure 
     *      for each hurricane in the array
     * 
     * @return double average pressure
     */
    public double calculateAveragePressure( )
    {
        int sum = 0;
        for (int i = 0; i < hurricanes.length; i++)
        {
            sum += hurricanes[i].getPressure();
        }
        return (double)sum / hurricanes.length;
    }

    /**
     * Calcuates the average category
     *      for each hurricane in the array
     * 
     * @return double average category
     */
    public double calculateAverageCategory( )
    {
        int sum = 0;
        for (int i = 0; i < hurricanes.length; i++)
        {
            sum += hurricanes[i].getCategory();
        }
        return (double)sum / hurricanes.length;
    }

    /**
     * Sorts ascending based upon the hurricanes' years,
     * The algorithm is selection sort.
     */
    public void sortYears()
    {
        int mindex;

        for (int outer = 0; outer < hurricanes.length - 1; outer++)
        {
            mindex = outer;
            for (int inner = outer + 1; inner < hurricanes.length; inner++)
            {
                if (hurricanes[mindex].compareYearTo(hurricanes[inner]) > 0)
                {
                    mindex = inner;
                }
            }

            Hurricane temp = hurricanes[outer];
            hurricanes[outer] = hurricanes[mindex];
            hurricanes[mindex] = temp;
        }
    }

    /**
     * Lexicographically sorts hurricanes based on the hurricanes' name, 
     * using insertion sort.
     */
    public void sortNames()
    {
        for (int outer = 1; outer < hurricanes.length; outer++)
        {
            Hurricane temp = hurricanes[outer];
            int index = outer - 1;
            while (index >= 0 && hurricanes[index].compareNameTo(temp) > 0)
            {
                hurricanes[index + 1] = hurricanes[index];
                index--;
            }
            hurricanes[index + 1] = temp;
        }
    }

    /**
     * Sorts descending based upon the hurricanes' categories,
     * using selection sort.
     */
    public void sortCategories()
    {
        int maxdex;

        for (int outer = 0; outer < hurricanes.length - 1; outer++)
        {
            maxdex = outer;
            for (int inner = outer + 1; inner < hurricanes.length; inner++)
            {
                if (hurricanes[maxdex].compareCategoryTo(hurricanes[inner]) < 0)
                {
                    maxdex = inner;
                }
            }

            Hurricane temp = hurricanes[outer];
            hurricanes[outer] = hurricanes[maxdex];
            hurricanes[maxdex] = temp;
        }
    }  

    /**
     * Sorts descending based upon pressures 
     * using a non-recursive merge sort.
     */
    public void sortPressures()
    {
        int len = hurricanes.length;
        int mid = len / 2;
        sortPressuresHelper(0, mid);
        sortPressuresHelper(mid, len);
        Hurricane[] merged = new Hurricane[len];
        int findex = 0;
        int sindex = mid;
        for (int index = 0; index < len; index++)
        {
            if (findex >= mid)
            {
                merged[index] = hurricanes[sindex];
                sindex++;
            }
            else if (sindex >= len)
            {
                merged[index] = hurricanes[findex];
                findex++;
            }
            else if (hurricanes[findex].comparePressureTo(
                hurricanes[sindex]) > 0)
            {
                merged[index] = hurricanes[findex];
                findex++;
            }
            else
            {
                merged[index] = hurricanes[sindex];
                sindex++;
            }
        }
        hurricanes = merged;
    }

    /**
     * Sorts descending a portion of array based upon pressure, 
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
                if (hurricanes[mindex].comparePressureTo(hurricanes[inner]) < 0)
                    mindex = inner;
            }
            Hurricane temp = hurricanes[outer];
            hurricanes[outer] = hurricanes[mindex];
            hurricanes[mindex] = temp;
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
     * Merges two consecutive parts of an array, using wind speed as a criteria
     * and a temporary array.  The merge results in an ascending sort between
     * the two given indices.
     * 
     * @precondition the two parts are sorted ascending based upon wind speed
     * 
     * @param low   the starting index of one part of the array.
     *              This index is included in the first half.
     * @param mid   the starting index of the second part of the array.
     *              This index is included in the second half.
     * @param high  the ending index of the second part of the array.  
     *              This index is included in the merge.
     */
    private void mergeWindSpeedsSortHelper(int low, int mid, int high
    /* both inclusive */)
    {
        Hurricane[] merge = new Hurricane[high - low + 1];
        int findex = low;
        int sindex = mid;
        for (int index = 0; index < merge.length; index++)
        {
            if (findex >= mid)
            {
                merge[index] = hurricanes[sindex];
                sindex++;
            }
            else if (sindex > high)
            {
                merge[index] = hurricanes[findex];
                findex++;
            }
            else if (hurricanes[findex].compareSpeedTo(hurricanes[sindex]) < 0)
            {
                merge[index] = hurricanes[findex];
                findex++;
            }
            else
            {
                merge[index] = hurricanes[sindex];
                sindex++;
            }
        }

        for (int index = 0; index < merge.length; index++)
        {
            hurricanes[index + low] = merge[index];
        }

    }

    /**
     * Sequential search for all the hurricanes in a given year.
     * 
     * 
     * @return  an array of objects in Hurricane that occured in
     *          the parameter year
     * @param year year
     */
    public Hurricane [] searchYear(int year)
    {
        int counter = 0;
        int len = hurricanes.length;
        for (int i = 0; i < len; i++)
        {
            if (hurricanes[i].getYear() == year)
            {
                counter++;
            }
        }
        Hurricane[] h = new Hurricane[counter];

        counter = 0;
        for (int i = 0; i < len; i++)
        {
            if (hurricanes[i].getYear() == year)
            {
                h[counter] = hurricanes[i];
                counter++;
            }
        }
        return h;
    }     

    /**
     * Binary search for a hurricane name.
     * 
     * @param  name   hurricane name being search
     * @return a Hurricane array of all objects in 
     *      hurricanes with specified name. 
     *         Returns null if there are no matches
     */
    public Hurricane[ ] searchHurricaneName(String name)
    {
        sortNames();
        return searchHurricaneNameHelper(name, 0, hurricanes.length - 1);
    }

    /**
     * Recursive binary search for a hurricane name.  This is the helper
     * for searchHurricaneName.
     * 
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name  hurricane name to search for
     * @param   low   the smallest index that needs to be checked
     * @param   high  the highest index that needs to be checked
     * @return  a Hurricane array of all 
     *          Hurricane objects with a specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] searchHurricaneNameHelper(String name, 
    int low , int high /* both inclusive */)
    {
        if (low == high)
        {
            if (hurricanes[low].getName().equals(name))
            {
                Hurricane[] first = new Hurricane[1];
                first[0] = hurricanes[low];
                return first;
            }
            return null;
        }
        int mid = (low + high) / 2;
        int compare = hurricanes[mid].getName().compareTo(name);
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
     * @precondition  the array must be presorted by the hurricane names
     * 
     * @param   name hurricane name being search for
     * @param   index  the index where a match was found
     * @return  a Hurricane array with objects from 
     *          hurricanes with specified name. 
     *          Returns null if there are no matches
     */
    private Hurricane[ ] retrieveMatchedNames (String name, int index)
    {
        int findex = index - 1;
        while (findex >= 0 && hurricanes[findex].getName().equals(name))
        {
            findex--;
        }
        findex++;

        int lindex = index + 1;
        while (lindex < hurricanes.length && 
            hurricanes[lindex].getName().equals(name))
        {
            lindex++;
        }
        lindex--;

        Hurricane[] match = new Hurricane[lindex - findex + 1];
        for (int i = 0; i < match.length; i++)
            match[i] = hurricanes[i + findex];

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
     * Prints the array using a for:each loop
     * @param hurs hurs
     */
    public void printHurricanes(Hurricane [] hurs)
    {
        if ( hurs == null || hurs.length == 0 )
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
     * methods made to calcuate the values
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
     *  the methods made to calcuate averages
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
            sortWindSpeeds(0, hurricanes.length - 1);
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
        HurricaneOrganizerArrayArnav cane = new 
            HurricaneOrganizerArrayArnav("hurricanedata.txt");
        boolean areWeDoneYet = false;
        while ( !areWeDoneYet)
        {
            areWeDoneYet = cane.interactWithUser( );    
        }
    }
}
