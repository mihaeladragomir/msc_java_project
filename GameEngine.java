package game;
import java.util.Hashtable;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *  This class is part of the "World of Zuul" application.
 *  "World of Zuul" is a very simple, text based adventure game.
 *
 *  This class creates all rooms, creates the parser and starts
 *  the game.  It also evaluates and executes the commands that
 *  the parser returns.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (Jan 2003)
 */
public class GameEngine {

	private Parser parser;
	private Room currentRoom;
	private UserInterface gui;

	static final int minutes=5;
	static final int seconds=0;
	
	/**
	 * Constructor for objects of class GameEngine
	 */
	public GameEngine()
	{
		parser = new Parser();
		createRooms();
		
	}

	public void setGUI(UserInterface userInterface)
	{
		gui = userInterface;
		printWelcome();
	}

	/**
	 * Print out the opening message for the player.
	 */
	private void printWelcome()
	{

	}

	public Room getCurrentRoom(){
		return currentRoom;
	}
	
	/**
	 * Create all the rooms and link their exits together.
	 */
	private void createRooms()
	{
			
		String outsideRoomPath="outside1.jpg";//QUESTION-is that a good way to attach the image path to the room?
		Room outside = new Room("outside",outsideRoomPath, null);
		currentRoom = outside;
		Room room1 = new Room("room 1","room1.jpg", new TemplarKnight("room1c.jpg", "TemplarKnight1"));
		Room room2 = new Room("room 2","room2.jpg", null);
		Room room3 = new Room("room 3","room3.jpg", null);
		Room room4 = new Room("room 4","room4.jpg", null);
		Room room5 = new Room("room 5","room5.jpg", null);
		Room room6 = new Room("room 6","room6.jpg", null);
		Room room7 = new Room("room 7","room7.jpg", null);
		Room room8 = new Room("room 8","room8.jpg", null);

		outside.setExit("south", room1);
		room1.setExit("north", outside);
		room1.setExit("west", room2);

		room2.setExit("west", room3);
		room2.setExit("east", room1);

		room3.setExit("south", room4);
		room3.setExit("east", room2);

		room4.setExit("north", room3);
		room4.setExit("west", room5);

		room5.setExit("east", room4);
		room5.setExit("south", room6);

		room6.setExit("north", room5);
		room6.setExit("east", room7);

		room7.setExit("west", room6);
		room7.setExit("east", room8);

		room8.setExit("west", room7);

	}

	/**
	 * Given a command, process (that is: execute) the command.
	 * If this command ends the game, true is returned, otherwise false is
	 * returned.
	 */
	public void interpretCommand(String commandLine)
	{
		gui.println(commandLine);
		Command command = parser.getCommand(commandLine);

		if(command.isUnknown()) {
			gui.println("I don't know what you mean...");
			return;
		}
		String commandWord = command.getCommandWord();
		if (commandWord.equals("help"))
			printHelp();
		else if (commandWord.equals("go"))
			goRoom(command);
		else if (commandWord.equals("pick"))
			pick(command);
		else if (commandWord.equals("call"))
			call(command);
		else if (commandWord.equals("use"))
			use(command);
		else if (commandWord.equals("quit")) {
			if(command.hasSecondWord())//why to ask what to quit when quit has no second word? 
				gui.println("Quit what?");
			else
				endGame();
		}
	}

	// implementations of user commands:

	/**
	 * Print out some help information.
	 * Here we print some stupid, cryptic message and a list of the
	 * command words.
	 */
	private void printHelp()
	{
		gui.println("You are lost. You are alone. You wander");
		gui.println("around at Monash Uni, Peninsula Campus." + "\n");
		gui.println("Your command words are: " + parser.showCommands());
	}

	/**
	 * Try to go to one direction. If there is an exit, enter the new
	 * room, otherwise print an error message.
	 */
	private void goRoom(Command command)
	{
		if(!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			gui.println("Go where?");
			return;
		}

		String direction = command.getSecondWord();

		// Try to leave current room.
		Room nextRoom = currentRoom.getExit(direction);

		if (nextRoom == null)
			gui.println("There is no door!");
		else {
			currentRoom = nextRoom;
			gui.println(currentRoom.getLongDescription());

		}
	}

	/**
	 * Try to pick up an object. 
	 */
	private String pick(Command command)
	{
		String object = "";
		if(!command.hasSecondWord()) {
			// if there is no second word, we don't know what to pick up...
			gui.println("Pick what?");
			return object ;
		}

		object = command.getSecondWord();
		return object;

	}

	/**
	 * Try to give help answering a question. 
	 */
	private void call(Command command)
	{
		String theAnswer = "That's a hard question!";
		if(!command.hasSecondWord()) {
			// if there is no second word, we don't know where to go...
			gui.println("Answer what?");
			return;
		}
		String question=command.getSecondWord();
		/*if (questionCorrectAnswerList.containsKey("question"))
		{
			theAnswer = questionCorrectAnswerList.get(question);
		}

		gui.println(theAnswer); */   	
	}

	/**
	 * Try to use an object. 
	 */
	private String use(Command command)
	{
		// to use an object I need to get the character from the room ...
		//the key opens the door, so the command go cannot be active before picking up& using the key
		// go room should be refined!!!!
		
		String object = "";
		if(!command.hasSecondWord()) {
			// if there is no second word, we don't know what to pick up...
			gui.println("Use what?");
			return object ;
		}

		object = command.getSecondWord();
		return object;
	}

		
	public String startChronometer(){
		
			ChronometerDisplay cd=new ChronometerDisplay(5, 0);
			String time=cd.getTime();
			System.out.println(time);
			for (int i=0; i<300; i++){
				try{
				cd.sleep(1000);
				cd.timeTick();
				time=cd.getTime();
				//gui.getTimeLabel().setText(time);
				}
				catch (Exception e){
					
				}
				
			}
			return time;
		
	}

	public void endGame()
	{
		int result = JOptionPane.showConfirmDialog(null, 
				"Do you want to exit game?", "Are you sure you want to exit?", JOptionPane.YES_NO_OPTION);

		if(result == JOptionPane.YES_OPTION){
			System.exit(0);
		}
		if(result == JOptionPane.NO_OPTION){

		}
	}

}
