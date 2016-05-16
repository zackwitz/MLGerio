import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 			

public class Gamestate extends JFrame implements KeyListener, ActionListener
{

	final static int FRAME_WIDTH = 1200;
	final static int FRAME_HEIGHT = 750;
	final static int BLOCK_SIDE = 75;
	final static int BLOCKS_VERT = FRAME_HEIGHT / BLOCK_SIDE;
	final static int BLOCKS_HOR = FRAME_WIDTH / BLOCK_SIDE;
	private static final int DELAY_IN_MILLISEC = 50;

	public Gamestate()
	{
		Timer clock = new Timer(DELAY_IN_MILLISEC, this);
		clock.start();
	}
	
	public static void main(String[] args)
	{
		Gamestate gs = new Gamestate();
		gs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gs.setTitle("MLGerio");			 				
		gs.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		gs.setVisible(true);
		gs.addKeyListener(gs);
		
	}	
	public void actionPerformed(ActionEvent e)
	{
		repaint();
	}

	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if(keyCode == KeyEvent.VK_RIGHT)
		{
			// move right
			// switch model right
		}
		else if(keyCode == KeyEvent.VK_LEFT)
		{
			//move left
			// switch model to left
		}
		else if(keyCode == KeyEvent.VK_SPACE)
		{
			// jump
		}
	}
	
	public void keyTyped(KeyEvent e)
	{
	}
	
	public void keyReleased(KeyEvent e)
	{
	}
	
	public void paint(Graphics g, int start) 		
	{
		Level level1 = new Level();
		boolean [][] bricks = level1.getBricks();
		boolean levelEnd = false;
		while (!levelEnd)
		{
			paintBricksFrom(g, bricks, start);
		}
	}



	public void paintBricksFrom(Graphics g, boolean [][] bricks, int start)
	{
		g.setColor(Color.white);
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		if (start > bricks[0].length * BLOCK_SIDE)
		{
			start = bricks[0].length * BLOCK_SIDE;
		}
		else if (start < 0)
		{
			start = 0;
		}
		final int BLOCKS_BEFORE_START = start / BLOCK_SIDE;

		//draw outline of grid
		g.setColor(Color.black);
		for (int i = BLOCK_SIDE - (start % BLOCK_SIDE); i < FRAME_WIDTH; i += BLOCK_SIDE)
		{
			g.drawLine(i, 0, i, FRAME_HEIGHT);
		}
		for (int j = 0; j < FRAME_HEIGHT; j += BLOCK_SIDE)
		{
			g.drawLine(0, j, FRAME_WIDTH, j);
		}

		//fill in correct spaces
		for (int row = 0; row < BLOCKS_VERT; row++)
		{
			for (int col = 0; col < BLOCKS_HOR; col++)
			{
				if (col + BLOCKS_BEFORE_START < bricks[0].length)
				{
					if (bricks[row][col + BLOCKS_BEFORE_START])
					{
						g.fillRect(BLOCK_SIDE * col - (start % BLOCK_SIDE),
								BLOCK_SIDE * row, BLOCK_SIDE, BLOCK_SIDE);
					}
				}
			}
			if (bricks[row][BLOCKS_HOR + BLOCKS_BEFORE_START])
			{
				g.fillRect(FRAME_WIDTH - (start % BLOCK_SIDE),
						BLOCK_SIDE * row, start % BLOCK_SIDE, BLOCK_SIDE);
			}
			start += BLOCK_SIDE;
		}
	}
}