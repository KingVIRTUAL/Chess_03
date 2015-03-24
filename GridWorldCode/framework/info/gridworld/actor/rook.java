//package info.gridworld.actor;
//import info.gridworld.actor.ChessPiece;
import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;

public class rook extends ChessPiece{
private int dir;

	public rook(Color c){

		setColor(c);
		setPriority(2);
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
					check = new Location(getLocation().getRow() - j, getLocation().getCol());
				}
				else if(i == 1)
				{
					check = new Location(getLocation().getRow(), getLocation().getCol() + j);
				}
				else if(i == 2)
				{
					check = new Location(getLocation().getRow() + j, getLocation().getCol());
				}
				else
				{
					check = new Location(getLocation().getRow(), getLocation().getCol() - j);
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
	
    public void move(int dir, int spaces)
    {
		for(int i = 0; i < spaces; i++)
		{
			if(getGrid().get(getHorizNext(dir)) == null)
			{

			super.move(dir);
			}
			else
			{
				if(getGrid().get(getHorizNext(dir)) instanceof ChessPiece)
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
    }


}