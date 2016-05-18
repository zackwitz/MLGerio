import java.awt.Graphics;
import java.util.*;
import javax.swing.*;

public class Character extends JFrame
{

	private final int SIZE = 75;
	private final int JUMP_STRENGTH = 24;
	private int accel = 0;
	private int x;
	private int y;
	private boolean jumping;
	private boolean onABrick;

	public Character (int initX, int initY)
	{
		x = initX;
		y = initY;
		jumping = false;
		onABrick = false;
	}

	public int getY ()
	{
		return y;
	}
	
	public void falling()
	{
		int changeInY = 0;
		while (!onABrick)
		{
			y += changeInY;
			changeInY++;
			if (y < (Level.FRAME_HEIGHT - Level.BLOCK_SIDE))
			{
				onABrick = true;
			}
		}
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

	


}