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
//import info.gridworld.actor.ChessWorld;
import info.gridworld.actor.Bug;
import info.gridworld.actor.Rock;
import info.gridworld.grid.Location;
import info.gridworld.grid.BoundedGrid;
import java.util.ArrayList;
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
    	BoundedGrid b = new BoundedGrid(8, 8);
        ChessWorld world = new ChessWorld(b);
        //world.setGrid(b);

       // pawn p= new pawn(Color.RED);

       Human bl = new Human(Color.BLUE); //variable b is already used
       AI r = new AI(bl, Color.RED);
       for(int i = 0; i < 8; i++)
       {
       	world.add(new Location(r.getSpawn().getRow()+1, i), r.getPawn(i));
       	world.add(new Location(bl.getSpawn().getRow(), i), bl.getPawn(i));
       }
       	world.add(r.getSpawn(), r.getRook(0));
       	world.add(new Location(r.getSpawn().getRow(), r.getSpawn().getCol()+7), r.getRook(1));
       	world.add(new Location(bl.getSpawn().getRow()+1, bl.getSpawn().getCol()), bl.getRook(0));
       	world.add(new Location(bl.getSpawn().getRow()+1, bl.getSpawn().getCol()+7), bl.getRook(1));
       	world.add(new Location(r.getSpawn().getRow(), r.getSpawn().getCol()+1), r.getKnight(0));
       	world.add(new Location(r.getSpawn().getRow(), r.getSpawn().getCol()+6), r.getKnight(1));
       	world.add(new Location(bl.getSpawn().getRow()+1, bl.getSpawn().getCol()+1), bl.getKnight(0));
       	world.add(new Location(bl.getSpawn().getRow()+1, bl.getSpawn().getCol()+6), bl.getKnight(1));
       	world.add(new Location(r.getSpawn().getRow(), r.getSpawn().getCol()+2), r.getBishop(0));
       	world.add(new Location(r.getSpawn().getRow(), r.getSpawn().getCol()+5), r.getBishop(1));
       	world.add(new Location(bl.getSpawn().getRow()+1, bl.getSpawn().getCol()+2), bl.getBishop(0));
       	world.add(new Location(bl.getSpawn().getRow()+1, bl.getSpawn().getCol()+5), bl.getBishop(1));
       	world.add(new Location(r.getSpawn().getRow(), r.getSpawn().getCol()+3), r.getQueen());
       	world.add(new Location(r.getSpawn().getRow(), r.getSpawn().getCol()+4), r.getKing());
       	world.add(new Location(bl.getSpawn().getRow()+1, bl.getSpawn().getCol()+3), bl.getKing());
       	world.add(new Location(bl.getSpawn().getRow()+1, bl.getSpawn().getCol()+4), bl.getQueen());
		//world.add(new pawn());
		bl.setMyCurrentLocation();
		r.checkWin(world.runLoop(bl, r));
        //r.takeTurn();
		
    }
}
