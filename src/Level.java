import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Level
{
	private char [][] bricks;
	
	public Level(int height, int width)
	{
		Scanner file = openTheFile();
		String name1 = file.nextLine();
		System.out.println(name1);
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
