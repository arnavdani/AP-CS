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

import info.gridworld.actor.*;
import info.gridworld.grid.*;

/**
 * A Jumper bug that Jumps over air, flowers, and rocks and can only 
 *  land on air or flowers.
 *  If it can not jump, it moves like a normal bug 
 *  except it does not drop flowers.
 *
 * @author Arnav Dani
 * @version 10.1.19
 */
public class JumperBug extends Bug
{
    /**
     * Constructs a Jumper bug that jumps only when it is supposed to.
     */
    public JumperBug()
    {       
    }
    
    /**
     * Jumps to location 2 blocks away if the bug can. 
     *      If it can not, it removes itself.
     */
    public void jump()
    {
        Grid gr = getGrid();
        if (gr == null)
        {
            return;
        }
        Location loc = getLocation();
        Location tempAdj = loc.getAdjacentLocation(getDirection());
        Location doubleNext = tempAdj.getAdjacentLocation(getDirection());
        if (gr.isValid(doubleNext))
        {
            moveTo(doubleNext);
        }
        else
        {
            removeSelfFromGrid();
        }
    }
    
    /**
     * Overrides move to move forward but not drop flowers.
     */
    @Override
    public void move()
    {
        Grid gr = getGrid();
        if (gr == null)
        {
            return;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next))
        {
            moveTo(next);
        }
        else
        {
            removeSelfFromGrid();
        }
    }
    
    /**
     * Checks if the bugs can jump. It can jump over empty cell,
     *      flower, and rock and can land on empty cells or flowers.
     * @return true if it can jump; otherwise,
     *         false.
     */
    public boolean canJump()
    {
        Grid<Actor> gr = getGrid();
        if (gr == null)
        {
            return false;
        }
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        Location dblNext = next.getAdjacentLocation(getDirection());
        if (!gr.isValid(dblNext))
        {
            return false;
        }
        Actor nextTo = gr.get(next);
        Actor dblAdj = gr.get(dblNext);        
        if (((nextTo == null ||
            nextTo instanceof Rock || nextTo instanceof Flower) &&
            ( dblAdj instanceof Flower || dblAdj == null)))
        {
            return true;
        }
        return false;
    }
    
    /**
     * Jumps when the bug can; otherwise, it moves but does not drop flowers.
     */
    @Override
    public void act()
    {           
        if (canJump())
        {
            jump();
        }
        else
        {
            super.act();
        }
    }    
}
