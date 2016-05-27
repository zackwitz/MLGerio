public class Enemy extends Character
{
	
	public Enemy(int setXPos, int setYPos)
	{
		super();
		super.setX(setXPos);
		super.setY(setYPos);
	}
	
	public void moveEnemyLeft()
	{
		super.setX(super.getX() - Level.MOVE_LEVEL_BY);
	}
	
	public void moveEnemyRight()
	{
		super.setX(super.getX() + Level.MOVE_LEVEL_BY);
	}
}
