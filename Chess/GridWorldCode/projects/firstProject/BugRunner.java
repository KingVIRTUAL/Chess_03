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
 */

import info.gridworld.actor.ActorWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
//import info.gridworld.actor.pawn;
//import info.gridworld.actor.rook;
import java.awt.Color;

/**
 * This class runs a world that contains a bug and a rock, added at random
 * locations. Click on empty locations to add additional actors. Click on
 * populated locations to invoke methods on their occupants. <br />
 * To build your own worlds, define your own actors and a runner class. See the
 * BoxBugRunner (in the boxBug folder) for an example. <br />
 * This class is not tested on the AP CS A and AB exams.
 */
public class BugRunner
{

	Location corner = new Location(0, 0);

    public static void main(String[] args)
    {
    	boolean turn;
        ActorWorld world = new ActorWorld();
        world.setGrid(new BoundedGrid(8, 8));

       // pawn p= new pawn(Color.RED);
       for(int i = 0; i < 8; i++)
       {
       	world.add(new Location(1, i), new pawn(Color.RED));
       }
       for(int i = 0; i < 8; i++)
       {
       	world.add(new Location(6, i), new pawn(Color.BLUE));
       }
       	world.add(new Location(0, 1), new knight(Color.RED));
       	world.add(new Location(0, 6), new knight(Color.RED));
       	world.add(new Location(7, 1), new knight(Color.BLUE));
       	world.add(new Location(7, 6), new knight(Color.BLUE));
       	world.add(new Location(0, 3), new king(Color.RED));
       	world.add(new Location(7, 4), new king(Color.BLUE));
       	world.add(new Location(0, 4), new queen(Color.RED));
       	world.add(new Location(7, 3), new queen(Color.BLUE));
        world.add(new Location(0, 0), new rook(Color.RED));
        world.add(new Location(0, 7), new rook(Color.RED));
        world.add(new Location(7, 7), new rook(Color.BLUE));
        world.add(new Location(7, 0), new rook(Color.BLUE));
        world.add(new Location(0, 2), new bishop(Color.RED));
        world.add(new Location(0, 5), new bishop(Color.RED));
        world.add(new Location(7, 2), new bishop(Color.BLUE));
        world.add(new Location(7, 5), new bishop(Color.BLUE));
		//world.add(new pawn());
        world.show();




    }
}
