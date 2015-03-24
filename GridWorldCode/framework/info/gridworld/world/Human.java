import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
import java.util.ArrayList;

public class Human extends Player{
	ArrayList<Location> myCurrentLocations = new ArrayList<Location>();
	
	public Human()
	{
		super(Color.BLUE);
		myCurrentLocations = (ArrayList)getMyLocations();
		
	}
	
	public Human(Color c)
	{
		super(c);
	
	}
	
		public boolean checkMyTurnTaken()
	{
		
		for(int i = 0; i < getMyPieces().size(); i++)
		{
			if((Location)myCurrentLocations.get(i) != (Location)getMyLocations().get(i))
			{
				setMyCurrentLocation();
				return true;
			}
		}
		return false;
	}
	
	public void setMyCurrentLocation()
	{
		ArrayList<Location> temp = new ArrayList<Location>();
		for(int i = 0; i < getMyPieces().size(); i++)
		{
			ChessPiece c = (ChessPiece)getMyPieces().get(i);
			temp.add(c.getLocation());
			
		}
		myCurrentLocations = temp;
	}



}