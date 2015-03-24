import info.gridworld.grid.Location;
import info.gridworld.grid.Grid;
import java.util.ArrayList;
import java.awt.Color;


public class bishop extends ChessPiece
{
	public bishop(Color c)
	{
		setColor(c);
	}

	public void move(int steps, int dir)
	{
		int stepped = 0;
		int deg;
		if(dir < 4){

		for(int i = 0; i < 4; i++)
		{
			if(i == dir)
			{
				deg = ((dir*90)+45);
				Location next = getLocation().getAdjacentLocation(deg);
				while(getGrid().get(next) == null && stepped <= steps)
				{
					diag(dir);
					stepped++;
				}
				}
		}
		}
		else{
			return;
		}




	}

}
