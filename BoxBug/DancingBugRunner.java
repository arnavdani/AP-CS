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
 * @author Susan King    Modified documentation to pass CheckStyle
 * @version August 18, 2015
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import info.gridworld.grid.*;
import info.gridworld.actor.*;
import java.awt.Color;

/**
 * This class runs a world that contains dancing bugs
 * 
 * @author Cay Horstmann
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Susan King       Modified documentation
 * @author Arnav Dani
 * @version July 19 2018
 */
public class DancingBugRunner
{
    
    
    /**
     * Creates a world and populates the world with dancingBugs objects.
     * 
     * @param args  information from the commond line
     */
    public static void main(String[] args)
    {
        int [] routine = new int[3];
        int [] bobRoutine = {4, 37, 42, 2, 55, 6, 96, 8, 2, 9, 7, 5, 3, 1};
        ActorWorld world = new ActorWorld(new UnboundedGrid<Actor>()); 
        DancingBug alice = new DancingBug(4, bobRoutine);
        world.add(new Location(10, 10), alice);
        world.show();
    }
}