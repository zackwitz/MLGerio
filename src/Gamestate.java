import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.*;


public class Gamestate extends JFrame implements KeyListener, ActionListener
{

	final static int FRAME_WIDTH = 1200;
	final static int FRAME_HEIGHT = 750;
	final static int BLOCK_SIDE = 75;
	final static int BLOCKS_VERT = FRAME_HEIGHT / BLOCK_SIDE;
	final static int BLOCKS_HOR = FRAME_WIDTH / BLOCK_SIDE;
	private static final int DELAY_IN_MILLISEC = 50;
	private static Level level1;
	public static final Image imageRight = new ImageIcon("MerioRight.png").getImage();
	public static final Image imageLeft = new ImageIcon("MerioLeft.png").getImage();
	public static final Character merio = new Character();
	private static boolean facingRight = true;

	public Gamestate()
	{

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
		Timer clock = new Timer(DELAY_IN_MILLISEC, gs);
		clock.start();
	}	
	public void actionPerformed(ActionEvent e)
	{
		repaint();
		merio.fall(level1.getBricks());
	}

	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		//merio.fall(level1.getBricks());
		if(keyCode == KeyEvent.VK_RIGHT)
		{
			facingRight = true;
			if (merio.changeXPos(level1.getBricks(), facingRight))
			{
				level1.moveRight();	
			}
		}
		else if(keyCode == KeyEvent.VK_LEFT)
		{

			facingRight = false;
			if (merio.changeXPos(level1.getBricks(), facingRight))
			{
				level1.moveLeft();
			}
		}
		else if(keyCode == KeyEvent.VK_SPACE)
		{
			merio.jump();
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
		if(facingRight)
		{
			level1.paintBricks(g);
			g.drawImage(imageRight, 563, merio.getY(), this);
		}
		else
		{
			level1.paintBricks(g);
			g.drawImage(imageLeft, 563, merio.getY(), this);
		}
	}

}