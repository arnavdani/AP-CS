/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 */

import info.gridworld.actor.Bug;
import info.gridworld.grid.Location;

/**
 * A dancing bug that dances because it turns randomly.
 * 
 * @author Susan King    Modified documentation to pass CheckStyle
 * @author Arnav Dani
 * @version September 26 2019
 */
public class DancingBug extends Bug
{
    private int steps;
    private int sideLength;
    int [] turns;
    int index = 0;

    /**
     * Constructs a dancing bug that turns randomly.
     * 
     * @param nums array full of numbers tells to turn
     * @param length amount moved before turns
     */
    public DancingBug(int length, int [] nums)
    {
        sideLength = length;
        steps = 0;
        turns = nums;
        index = 0;

    }

    /**
     * Overrides turns to increase the counter/index.
     * @Override
     */
    public void turn()
    {            
        index %= turns.length;
        setDirection(getDirection() + Location.HALF_RIGHT * 
            ((turns[index]) % 8));
        index++;
    }

    /**
     * Dances according to the array and length passed in
     * @Override
     */
    public void act()
    {                   
        if ( steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            turn();
            steps = 0;
        }


    }
}
