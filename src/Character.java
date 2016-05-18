import java.awt.Graphics;
import java.util.*;

public class Merio implements JFrame {

	private final int SIZE = 75;
	private final int SPEED = 3;
	private final int JUMP_STRENGTH = 24;
	private int accel = 0;
	private int x;
	private int y;
	private boolean jumping = false;
	private boolean facingLeft = false;

	BufferedImage merioLeft = null;
	try {
		merioLeft = ImageIO.read(new File("MerioLeft.png"));
	} catch (IOException e) {
	}

	BufferedImage merioRight = null;
	try {
		merioRight = ImageIO.read(new File("MerioRight.png"));
	} catch (IOException e) {
	}

	public Character (itn initX, int initY)
	{
		x = initX;
		y = initY;
	}
	
	
	
	//setters for variables here
	
	

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
		if (facing left)
		{
			g.drawImage(merioLeft, x, y, x+SIZE, y, x, y+SIZE, x+SIZE, y+SIZE, null)
		}
		else
		{
			g.drawImage(merioRight, x, y, x+SIZE, y, x, y+SIZE, x+SIZE, y+SIZE, null)
		}
	}


}
