import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Level
{
	private String name;
	private char [][] bricks;

	public Level()
	{
		Scanner file = openTheFile();
		name = file.nextLine();
		int height = file.nextInt();
		int length = file.nextInt();
		file.nextLine();
		String [] rows = new String[height];
		bricks = new char[height][length];
		for (int i = 0; i < height; i++)
		{
			rows[i] = file.nextLine();
			for (int j = 0; j < length; j++)
			{
				bricks[i][j] = rows[i].charAt(j);
			}
		}
		printBricks(bricks);
	}

	public void printBricks(char[][] grid)
	{
		for (int i = 0; i < grid.length; i++)
		{
			for (int j = 0; j < grid[0].length; j++)
			{
				System.out.print(grid[i][j]);
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
