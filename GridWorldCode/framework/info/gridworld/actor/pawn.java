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
    	setPriority(5);
    	hasMoved = false;
    }

	public void move(Location loc)
	{
		hasMoved = true;
		moveTo(loc);
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

    				if(getGrid().get(getHorizNext(dir)) == null)
    				{
    				super.move(dir);
    				}
    				else
    				{
    				return;
    				}
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
    		if(getGrid().get(getHorizNext(dir)) == null)
    				{
    				super.move(dir);
    				}
    		return;
    	}
    }
    
    public void haveImoved()
    {
    	if(getColor() == Color.BLUE)
    	{
    		if(getLocation().getRow() != 6)
    		{
    			hasMoved = true;
    		}
    	}
    	else
    	{
    		if(getLocation().getRow() != 1)
    		{
    			hasMoved = true;
    		}
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

    	public ArrayList<Location> getValidMoves()
    	{
    		haveImoved();
    		ArrayList<Location> Valid = new ArrayList<Location>();
    		ChessPiece temp = new ChessPiece();
    		if(getColor() == Color.BLUE)
    		{
    			for(int i = 0; i < 6; i+=3)
    			{
    				if(getGrid().isValid(getDiagNext(i)))
    				{
    					if(getGrid().get(getDiagNext(i)) instanceof ChessPiece)
    					{
    						temp = (ChessPiece)getGrid().get(getDiagNext(i));
    						if(temp.getColor() != getColor())
    						{
    							Valid.add(temp.getLocation());
    						}
    					}
    				}	
    			}
    		
    			if(hasMoved == false)
    			{
    				if(getGrid().get(getHorizNext(getHorizNext(0), 0)) == null)
    				{
    					Valid.add(getHorizNext(getHorizNext(0), 0));
    				}
    				if(getGrid().get(getHorizNext(0)) == null)
    				{
    					Valid.add(getHorizNext(0));
    				}
    				return Valid;
    			}
    			else
    			{
    				if(getGrid().get(getHorizNext(0)) == null)
    				{
    					Valid.add(getHorizNext(0));
    				}
    				return Valid;
    			}
    		}
    		else
    		{
    			for(int i = 1; i < 3; i++)
    			{
    				if(getGrid().isValid(getDiagNext(i)))
    				{
    					if(getGrid().get(getDiagNext(i)) instanceof ChessPiece)
    					{
    						temp = (ChessPiece)getGrid().get(getDiagNext(i));
    						if(temp.getColor() != getColor())
    						{
    							Valid.add(temp.getLocation());
    						}
    					}
    				}
    			}
    			
    			if(hasMoved == false)
    			{
    				if(getGrid().get(getHorizNext(getHorizNext(2), 2)) == null)
    				{
    					Valid.add(getHorizNext(getHorizNext(2), 2));
    				}
    				if(getGrid().get(getHorizNext(2)) == null)
    				{
    					Valid.add(getHorizNext(2));
    				}
    				return Valid;
    			}
    			else
    			{
    			if(getGrid().get(getHorizNext(2)) == null)
    				{
    					Valid.add(getHorizNext(2));
    				}
    				return Valid;
    			}
    		}
			
			
    	}



    }






