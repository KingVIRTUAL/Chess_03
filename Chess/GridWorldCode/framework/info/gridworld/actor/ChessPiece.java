//package info.gridworld.actor;
import info.gridworld.actor.Actor;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
import java.util.ArrayList;

public class ChessPiece extends Actor{

public Color color;
boolean inJep;

public ChessPiece(){
}



public ChessPiece(Color theColor)
{
	color = theColor;
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




public void horizAttack(int dir)
{
	ChessPiece c = (ChessPiece)getGrid().get(getHorizNext(dir));
        if(c.getColor() == getColor())
        {
        	return;
        }
        else
        {
        	c.removeSelfFromGrid();
        	moveTo(getHorizNext(dir));
        	return;
       	}
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
	if(getGrid().isValid(getDiagNext(dir))){

	ChessPiece c = (ChessPiece)getGrid().get(getDiagNext(dir));
        if(c.getColor() == getColor())
        {
        	return;
        }
        else
        {
        	c.removeSelfFromGrid();
        	moveTo(getDiagNext(dir));
        	return;
        }
	}
	else
		return;




}
/*
public void skipMove(int dir)
{



}
*/

}











