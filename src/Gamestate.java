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
	public static final Image win = new ImageIcon("Win.png").getImage();
	public static Character merio = new Character();
	private static boolean facingRight = true;
	private static boolean finished = false;

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
		if(!merio.isOnABrick(level1.getBricks()))
		{
			merio.fall(level1.getBricks());
		}
	}

	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if (finished)
		{
			if (keyCode == KeyEvent.VK_R)
			{
				merio = new Character();
				finished = false;
			}
		}
		else
		{
			if(keyCode == KeyEvent.VK_RIGHT)
			{
				facingRight = true;
				if (merio.canChangeXPos(level1.getBricks(), facingRight))
				{
					level1.moveRight();	
				}
			}
			else if(keyCode == KeyEvent.VK_LEFT)
			{

				facingRight = false;
				if (merio.canChangeXPos(level1.getBricks(), facingRight))
				{
					level1.moveLeft();
				}
			}
			else if(keyCode == KeyEvent.VK_SPACE)
			{
				merio.jump(level1.getBricks());
			}
			System.out.println(merio.getX());
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
		if(merio.getX() >= 6450)
		{
			g.setColor(Color.black);
			g.drawImage(win, 0 , 0 , this);
			finished = true;
		}
	}

}