//package info.gridworld.actor;
import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.util.ArrayList;

import java.awt.Color;


public class ChessWorld extends ActorWorld
{
	int clicks;
	ChessPiece selected;
	Grid g;
    public ChessWorld()
    {
    }

    public ChessWorld(Grid grid)
    {
    	super(grid);
    	g = grid;
    	clicks = 0;
    }

    public boolean locationClicked(Location loc)
    {
    	if(g == null)
    	{
    		return false;
    	}
    	else if(clicks == 0)
    	{

    		if(g.get(loc) instanceof ChessPiece)
    		{
    			selected = (ChessPiece)g.get(loc);
    			if(selected.getColor() == Color.BLUE)
    			{
    				clicks++;
    				return true;
    			}
    			else
    			{
    				return true;
    			}
    		}
    		else
    		{
    			return true;
    		}
    	}
    	else
    	{
    		if(selected.checkValidMove(loc))
    		{
    			selected.move(loc);
    			selected = null;
    			clicks = 0;
    			return true;
    		}
    		else
    		{
    			return true;
    		}

    	}
    }
    
    public ArrayList runLoop(Human p1, AI p2)
    {
    	ArrayList grids = new ArrayList();
		while(true)
        {
			if(getGrid() == null)
			{
				return null;
			}

        	else if(p1.checkMyTurnTaken())
        	{
        		if(p2.getKingLocation() == null)
        		{
        			setMessage("BLUE WINS!");
        			return grids;
        		}
        		else if(p1.getKingLocation() == null)
        		{	
        			setMessage("RED WINS!");
        			return grids;
        		}
        		else
        		{
        			p2.takeTurn();
        			grids.add(getGrid());
        		}
        	}
        	show();
        }
    }


}