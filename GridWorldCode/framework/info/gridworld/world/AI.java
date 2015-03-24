import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
//import info.gridworld.actor.king;
import info.gridworld.grid.BoundedGrid;
import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;

public class AI extends Player{
	ArrayList currentEnemyLocations = new ArrayList<Location>();
	ArrayList myCurrentLocations = new ArrayList<Location>();
	public AI(Player opp, Color c)
	{
		super(c);
		currentEnemyLocations = (ArrayList)getEnemyLocations(opp, getKing().getGrid());
		myCurrentLocations = (ArrayList)getMyLocations();


	}

	public ArrayList<ChessPiece> getEnemyPieces( Player temp, Grid g)
	{
		if(g == null)
		{
			return null;
		}
		else
		return temp.getMyPieces();
	}

	public ArrayList getEnemyLocations(Player temp, Grid g)
	{
		ArrayList locs = new ArrayList<Location>();
		if(g != null){

		for(int i = 0; i < getEnemyPieces(temp, g).size(); i++)
		{
		ChessPiece c = (ChessPiece)getEnemyPieces(temp, g).get(i);
		locs.add(c.getLocation());
		}
		return locs;
		}
		else
		{
			return null;
		}
	}



	public boolean checkEnemyTurnTaken(Player temp, Grid g)
	{
		if(currentEnemyLocations == (ArrayList)getEnemyLocations(temp, g))
		{
			return false;
		}
		else
		{
			currentEnemyLocations = (ArrayList)getEnemyLocations(temp, g);
			return true;
		}
	}

	public boolean checkMyTurnTaken()
	{

		if(myCurrentLocations == (ArrayList)getMyLocations())
		{
			return false;
		}
		else
		{
			myCurrentLocations = (ArrayList)getMyLocations();
			return true;
		}
	}
		public ArrayList getPawnAttackable()
		{
			ArrayList<ChessPiece> Attackable = new ArrayList<ChessPiece>();
			for(int i = 0; i < getPawns().size(); i++)
			{
				if(getPawn(i).getGrid().get(getPawn(i).getLocation().getAdjacentLocation(135)) instanceof ChessPiece)
				{
					Location loc = (Location)getPawn(i).getLocation().getAdjacentLocation(135);
					ChessPiece c = (ChessPiece)getPawn(i).getGrid().get(loc);
					if(c.getColor() != getColor())
					{
						Attackable.add(c);
					}
				}
				else if(getPawn(i).getGrid().get(getPawn(i).getLocation().getAdjacentLocation(225)) instanceof ChessPiece)
				{
					Location loc = (Location)getPawn(i).getLocation().getAdjacentLocation(225);
					ChessPiece c = (ChessPiece)getPawn(i).getGrid().get(loc);
					if(c.getColor() != getColor())
					{
						Attackable.add(c);
					}
				}
			}
			return Attackable;
		}
	
	public boolean checkWin(ArrayList<BoundedGrid> game)
	{
				BoundedGrid b = (BoundedGrid)game.get(game.size() - 1);
				ArrayList endPieces = (ArrayList)b.getOccupiedLocations();
				for(int i = 0; i < endPieces.size(); i++)
				{
					if(endPieces.get(i) instanceof king)
					{
						king k = (king)endPieces.get(i);
						if(k.getColor() == Color.RED)
						{
						return true;
						}
					}
				}
				return false;	
	}


	public void takeTurn() //move low-rank pieces to middle of grid. Move high-rank pieces to middle-sides
	{
		    Random rand = new Random();
		int n = rand.nextInt(6);
		if(getPawns().size() > 0)
		{
		
			for(int i = 0; i < getPawns().size(); i++)
			{
				int randomNum = rand.nextInt(getPawns().size()+1)%8;
				if(getPawn(randomNum).getLocation().getRow() == 1)
				{
					getPawn(randomNum).move(2);
					return;
				}
			}
		}
		/*if(getPawnAttackable().size() > 0)
		{
		}
		else if(getPawn(3).getLocation().getRow() == 1)
		{
			getPawn(3).move(2);
			return;
		}
		else if(getPawn(4).getLocation().getRow() == 1)
		{
			getPawn(4).move(1);
			return;
		}*/
		if(getKnight(0).getLocation().getRow() == 0)
		{
			getKnight(0).move(2, true);
			return;
		}
		else if(getKnight(1).getLocation().getRow() == 0)
		{
			getKnight(1).move(2, false);
			return;
		}


		/*for(int i = 0; i < getPawns().size(); i++)
		{
			if(getPawn(i).getGrid().get(getPawn(i).getLocation().getAdjacentLocation(135)) instanceof ChessPiece)
		{
			ChessPiece c = (ChessPiece)getPawn(i).getGrid().get(getPawn(i).getLocation().getAdjacentLocation(135));
			if(c.getColor() != getColor())
			{
				getPawn(i).attack(true);
				return;
			}
		}
			else if(getPawn(i).getGrid().get(getPawn(i).getLocation().getAdjacentLocation(225)) instanceof ChessPiece)
			{
			ChessPiece c = (ChessPiece)getPawn(i).getGrid().get(getPawn(i).getLocation().getAdjacentLocation(135));
			if(c.getColor() != getColor())
			{
				getPawn(i).attack(false);
				return;
			}
			}
		}

		for(int i = 0; i < getMyPieces().size(); i++)
		{
			ChessPiece c = (ChessPiece)getMyPieces().get(i);
			Location loc = c.getLocation();
			ArrayList<Location> check = c.getGrid().getOccupiedAdjacentLocations(loc);
			for(int j = 0; j < check.size(); j++)
			{
				if((Color)c.getGrid().get(check.get(j)).getColor() != getColor())
				{
					int dir = loc.getDirectionToward(check.get(j));

					if(c instanceof pawn)
					{

					if(dir == 135 || dir == 225)
					{
						c.diagAttack((dir-45)/90);
						return;
					}

					}

					else if(c instanceof rook)
					{

					if(dir == 0 || dir == 90 || dir == 180 || dir == 270)
					{
						c.horizAttack(dir/90);
						return;
					}

					}

					else if(c instanceof bishop)
					{

					if(dir == 45 || dir == 135 || dir == 225 || dir == 315)
					{
						c.diagAttack((dir-45)/90);
						return;
					}

					}

					else if(c instanceof queen)
					{

					if(dir == 45 || dir == 135 || dir == 225 || dir == 315)
					{
						c.diagAttack((dir-45)/90);
						return;
					}

					else if(dir == 0 || dir == 90 || dir == 180 || dir == 270)
					{
						c.horizAttack(dir/90);
						return;
					}

					}

					else if(c instanceof king)
					{

					if(dir == 45 || dir == 135 || dir == 225 || dir == 315)
					{
						c.diagAttack((dir-45)/90);
						return;
					}

					else if(dir == 0 || dir == 90 || dir == 180 || dir == 270)
					{
						c.horizAttack(dir/90);
						return;
					}

					}


			}

			//ArrayList<Location> check = (ArrayList)getMyPieces().get(i).getGrid().getOccupiedAdjacentLocations((Location)getMyPieces().get(i).getLocation);
		}
		}*/

	}




}