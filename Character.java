package game;
/**
 *  This class defines a character.
 *  
 *
 *  
 *
 * @author  Mihaela Dragomir
 * @version 1.0 (Nov 2011)
 */

public class Character {
	private boolean alive;
	private String cImagePath;
	private String name;
	//private String item;

	public Character( String cImagePath, String characterName){

		this.alive=false;
		this.cImagePath=cImagePath;
		name = characterName;
	}

	/**
	 * 
	 */
	public void appear(){
		alive=true;
	}

	/**
	 * 
	 */
	public void disappear(){
		alive=false;

	}
	
	public boolean isAlive(){
		return alive;
	}
	
	public String getImagePath()
	{
		return cImagePath;
	}

	public String getName(){

		return name;
	}

	/*
	public String getItem(){
		return item;
	}*/
}
