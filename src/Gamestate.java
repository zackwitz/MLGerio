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
		//draw outline of grid
		for (int i = 0; i < FRAME_WIDTH; i += BLOCK_SIDE)
		{
			g.drawLine(i, 0, i, FRAME_HEIGHT);
		}
		for (int j = 0; j < FRAME_HEIGHT; j += BLOCK_SIDE)
		{
			g.drawLine(0, j, FRAME_WIDTH, j);
		}
		
		Level level1 = new Level();
		boolean [][] bricks = level1.getBricks();
		paintBricks(g, bricks);
	}
	
	public void paintBricks(Graphics g, boolean [][] bricks)
	{
		for (int row = 0; row < (FRAME_HEIGHT / BLOCK_SIDE); row++)
		{
			for (int col = 0; col < (FRAME_WIDTH / BLOCK_SIDE); col++)
			{
				if (bricks[row][col])
				{
					g.fillRect(BLOCK_SIDE * col, BLOCK_SIDE * row,
							BLOCK_SIDE, BLOCK_SIDE);
				}
			}
		}
	}
}