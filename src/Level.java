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
		int height = 10;
		int length = file.nextInt();
		String [] rows = new String[height];
		for (int i = 0; i < height; i++)
		{
			rows[i] = file.nextLine();
		}
		for (String row: rows)
		{
			System.out.println(row);
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
