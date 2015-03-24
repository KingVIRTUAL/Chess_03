import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.awt.Color;
import java.util.ArrayList;
//import info.gridworld.actor.pawn;


public class Player {

private Location spawn;
private ArrayList pawns = new ArrayList();
private rook r1;
private rook r2;
private knight kn1;
private knight kn2;
private bishop b1;
private bishop b2;
private king k;
private queen q;
private Color color;

public Player()
{
}

    public Player(Color c)
    {
    	if(c == Color.BLUE)
    	{
    		color = Color.BLUE;
    		spawn = new Location(6, 0);
    	}
    	else
    	{
    		spawn = new Location(0, 0);
    		color = Color.RED;
    	}
    	for(int i = 0; i < 8; i++)
    	{
    		pawns.add(new pawn(c));
    	}
    	r1 = new rook(c);
    	r2 = new rook(c);
    	kn1 = new knight(c);
    	kn2 = new knight(c);
    	b1 = new bishop(c);
    	b2 = new bishop(c);
    	k = new king(c);
    	q = new queen(c);   	
    }
    
    public Color getColor()
    {
    	return color;
    }
    public Location getSpawn()
    {
    	return spawn;
    }
    
    public pawn getPawn(int place)
    {
    	return (pawn)pawns.get(place);
    }
    
    public knight getKnight(int place)
    {
    	if(place == 0)
    	{
    		return kn1;
    	}
    	else if(place == 1)
    	{
    		return kn2;
    	}
    	else
    		return null;
    }
    
    public bishop getBishop(int place)
    {
    	if(place == 0)
    	{
    		return b1;
    	}
    	else if(place == 1)
    	{
    		return b2;
    	}
    	else
    		return null;
    }
    
    public rook getRook(int place)
    {
        if(place == 0)
    	{
    		return r1;
    	}
    	else if(place == 1)
    	{
    		return r2;
    	}
    	else
    		return null;
    }
    
    public king getKing()
    {
    	return k;
    	
    }
    
    public queen getQueen()
    {
    	return q;
    }
    
    public ArrayList getPawns()
    {
    	return pawns;
    }
    
    public Location getKingLocation()
    {
    	return k.getLocation();
    }
    
    public ArrayList getMyPieces()
    {
    	ArrayList myPieces = new ArrayList();
    	for(int i = 0; i < 8; i++)
    	{
    		pawn p = (pawn)pawns.get(i);
    		if(p.getLocation() == null)
    		{
    		}
    		else
    		{
    		myPieces.add(p);
    		}
    	}
    	if(r1.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(r1);
    	}
    	if(r2.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(r1);
    	}
    	if(kn1.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(kn1);
    	}
    	if(kn2.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(kn2);
    	}
    	if(b1.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(b1);
    	}
    	if(b2.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(b2);
    	}
    	if(k.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(k);
    	}
    	if(k.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(k);
    	}
    	if(q.getLocation() == null)
    	{
    	}
    	else
    	{
    	myPieces.add(q);
    	}
    	
    	return myPieces;
    }
    
    	public ArrayList getMyLocations()
	{
		ArrayList locs = new ArrayList<Location>();
		for(int i = 0; i < getMyPieces().size(); i++)
		{
			ChessPiece c = (ChessPiece)getMyPieces().get(i);
			locs.add(c.getLocation());
		}
		return locs;
	}
	

	
	


}