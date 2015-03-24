import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;


public class knight extends ChessPiece{

    public knight() {
    }

    public knight(Color c)
    {
    	setColor(c);
    	setPriority(4);
    }
    
    public ArrayList getValidMoves()
    {
    	ArrayList Valid = new ArrayList();
    	Location check;
    	for(int i = 0; i < 8; i++)
    	{
    		if(i == 0)
    		{
    			check = new Location(getLocation().getRow() - 2, getLocation().getCol() + 1);	
    		}
    		else if(i == 1)
    		{
    			check = new Location(getLocation().getRow() -1, getLocation().getCol() +2);
    		}
    		else if(i == 2)
    		{
    			check = new Location(getLocation().getRow() + 1, getLocation().getCol() +2);
    		}
    		else if(i ==3)
    		{
    			check = new Location(getLocation().getRow() + 2, getLocation().getCol() + 1);
    		}
    		else if(i == 4)
    		{
    			check = new Location(getLocation().getRow() + 2, getLocation().getCol() - 1);
    		}
    		else if(i == 5)
    		{
    			check = new Location(getLocation().getRow() + 1, getLocation().getCol() -2);
    		}
    		else if(i == 6)
    		{
    			check = new Location(getLocation().getRow() - 1, getLocation().getCol() -2);
    		}
    		else
    		{
    			check = new Location(getLocation().getRow() -2, getLocation().getCol() -1);
    		}
    		
    		if(getGrid().isValid(check))
    		{
    			if(isLocValid(check))
    			{
    				Valid.add(check);
    			}
    		}
    	}
    	return Valid;
    	
    }

    public void move(int dir, boolean mirror)
    {
    	Location next;
    	Location loc = getLocation();
    	int nextRow;
    	int nextCol;

		if(dir == 0)
		{
			nextRow = loc.getRow() - 2;
			if(mirror)
			{
			nextCol = loc.getCol() + 1;
			}
			else
			{
			nextCol = loc.getCol() - 1;
			}
		}
		else if(dir == 1)
		{
			nextCol = loc.getCol() + 2;
			if(mirror)
			{
			nextRow = loc.getRow() - 1;
			}
			else
			{
			nextRow = loc.getRow() + 1;
			}
		}
		else if(dir == 2)
		{
			nextRow = loc.getRow() +2;
			if(mirror)
			{
			nextCol = loc.getCol() + 1;
			}
			else
			{
			nextCol = loc.getCol() - 1;
			}
		}
		else if(dir == 3)
		{
			nextCol = loc.getCol() - 2;
			if(mirror)
			{
			nextRow = loc.getRow() + 1;
			}
			else
			{
			nextRow = loc.getRow() - 1;
			}
		}
		else
		{
			return;
		}

		next = new Location(nextRow, nextCol);
		if(getGrid().isValid(next))
		{
			if(getGrid().get(next) == null)
			{
				moveTo(next);
				return;
			}
			else
			{
				attack(next);
				return;
			}
		}
		else
		{
			return;
		}
		//return;



    }
}


