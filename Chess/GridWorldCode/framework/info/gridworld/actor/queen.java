import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;

public class queen extends ChessPiece{

    public queen()
    {
    }

    public queen(Color c)
    {
    	setColor(c);
    }

    public void move(boolean horiz, int dir, int spaces)
    {
    	if(horiz == true)
    	{
    		for(int i = 0; i < spaces; i++)
    		{
    		super.move(dir);
    		}
    	}
    	else
    	{
    		for(int i = 0; i < spaces; i++)
    		{
    		diag(dir);
    		}
    	}
    }


}