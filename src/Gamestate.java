import java.awt.*;						
import javax.swing.*;

public class Gamestate extends JFrame
{

	final static int FRAME_WIDTH = 1200;
	final static int FRAME_HEIGHT = 750;
	final static int BLOCK_SIDE = 75;

	public static void main(String[] args)
	{
		Gamestate gs = new Gamestate();
		gs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gs.setTitle("MLGerio");			 				
		gs.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		gs.setVisible(true);	
	}

	public void paint(Graphics g) 		
	{


		Level level1 = new Level();
		boolean [][] bricks = level1.getBricks();
		paintBricksFrom(g, bricks, 200);
	}



	public void paintBricksFrom(Graphics g, boolean [][] bricks, int start)
	{
		if (start > bricks[0].length * BLOCK_SIDE)
		{
			start = bricks[0].length * BLOCK_SIDE;
		}
		else if (start < 0)
		{
			start = 0;
		}

		//draw outline of grid
		for (int i = start % BLOCK_SIDE; i < FRAME_WIDTH; i += BLOCK_SIDE)
		{
			g.drawLine(i, 0, i, FRAME_HEIGHT);
		}
		for (int j = 0; j < FRAME_HEIGHT; j += BLOCK_SIDE)
		{
			g.drawLine(0, j, FRAME_WIDTH, j);
		}
		for (int row = 0; row < (FRAME_HEIGHT / BLOCK_SIDE); row++)
		{
			for (int col = 0; col < (FRAME_WIDTH / BLOCK_SIDE); col++)
			{
				if (bricks[start / BLOCK_SIDE][col])
				{
					g.fillRect(BLOCK_SIDE * col, BLOCK_SIDE * row,
							BLOCK_SIDE, BLOCK_SIDE);
				}
				start += BLOCK_SIDE;
			}
		}
	}
}