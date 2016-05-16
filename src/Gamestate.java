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
	private static Level level1;

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
		level1 = new Level();
		
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
			level1.moveRight();
			// switch model right
		}
		else if(keyCode == KeyEvent.VK_LEFT)
		{
			level1.moveLeft();
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
	
	public void paint(Graphics g) 		
	{
		
		level1.paintBricks(g);
	}

}