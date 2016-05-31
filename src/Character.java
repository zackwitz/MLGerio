/**
 * This is the Character class. The character class sets the x and y position,
 * determines the acceleration and jump strength, and sets the character size. 
 * The character class also changes the x and y location of the character and
 * tests to see if the character is on a brick. 
 */

import java.awt.Graphics;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.*;

public class Character extends JFrame
{
	final static int MOVE_CHAR_BY = Level.MOVE_LEVEL_BY;
	final static int SIZE = 75;
	int JUMP_STRENGTH = -30;
	int ACCELERATION = 2;

	private int x;
	private int y;
	private int currentSpeed;
	private boolean onABrick;
	private boolean canJump;

	public Character() //creates character
	{
		x = 563;
		y = 150;
		onABrick = false;
		currentSpeed = 0;
		canJump = true;
	}

	/**
	 * Restarts the character
	 */
	public void restartPosition()
	{
		x = 563;
		y = 150;
		onABrick = false;
		currentSpeed = 0;
		canJump = true;
	}

	/**
	 * Sets the y value
	 * @param newY		the new y value
	 */
	public void setY(int newY)
	{
		y = newY;
	}

	/**
	 * Sets the x value
	 * @param newX		the new x value
	 */
	public void setX(int newX)
	{
		x = newX;
	}

	/**
	 * Get the y value
	 * @return	 the y value
	 */
	public int getY ()
	{
		return y;
	}

	/**
	 * Get the x value
	 * @return 	the x value
	 */
	public int getX()
	{
		return x;
	}

	/**
	 * Get the onABrick 
	 * @return			the onABrick
	 */
	public boolean getOnABrick()
	{
		return onABrick;
	}

	/**
	 * Set the onABrick
	 * @param isOnABrick		the new onABrick
	 */
	public void setOnABrick(boolean isOnABrick)
	{
		onABrick = isOnABrick;
	}

	/**
	 * Check if the character is on a brick
	 * @param bricks			the 2D array of booleans that shows the bricks
	 * @return					whether it is on a brick
	 */
	public boolean isOnABrick(boolean [][] bricks)
	{
		//tests if the character is on a brick and sets the boolean to true or false
		int bricksIn = x / Level.BLOCK_SIDE;
		int bricksDown = (y / Level.BLOCK_SIDE) + 1;
		if (!(bricks[bricksDown][bricksIn] || bricks[bricksDown][bricksIn + 1]))

		{
			onABrick = false;
		}
		else
		{
			onABrick = true;
		}
		return onABrick;
	}

	/**
	 * Tests whether it can change the x position
	 * @param bricks			the 2D array of booleans that shows the bricks
	 * @param right				whether the character is facing right
	 * @return					if it can move
	 */
	public boolean canChangeXPos(boolean [][] bricks, boolean right)
	{
		int bricksIn = (x + 15) / Level.BLOCK_SIDE;
		int bricksDown = y / Level.BLOCK_SIDE;
		//move character in the positive or negative x direction
		if (right)
		{
			if (!bricks[bricksDown][bricksIn + 1])
			{
				x += MOVE_CHAR_BY;
				return true;
			}
		}
		else
		{
			if (!bricks[bricksDown][bricksIn])
			{
				x -= MOVE_CHAR_BY;
				return true;
			}
		}
		return false;
	}

	/**
	 * Make the character fall
	 * @param bricks			the 2D array of booleans that shows the bricks
	 */
	public void fall(boolean [][] bricks)
	{
		//change the y value of the character and make the character fall
		if (y <= 0)
		{
			y = 0;
			currentSpeed = 0;
		}
		currentSpeed += ACCELERATION;

		if (!onABrick)
		{
			y += currentSpeed;
			int bricksIn = x / Level.BLOCK_SIDE;
			int bricksDown = (y / Level.BLOCK_SIDE) + 1;
			if (bricks[bricksDown][bricksIn] || bricks[bricksDown][bricksIn + 1])
			{
				if (y + SIZE >= Level.BLOCK_SIDE * bricksDown)
				{
					y = Level.BLOCK_SIDE * bricksDown - SIZE;
					onABrick = true;
					currentSpeed = 0;
					canJump = true;
					onABrick = true;
				}
			}
		}
	}

/**
 *	Makes the character jump
 * @param bricks 		the 2D array of booleans that shows the bricks
 */
public void jump(boolean [][] bricks)
{
	//allow the character to jump by adding jump strength
	if (canJump)
	{
		canJump = false;
		onABrick = false;
		currentSpeed = JUMP_STRENGTH;
		fall(bricks);
	}
}
}