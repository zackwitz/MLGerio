import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Level
{
	final static int FRAME_WIDTH = 1200;
	final static int FRAME_HEIGHT = 750;
	final static int BLOCK_SIDE = 75;
	final static int BLOCKS_VERT = FRAME_HEIGHT / BLOCK_SIDE;
	final static int BLOCKS_HOR = FRAME_WIDTH / BLOCK_SIDE;
	final static int MOVE_LEVEL_BY = 25;
	
	private String name;
	private boolean [][] bricks;
	private int paintLevelFrom;

	public Level()
	{
		paintLevelFrom = 0;
		Scanner file = openTheFile();
		name = file.nextLine();
		int height = file.nextInt();
		int length = file.nextInt();
		file.nextLine();
		String [] rows = new String[height];
		bricks = new boolean[height][length];
		
		//fill each space in the level grid with true if brick or else false
		for (int i = 0; i < height; i++)
		{
			rows[i] = file.nextLine();
			for (int j = 0; j < length; j++)
			{
				boolean isABrick;
				if (rows[i].charAt(j) == 'X')
					isABrick = true;
				else
					isABrick = false;
				bricks[i][j] = isABrick;
			}
		}
		printBricks(bricks);
	}
	
	public boolean [][] getBricks()
	{
		return bricks;
	}

	public void moveRight()
	{
		paintLevelFrom += MOVE_LEVEL_BY;
	}
	
	public void moveLeft()
	{
		paintLevelFrom -= MOVE_LEVEL_BY;
	}
	
	public void setPaintLevelFrom(int from)
	{
		paintLevelFrom = from;
	}
	
	public void paintBricks(Graphics g)
	{
		int start = paintLevelFrom;
		g.setColor(new Color(88, 224, 245));
		g.fillRect(0, 0, FRAME_WIDTH, FRAME_HEIGHT);
		if (start > bricks[0].length * BLOCK_SIDE)
		{
			start = bricks[0].length * BLOCK_SIDE;
		}
		else if (start < 0)
		{
			start = 0;
		}
		final int BLOCKS_BEFORE_START = start / BLOCK_SIDE;
		
		
		//draw outline of grid
//		for (int i = BLOCK_SIDE - (start % BLOCK_SIDE); i < FRAME_WIDTH;
//				i += BLOCK_SIDE)
//		{
//			g.drawLine(i, 0, i, FRAME_HEIGHT);
//		}
//		for (int j = 0; j < FRAME_HEIGHT; j += BLOCK_SIDE)
//		{
//			g.drawLine(0, j, FRAME_WIDTH, j);
//		}

		//fill in correct spaces
		g.setColor(new Color(184, 124, 80));
		for (int row = 0; row < BLOCKS_VERT; row++)
		{
			for (int col = 0; col < BLOCKS_HOR; col++)
			{
				if (col + BLOCKS_BEFORE_START < bricks[0].length)
				{
					if (bricks[row][col + BLOCKS_BEFORE_START])
					{
						g.fillRect(BLOCK_SIDE * col - (start % BLOCK_SIDE),
								BLOCK_SIDE * row, BLOCK_SIDE, BLOCK_SIDE);
					}
				}
			}
			if (bricks[row][BLOCKS_HOR + BLOCKS_BEFORE_START])
			{
				g.fillRect(FRAME_WIDTH - (start % BLOCK_SIDE),
						BLOCK_SIDE * row, start % BLOCK_SIDE, BLOCK_SIDE);
			}
			start += BLOCK_SIDE;
		}
	}
	
	public void printBricks(boolean[][] level)
	{
		for (int i = 0; i < level.length; i++)
		{
			for (int j = 0; j < level[0].length; j++)
			{
				if (level[i][j])
				{
					System.out.print('X');
				}
				else
				{
					System.out.print('~');
				}
			}
			System.out.println();
		}
	}
	
	private static Scanner openTheFile()
	{
		Scanner file = null;
		// Open the file. Note that Eclipse looks for the file in your
		// workspace inside your project folder (NOT in your src folder.)
		try
		{
			file = new Scanner(new File("MLGerio Levels"));
		}
		catch (IOException e)
		{
			// Something went wrong!
			System.out.println("File error - file not found");
		}
		return file;
	}

}
