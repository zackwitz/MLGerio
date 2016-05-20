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
	private final int JUMP_STRENGTH = -40;
	private final int ACCELERATION = 2;
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

	public boolean isOnABrick(boolean [][] bricks)
	{
		int bricksIn = x / Level.BLOCK_SIDE;
		int bricksDown = y / Level.BLOCK_SIDE;
		if (bricks[bricksDown][bricksIn])
		{
			if (y + SIZE > Level.BLOCK_SIDE * bricksDown)
			{	
				onABrick = true;
			}
		}
		return onABrick;
	}


	public boolean changeXPos(boolean [][] bricks, boolean right)
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
			System.out.println(y);
			if (isOnABrick(bricks))
			{
				y = Level.BLOCK_SIDE * (y / Level.BLOCK_SIDE) - SIZE;
				System.out.println(y);
				currentSpeed = 0;
				canJump = true;
				onABrick = true;

			}
		}
	}

	public void jump()
	{
		if (canJump)
		{
			canJump = false;
			onABrick = false;
			currentSpeed = JUMP_STRENGTH;
		}
	}
}