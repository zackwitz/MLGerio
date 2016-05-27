import java.awt.*;
import java.awt.event.*;
import javax.swing.*; 
import javax.*;
import java.util.Random;

/**
 * Henry Fortenbaugh, Scott Little, Zack Hurwitz, Ryan Fishbach 
 * 27 May 2016
 * Merio End of Year Program
 * 
 * This is our end of the year program called MLG_Merio.exe. Our program successfully
 * reads from a text file and then creates the level consisting of bricks. If Merio 
 * is not on a brick, he falls simulating gravity, and if the space bar is pressed
 * Merio can jump once. Also, we have a win and a lose screen that are automatically 
 * displayed once the user wins or loses. There are currently a few issues with the 
 * character falling into a brick, but this glitch is minimal. Also, we are in the 
 * process of adding class hierarchy by adding enemies that can kill Merio. 
 */

public class Gamestate extends JFrame implements KeyListener, ActionListener
{

	final static int FRAME_WIDTH = 1200;
	final static int FRAME_HEIGHT = 750;
	final static int BLOCK_SIDE = 75;
	final static int BLOCKS_VERT = FRAME_HEIGHT / BLOCK_SIDE;
	final static int BLOCKS_HOR = FRAME_WIDTH / BLOCK_SIDE;
	final static int DIFFICULTY = 50;
	private static final int DELAY_IN_MILLISEC = 50;
	private static Level level1;
	private static Enemy [] enemies;
	public static final Image imageRight = new ImageIcon("MerioRight.png").getImage();
	public static final Image imageLeft = new ImageIcon("MerioLeft.png").getImage();
	public static final Image win = new ImageIcon("Win.png").getImage();
	public static final Image lose = new ImageIcon("Lose.png").getImage();
	public static final Image enemy = new ImageIcon("Enemy.png").getImage();
	public static Character merio = new Character();
	private static boolean facingRight = true;
	private static boolean finished = false;

	public Gamestate()
	{
		//empty constructor
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
		Random rand = new Random();
		enemies = new Enemy [DIFFICULTY];
		for (int numEnemies = 0; numEnemies < DIFFICULTY; numEnemies++)
		{
			int totalWidth = level1.getBricks()[0].length * BLOCK_SIDE;
			int enemyX = rand.nextInt(totalWidth - BLOCK_SIDE);
			int enemyY = rand.nextInt(FRAME_HEIGHT - BLOCK_SIDE);
			Enemy nextEnemy = new Enemy(enemyX, enemyY);
			enemies[numEnemies] = nextEnemy;
		}
		Timer clock = new Timer(DELAY_IN_MILLISEC, gs);
		clock.start();  //start the timer and the clock
	}	
	public void actionPerformed(ActionEvent e)
	{
		//repaint and constantly have merio fall. 
		repaint();
		if(!merio.isOnABrick(level1.getBricks()))
		{
			merio.fall(level1.getBricks());
		}
	}

	/**
	 * This method tests to see if a key is pressed and if so the desired action is preformed.
	 */
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		if (keyCode == KeyEvent.VK_R) //R restarts the game
		{
			level1.setPaintLevelFrom(0);
			merio.restartPosition();
			finished = false;
		}
		if (!finished)
		{
			if(keyCode == KeyEvent.VK_RIGHT) //moves the character right
			{
				facingRight = true;
				if (merio.canChangeXPos(level1.getBricks(), facingRight))
				{
					level1.moveRight();	
					for (Enemy next: enemies)
					{
						next.moveEnemyLeft();
					}
				}
			}
			else if(keyCode == KeyEvent.VK_LEFT) //moves the character left
			{

				facingRight = false;
				if (merio.canChangeXPos(level1.getBricks(), facingRight))
				{
					level1.moveLeft();
					for (Enemy next: enemies)
					{
						next.moveEnemyRight();
					}
				}
			}
			else if(keyCode == KeyEvent.VK_SPACE) //makes the character jump
			{
				merio.jump(level1.getBricks());
			}
		}
		System.out.println(merio.getX() + ", " + merio.getY());
	}

	public void keyTyped(KeyEvent e)
	{
	}

	public void keyReleased(KeyEvent e)
	{
	}

	public void paint(Graphics g) //paints the screen and everything on it
	{
		level1.paintBricks(g);
		for (Enemy next: enemies)
		{
			g.drawImage(enemy, next.getX(), next.getY(), this);
		}
		if(facingRight) //merio facing right
		{
			g.drawImage(imageRight, 563, merio.getY(), this);
		}
		else //merio facing left
		{
			g.drawImage(imageLeft, 563, merio.getY(), this);
		}
		if(merio.getX() >= 6450) //changes to win screen
		{
			g.setColor(Color.black);
			g.drawImage(win, 0 , 0 , this);
			finished = true;
		}
		if (merio.getY() >= FRAME_HEIGHT - Character.SIZE) //changes to loose screen
		{
			g.setColor(Color.black);
			g.drawImage(lose, 0, 0, this);
			finished = true;
		}
		if (merio.touchesEnemy(enemies))
		{
			g.setColor(Color.black);
			g.drawImage(lose, 0, 0, this);
			finished = true;
		}
		
	}

}