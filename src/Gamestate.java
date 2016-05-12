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
		for (int i = 0; i < FRAME_WIDTH; i += BLOCK_SIDE)
		{
			g.drawLine(i, 0, i, FRAME_HEIGHT);
		}
		
		for (int j = 0; j < FRAME_HEIGHT; j += BLOCK_SIDE)
		{
			g.drawLine(0, j, FRAME_WIDTH, j);
		}
	}
	
}
