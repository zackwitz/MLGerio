import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Level
{
	private String name;
	private boolean [][] bricks;

	public Level()
	{
		Scanner file = openTheFile();
		name = file.nextLine();
		int height = file.nextInt();
		int length = file.nextInt();
		file.nextLine();
		String [] rows = new String[height];
		bricks = new boolean[height][length];
		for (int i = 0; i < height; i++)
		{
			rows[i] = file.nextLine();
			for (int j = 0; j < length; j++)
			{
				boolean isABrick;
				if (rows[i].charAt(j) == 'X')
				{
					isABrick = true;
				}
				else
					isABrick = false;
				bricks[i][j] = isABrick;
			}
		}
		printBricks(bricks);
	}

	public void printBricks(boolean[][] grid)
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				if (grid[i][j])
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
