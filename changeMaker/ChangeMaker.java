import java.util.Scanner;
/**
 * ChangeMaker takes in an amount of money compared to a purchase price 
 *         and returns the amount of change, making sure the user has
 *         payed for all the goods and providing opportunities to terminate
 *         the transaction.
 * 
 * @author Arnav Dani 
 * @version 9.18.19
 */
public class ChangeMaker
{
    /**
     * Constructor for objects of class ChangeMaker
     * 
     */
    public ChangeMaker()
    {

    }
    /**
     * Prompts and gets price of goods from user using Scanner. 
     *        If price is 0, is terminates.
     * @postcondition   input is taken and converted to cents, returned
     * 
     * @return     price in cents
     */
    public int getPrice()
    {
        Scanner in = new Scanner (System.in);
        System.out.println("\nInput the total price or press zero to abort.");
        int price = (int)(in.nextFloat() * 100);
        if (price <= 0)
        {
            return 0;
        }
        return price;
    }
    /**
     * Prompts user and get the amount payed. If amount is 0, method aborts.
     *          If amount is too less, user is prompted again.
     *          If user enters negative number or 0 method is terminated.
     *          When the amount is >= price, amt is returned.
     *          
     * @precondition    price > 0
     * @postcondition   input is taken and converted to cents, returned
     * @param       price needed to be payed in cents
     * @return      total amount payed in cents
     */
    public int getPayment(int price)
    {
        
        //termination check
        if (price <= 0)
        {
            return 0;
        }
        
        //input
        float flt;
        Scanner in = new Scanner (System.in);
        System.out.println("Input the amount payed");
        flt = in.nextFloat();
        int payed = (int)(flt * 100);
       
        //termination
        if (flt <= 0)
        {
            return 0;
        }
        
        //making sure payment is>= to price
        
        while (payed < price)
        {
            System.out.println("The amount entered is too low. " +
                    "Press 1 to add more or 0 to abort.");
            if (in.nextInt() == 1)
            {
                System.out.println("Input added amount.");
                flt += in.nextFloat();
                if (flt <= 0)
                {
                    System.out.println("I'm not giving you money. Bye.");
                    return 0;
                }
                payed = (int)(flt * 100);
                System.out.println("Your total payment is " + flt + ".");
            }
            else
            {
                return 0;
            }
        }        
        
        //return
        
        return payed;
    }     
    /**
     * Calculates, coins, and prints change.
     * 
     * 
     * @postcondition   type and number of coins displayed
     * @param price     price required in cents
     * @param payed     amount payed in cents
     */
    public void calcChange(int price, int payed)
    {
        //termination check        
        if ((payed == 0) ||(price == 0))
        {
            return;
        }
        
        //math for change
        
        int change = payed - price;
        float dollarChange = ((float)(change)) / 100;
        System.out.println("Amout of change is " + dollarChange + ".");
        
        //doing math for change
        
        int dollars = change / 100;
        int cChange = change % 100; // change needed to be split in coins
        int coinChange = cChange;   // storing amt of change before operating
        int quarters = cChange / 25;
        cChange %= 25;
        int dimes = cChange / 10;
        cChange %= 10;
        int nickels = cChange / 5;
        cChange %= 5;
        int pennies = cChange;
        
        //print
        
        
        System.out.printf("\n\nAmount of purchase = $ %.2f \n", price / 100.0);
        System.out.printf("\n\nCash Tendered = $ %.2f \n", payed / 100.0);
        System.out.printf("Change == $ %d.%02d\n", dollars, coinChange);

        System.out.println(""); //space between amounts and coins
        
            //only prints the coin type and value if the value is not zero
        
        if (dollars != 0)
        {
            System.out.println("Dollars: " + dollars);
        }
        
        if (quarters != 0)
        {
            System.out.println("Quarters: " + quarters);
        }
        
        if (dimes != 0)
        {
            System.out.println("Dimes: " + dimes);
        }
        
        if (nickels != 0)
        {
            System.out.println("Nickels: " + nickels);
        }
        
        if (pennies != 0)
        {
            System.out.println("Pennies: " + pennies);
        }
        
        
        System.out.println("\nNEEXXTTTT");
    }
    /**
     * Does a complete transaction for 1 customer 
     *      while allowing exit of transaction.
     *      
     * @precondition    price and payment are not null
     * @postcondition   costumer/vender knows the amount of change needed
     */
    public void doOneTransaction()
    {
        int price = getPrice();
        if (price == 0)
        {
            System.out.println("NEEXXTTTT");
            return;
        }
        int payment = getPayment(price);
        calcChange(price, payment);
    }
    /**
     * Handles transactions for all customers 
     *      with way to terminate using boolean.
     *      
     * @precondition    price and payment are inputted
     * @postcondition   displays change and coin amount as long as 0 
     *                  is not inputted
     * 
     * 
     */
    public void transact()
    {
        boolean nextCustomer = true;
        while (nextCustomer)
        {
            System.out.println("Input 0 anywhere to terminate transaction");
            doOneTransaction();
            Scanner in = new Scanner(System.in);
            System.out.println("\nMore customers?(true/false)");
            nextCustomer = in.nextBoolean();
        }        
    }
    /**
     * Runs the whole thing.
     * 
     * @precondition   nothing
     * @postcondition  getting change
     * @param args  information from the command line
     */
    public static void main(String [ ] args)
    {
        ChangeMaker a = new ChangeMaker();
        a.transact();
    }   
}
