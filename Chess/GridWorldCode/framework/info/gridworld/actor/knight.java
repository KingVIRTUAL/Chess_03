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
    }

    public void move(int dir, boolean mirror)
    {
    	Location next;
    	Location loc = getLocation();
		for(int i = 0; i < 2; i++)
		{
			if(getGrid().isValid(getHorizNext(loc, dir))){
			loc = getHorizNext(loc, dir);
			}
			else
			{
				return;
			}
		}
		if(mirror == true)
		{
			if(getGrid().isValid(getHorizNext(loc, dir+1))){

			next = getHorizNext(loc, dir+1);
			dir = dir+1;
			}
			else
			{
				return;
			}
		}
		else
		{
			if(getGrid().isValid(getHorizNext(loc, (-dir + 3))))
			{

			next = getHorizNext(loc, (-dir + 3)); //I need to get the 0-3 values. 0:3 1: 2, 2:1, 3:0
			dir = -dir+3;
			}
			else
			{
				return;
			}
		}
        			if(getGrid().get(next) == null)
        			{
        				moveTo(next);
        				return;
        			}


        		else if(getGrid().get(next) instanceof ChessPiece)
        		{
        			horizAttack(dir);
        		}
        		else
        			return;
        	}
        }


