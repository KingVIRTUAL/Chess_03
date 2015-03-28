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
	ChessWorld world;
	public AI(Player opp, ChessWorld theWorld, Color c)
	{
		super(c);
		currentEnemyLocations = (ArrayList)getEnemyLocations(opp, getKing().getGrid());
		myCurrentLocations = (ArrayList)getMyLocations();
		world = theWorld;


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
						if(k.getColor() == getColor())
						{
						return true;
						}
					}
				}
				return false;	
	}
	
	public boolean isGridComparable(ArrayList games, Grid current)
	{
		if(games != null)
		{
			for(int i = 0; i < games.size(); i++)
			{
				ArrayList tempGame = (ArrayList)games.get(i);
				for(int j = 0; j < tempGame.size(); j++)
				{
					Grid tempGrid = (Grid)tempGame.get(j);
					if(current == tempGrid)
					{
						return true;
					}
					
				}
			}
			return false;
		}
		else
		{
			return false;
		}
	}
	
//	public boolean searchApplicableGame(ArrayList games, Grid current)
//	{
//		if(games != null)
//	}
	
	public void smartMove()
	{
		
	}
	
	public void dumbMove()
	{
		for(int i = 0; i < getMyPieces().size(); i++)
		{
			ChessPiece tempPiece = (ChessPiece) getMyPieces().get(i);
			if(tempPiece.getValidMoves() != null)
			{
				if(world.getGrid().isValid((Location) tempPiece.getValidMoves().get(0)))
				{
				tempPiece.moveTo((Location)tempPiece.getValidMoves().get(0));
				return;	
				}
			}
		}
		return;
	}


	public void takeTurn(ChessWorld world) //move low-rank pieces to middle of grid. Move high-rank pieces to middle-sides
	{
	/*	if(world.deserializeGames() != null)
		{
			if(checkSmartMove(world.deserializeGames(), getKing().getGrid()))
			{
				smartMove();
				return;
			}
			else
			{
				dumbMove();
				return;
			}
		}
		else
		{
			dumbMove();
			return;
		}*/
	}




}