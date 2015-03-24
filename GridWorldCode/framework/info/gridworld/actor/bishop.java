import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;


public class bishop extends ChessPiece
{
	public bishop(Color c)
	{
		setColor(c);
		setPriority(3);
	}

	public void move(int dir, int steps)
	{
		for(int i = 0; i < steps; i++)
		{
			diag(dir);
		}
	}
	
	public void move(Location loc)
	{
		moveTo(loc);
	}
	
	public ArrayList getValidMoves()
	{
		ArrayList Valid = new ArrayList();
		Location check;
		for(int i = 0; i < 4; i++)
		{
			for(int j = 1; j < 8; j++)
			{
				if(i == 0)
				{
					check = new Location(getLocation().getRow() - j, getLocation().getCol() + j);
				}
				else if(i == 1)
				{
					check = new Location(getLocation().getRow() + j, getLocation().getCol() + j);
				}
				else if(i == 2)
				{
					check = new Location(getLocation().getRow() + j, getLocation().getCol() - j);
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

}
