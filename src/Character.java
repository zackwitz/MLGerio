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
	private int JUMP_STRENGTH = -40;
	private int ACCELERATION = 2;
	private int x;
	private int y;
	private int currentSpeed;
	private boolean onABrick;
	private boolean canJump;


	public Character()
	{
		x = 563;
		y = 150;
		onABrick = false;
		currentSpeed = 0;
		canJump = true;
	}

	public int getY ()
	{
		return y;
	}
	
	public int getX()
	{
		return x;
	}

	public boolean getOnABrick()
	{
		return onABrick;
	}
	
	public boolean isOnABrick(boolean [][] bricks)
	{
		int bricksIn = x / Level.BLOCK_SIDE;
<<<<<<< HEAD
		int bricksDown = y / Level.BLOCK_SIDE;
		if (bricks[bricksDown][bricksIn] || bricks[bricksDown][bricksIn + 1])
=======
		int bricksDown = (y / Level.BLOCK_SIDE) + 1;
		if (!(bricks[bricksDown][bricksIn] || bricks[bricksDown][bricksIn + 1]))
>>>>>>> origin/master
		{
			onABrick = false;
		}
		else
		{
			onABrick = true;
		}
		return onABrick;
	}

	
	public void setOnABrick(boolean isOnABrick)
	{
		onABrick = isOnABrick;
	}

	public boolean canChangeXPos(boolean [][] bricks, boolean right)
	{
		int bricksIn = x / Level.BLOCK_SIDE;
		int bricksDown = y / Level.BLOCK_SIDE;

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

	public void fall(boolean [][] bricks)
	{
		if (y <= 0)
		{
			y = 0;
			currentSpeed = 0;
		}
		currentSpeed += ACCELERATION;
		
		if (!onABrick)
		{
			y += currentSpeed;
<<<<<<< HEAD
			
		}
		if (isOnABrick(bricks))
		{
			y = Level.BLOCK_SIDE * (y / Level.BLOCK_SIDE) - SIZE;
			currentSpeed = 0;
			canJump = true;
			onABrick = true;
=======
			int bricksIn = x / Level.BLOCK_SIDE;
			int bricksDown = (y / Level.BLOCK_SIDE) + 1;
			System.out.println(x + ", " + y);
			System.out.println(bricksIn + ", " + bricksDown);
			if (bricks[bricksDown][bricksIn] || bricks[bricksDown][bricksIn + 1])
			if (y + SIZE >= Level.BLOCK_SIDE * bricksDown)
			{
				y = Level.BLOCK_SIDE * bricksDown - SIZE;
				onABrick = true;
				currentSpeed = 0;
				canJump = true;
				onABrick = true;
			}
>>>>>>> origin/master
		}
		
	}

	public void jump(boolean [][] bricks)
	{
		if (canJump)
		{
			canJump = false;
			onABrick = false;
			currentSpeed = JUMP_STRENGTH;
			fall(bricks);
		}
	}

}