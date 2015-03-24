//package info.gridworld.actor;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
import java.util.ArrayList;

public class ChessPiece extends Actor{

public Color color;
private boolean inJep;
private int priority;

public ChessPiece(){
}





public ChessPiece(Color theColor)
{
	color = theColor;
}


public boolean checkValidMove(Location loc)
{
	for(int i = 0; i < getValidMoves().size(); i++)
    {
    	Location check = (Location)getValidMoves().get(i);
		if(check.getRow() == loc.getRow() && check.getCol() == loc.getCol())
		{
			return true;
		}
	}
    return false;
}

public ArrayList getValidMoves()
{
	return null;
}
/*public void move()
{
	Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        Location next = loc.getAdjacentLocation(getDirection());
        if (gr.isValid(next)){

            moveTo(next);
        }
        else
            removeSelfFromGrid();
}*/


public int getPriority()
{
	return priority;
}

public void setPriority(int p)
{
	priority = p;
}

public void move(Location loc)
{
	if(getGrid().isValid(loc))
	{
	moveTo(loc);
	}
	else
	{
	return;
	}
}
public void move(int dir)
{
	Grid<Actor> gr = getGrid();
        if (gr == null)
            return;
        Location loc = getLocation();
        for(int i = 0; i < 4; i++)
        {
        	if(i == dir)
        	{
        		Location next = loc.getAdjacentLocation(dir*90);
        		if(gr.isValid(next))
        		{
        			if(gr.get(next) == null)
        			{
        				moveTo(next);
        				return;
        			}


        		else if(gr.get(next) instanceof ChessPiece)
        		{
        			horizAttack(dir);
        			return;
        		}
        		else
        			return;
        		}
        	}

		}
		return;
}

public void diag(int dir)
{
	Location next;
	Grid<Actor> gr = getGrid();

			if(gr == null)
		{
			return;
		}
	Location loc = getLocation();

			next = getDiagNext(dir);
			if(gr.isValid(next))
        		{
        			if(gr.get(next) == null)
        			{
        				moveTo(next);
        				return;
        			}
        			else if(gr.get(next) instanceof ChessPiece)
        			{
        				diagAttack(dir);
        				return;
        			}
        			else
        			{
        				return;
        			}
        			}
        			return;


        		}

public void attack(Location l)
{
	if(getGrid().get(l) instanceof ChessPiece)
	{
	ChessPiece c = (ChessPiece)getGrid().get(l);
	 if(c.getColor() == getColor())
        {
        	return;
        }
        else
        {
        	c.removeSelfFromGrid();
        	moveTo(l);
        	return;
       	}
	}
	else
	{
		return;
	}
}




public void horizAttack(int dir)
{
	Location l = (Location)getHorizNext(dir);
	attack(l);
	return;
}





public Location getHorizNext(int dir)
{
	for(int i = 0; i < 4; i++)
	{
		if(i == dir)
		{
			Location next = getLocation().getAdjacentLocation(dir*90);
			return next;
		}
	}
	return null;
}

public Location getHorizNext(Location l, int dir)
{
	for(int i = 0; i < 4; i++)
	{
		if(i == dir)
		{
			Location next = l.getAdjacentLocation(dir*90);
			return next;
		}
	}
	return null;
}
public Location getDiagNext(Location l, int dir)
{
	for(int i = 0; i < 4; i++)
	{
		if(i == dir)
		{
			Location next = l.getAdjacentLocation((dir*90)+45);
			return next;
		}
	}
	return null;
}

public boolean isLocValid(Location loc)
{
	if(getGrid().isValid(loc))
	{
		if(getGrid().get(loc) == null)
		{
			return true;
		}
		else
		{
			if(getGrid().get(loc) instanceof ChessPiece)
			{
				if(getColor() != (Color) getGrid().get(loc).getColor())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
	}
	else
	{
		return false;
	}
}

/*
public boolean isDiagValid(int dir)
{
	if(getGrid().isValid(getDiagNext(dir)))
	{
		if(getGrid().get(getDiagNext(dir)) == null)
		{
			return true;
		}
		else
		{
			if(getGrid().get(getDiagNext(dir)) instanceof ChessPiece)
			{
				if(getColor() != (Color)getGrid().get(getDiagNext(dir)).getColor())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
	}
	else
	{
		return false;
	}
}

public boolean isHorizValid(int dir)
{
	if(getGrid().isValid(getHorizNext(dir)))
	{
		if(getGrid().get(getHorizNext(dir)) == null)
		{
			return true;
		}
		else
		{
			if(getGrid().get(getHorizNext(dir)) instanceof ChessPiece)
			{
				if(getColor() != (Color)getGrid().get(getHorizNext(dir)).getColor())
				{
					return true;
				}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
	}
	else
	{
		return false;
	}
}
*/
public Location getDiagNext(int dir)
{
	for(int i = 0; i < 4; i++)
	{
		if(i == dir)
		{
			Location next = getLocation().getAdjacentLocation((dir*90)+45);
			return next;
		}
	}
	return null;
}



public void diagAttack(int dir)
{

	Location l = (Location)getDiagNext(dir);
	if(getGrid().isValid(l))
	{
	attack(l);
	return;
	}
	else
	{
	return;
	}




}
/*
public void skipMove(int dir)
{



}
*/

}











