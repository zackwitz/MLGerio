import java.awt.Graphics;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.*;

public class Character extends JFrame
{
	private final int MOVE_CHAR_BY = Level.MOVE_LEVEL_BY;
	private final int SIZE = 75;
	private final int JUMP_STRENGTH = 24;
	private int accel = 0;
	private int x;
	private int y;
	private boolean jumping;
	private boolean onABrick;


	public Character()
	{
		x = 563;
		y = 150;
		jumping = false;
		onABrick = false;
	}

	public int getY ()
	{
		return y;
	}

	public void changeXPos(boolean right)
	{
		if (right)
		{
			x += MOVE_CHAR_BY;
		}
		else
		{
			x -= MOVE_CHAR_BY;
		}
	}

	/**
	 * DOES NOT WORK
	 * 
	 * @param bricks
	 */
	public void fall(boolean [][] bricks)
	{
		int changeInY = 0;
		while (!onABrick)
		{
			y -= changeInY;
			changeInY++;

			int xOfBrick = x / Level.BLOCK_SIDE;
			int yOfBrick = y / Level.BLOCK_SIDE;
			if (bricks[xOfBrick][yOfBrick])
			{
				if (y < Level.BLOCK_SIDE * yOfBrick)
				{
					onABrick = true;
				}
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