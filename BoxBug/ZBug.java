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
 * A <code>ZBug</code> traces out a z of a given size. <br />
 * 
 * @author Susan King, Arnav Dani    Modified documentation to pass CheckStyle
 * @version 9.20.19
 */
public class ZBug extends Bug
{
    private int steps;
    private int pathStage;
    private int sideLength;
    /**
     * Constructs a z bug that traces a z of a given side length.
     * 
     * @param length the side length
     */
    public ZBug(int length)
    { 
        steps = 0;
        setDirection(Location.EAST);
        pathStage = 0;
        sideLength = length;
    }

    /**
     * Moves to the next location of the z.
     */
    @Override
    public void act()
    {
        if (pathStage > 2)
        {
            return;
        }
        if (steps < sideLength && canMove())
        {
            move();
            steps++;
        }
        else
        {
            pathStage++;
            steps = 0;
            if (pathStage == 1)
            {
                setDirection(Location.SOUTHWEST);
            }
            if (pathStage == 2)
            {
                setDirection(Location.EAST);
            }                        
        }
    }
}
