import java.util.*;

public class Character implements JFrame implements KeyListener, ActionListener {

	private final int SIZE = 75;
	private final int SPEED = 3;
	private final int JUMP_STRENGTH = 10;
	private int accel = 0;
	private int x;
	private int y;
	private boolean jumping = false;
	private boolean 
	
	
	public Character (itn initX, int initY, image left, image right)
	{
		x = initX;
		y = initY;
	}
	
	public void move ()
	{
		accelerate();
		y += accel;
	}
	
	public void keyPressed(KeyEvent e)
	{
		int keyCode = e.getKeyCode();
		else if (keyCode == KeyEvent.VK_LEFT)
		{
			
		}
		else if (keyCode == KeyEvent.VK_RIGHT)
		{
			
		}
		else if (keyCode == KeyEvent.VK_SPACE)
		{
			if (!jumping)
			{
				accel = 24;
			}
			jumping = true;
		}
		repaint();
	}
	public void keyTyped(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	
	public void jump()
	{
		//need if statement to check for collision
		//if collided, set jumping to false, accel to 0, and y value to height of block + 75
		if (!jumping)
		{
			accel = 20;
		}
		jumping = true;
	}
	
	public void accelerate()
	{
		if (jumping)
		{
			accel -= 1;
		}
	}
	
	public void draw (Graphics g)
	{
		
	}
	
	
}
