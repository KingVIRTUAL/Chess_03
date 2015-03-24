//package info.gridworld.actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;


public class pawn extends ChessPiece{

	boolean hasMoved;
	int dir;

    //public pawn() {
		//hasMoved = false;
    //}

    public pawn(Color c)
    {
    	setColor(c);
    	hasMoved = false;
    }

    public void move(int k)
    {
    	int dir;
    	if(getColor() == Color.BLUE)
    	{
    		dir = 0;
    	}
    	else
    	{
    	    dir = 2;
    	}

    	if(hasMoved == false)
    	{
    		if(k < 3)
    		{

    			for(int j = 0; j < k; j++)
    			{

    				super.move(dir);
    			}
				hasMoved = true;
				return;
    		}
    		else
    		{
				return;
    		}
    	}
    	else
    	{
    		super.move(dir);
    		return;
    	}
    }


    public void attack(boolean theDir)
    {
    	ArrayList Check = new ArrayList();
    	int dir;

    	if(theDir == true && getColor() == Color.BLUE)
    	{
    		dir = 0;

    	}
    	else if(theDir == true && getColor() == Color.RED)
    	{
    		dir = 1;
    	}
    	else if(theDir == false && getColor() == Color.BLUE)
    	{
    		dir = 3;
    	}
    	else
    	{
    		dir = 2;
    	}
    		diagAttack(dir);

    	}



    }






