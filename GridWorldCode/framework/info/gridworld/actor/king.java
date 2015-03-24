import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;


public class king extends ChessPiece{

	boolean inCheck;

    public king() {
    }

    public king(Color c)
    {
    	setColor(c);
    	setPriority(0);
    }
    
    public ArrayList getValidMoves()
    {
    	ArrayList Valid = new ArrayList();
    	for(int i = 0; i < 4; i++)
    	{
    		if(isLocValid(getHorizNext(i)))
    		{
    			Valid.add(getHorizNext(i));	
    		}
    		if(isLocValid(getDiagNext(i)))
    		{
    			Valid.add(getDiagNext(i));
    		}
    	}
    	return Valid;
    }

    public void move(boolean horiz, int dir)
    {
    	if(horiz == true)
    	{
    		super.move(dir);
    	}
    	else
    	{
    		diag(dir);
    	}
    }

    public boolean checkCheck()
    {
    	return inCheck;
    }

    public void putInCheck(boolean check)
    {
    	inCheck = check;

    }

    {
    }


}