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
	}


    public void move(int dir, int spaces)
    {
		for(int i = 0; i < spaces; i++)
		{
			super.move(dir);
		}
    }


}