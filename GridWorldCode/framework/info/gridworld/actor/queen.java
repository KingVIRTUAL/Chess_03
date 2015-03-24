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
    	setPriority(1);
    }
    
    public ArrayList getValidMoves()
    {
    	ArrayList Valid = new ArrayList();
    	Location check;
    	for(int i = 0; i < 8; i++)
    	{
    		for(int j = 1; j < 8; j++)
    		{
    			if(i == 0)
    			{
    				check = new Location(getLocation().getRow() - j, getLocation().getCol());
    			}
    			else if(i == 1)
    			{
    				check = new Location(getLocation().getRow() - j, getLocation().getCol() + j);
    			}
    			else if(i == 2)
    			{
    				check = new Location(getLocation().getRow(), getLocation().getCol() + j);
    			}
    			else if(i == 3)
    			{
    				check = new Location(getLocation().getRow() + j, getLocation().getCol() + j);
    			}
    			else if(i == 4)
    			{
    				check = new Location(getLocation().getRow() + j, getLocation().getCol());
    			}
    			else if(i == 5)
    			{
    				check = new Location(getLocation().getRow() + j, getLocation().getCol() - j);
    			}
    			else if(i == 6)
    			{
    				check = new Location(getLocation().getRow(), getLocation().getCol() - j);
    			}
    			else
    			{
    				check = new Location(getLocation().getRow() - j, getLocation().getCol() - j);
    			}
    			
				if(getGrid().isValid(check))
				{
					if(getGrid().get(check) == null)
					{
						Valid.add(check);
					}
					else
					{
						if(isLocValid(check))
						{
							Valid.add(check);
							break;
						}
						else
						{
							break;
						}
					}
				}
				else
				{
					break;
				}
    		}
    	}
    	return Valid;
    }

    public void move(boolean horiz, int dir, int spaces)
    {
    	if(horiz == true)
    	{
    		for(int i = 0; i < spaces; i++)
    		{
    		if(getGrid().get(getHorizNext(dir)) == null){

    		super.move(dir);
    		}
    			else if(getGrid().get(getHorizNext(dir)) instanceof ChessPiece)
				{
					ChessPiece c = (ChessPiece)getGrid().get(getHorizNext(dir));
					if(c.getColor() == getColor())
					{
						return;
					}
					else
					{
						attack(getHorizNext(dir));
						return;
					}
				}
				else
				{
					return;
				}
    		}

    	}
    	else
    	{
    		for(int i = 0; i < spaces; i++)
    		{
    		if(getGrid().get(getDiagNext(dir)) == null)
    		{
    		diag(dir);
    		}
    			else if(getGrid().get(getDiagNext(dir)) instanceof ChessPiece)
				{
					ChessPiece c = (ChessPiece)getGrid().get(getDiagNext(dir));
					if(c.getColor() == getColor())
					{
						return;
					}
					else
					{
						attack(getDiagNext(dir));
						return;
					}
				}
				else
				{
					return;
				}
    		}
    	}
    }


}