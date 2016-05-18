import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Character implements JFrame {

	private final int SIZE = 75;
	private final int SPEED = 3;
	private final int JUMP_STRENGTH = 24;
	private int accel = 0;
	private int x;
	private int y;
	private boolean jumping = false;
	private boolean facingLeft = false;
	private static Image merioLeft;
	private static Image merioRight;

	public Character (int initX, int initY)
	{
		x = initX;
		y = initY;
	}
	
	public void setDirection ( String direction )
	{
		if (direction.equals("left"))
			facingLeft = true;
		else if (direction.equals("right"))
			facingLeft = false;
		else
			return null;
	}

	public void move ()
	{
		accelerate();
		y += accel;
	}

	public void jump()
	{
		if (!jumping)
		{
			accel = JUMP_STRENGTH;
			jumping = true;
		}
	}

	public void accelerate()
	{
		//need if statement to check for collision
		//if collided, set jumping to false, accel to 0, and y value to height of block + 75
		if (jumping)
		{
			accel -= 1;
		}
	}

	public void draw (Graphics g)
	{
		if (facingLeft)
		{
			g.drawImage(merioLeft, x, y, x+SIZE, y, x, y+SIZE, x+SIZE, y+SIZE, null)
		}
		else
		{
			g.drawImage(merioRight, x, y, x+SIZE, y, x, y+SIZE, x+SIZE, y+SIZE, null)
		}
	}


}
