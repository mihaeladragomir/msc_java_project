package game;

/*
 * This class is the main class of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 1.0 (February 2002)
 */
public class CommandWords {

    // a constant array that holds all valid command words
    private static final String validCommands[] = {
        "go", "quit", "help", "pick", "call", "use"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        // nothing to do at the moment...
    }

    /**
     * Check whether a given String is a valid command word.
     * Return true if it is, false if it isn't.
     **/
    public boolean isCommand(String aString)
    {
    	for (String command : validCommands) {
    		if (command.equals(aString)) {
    			return true;
    		}
    	}
        // if we get here, the string was not found in the commands
        return false;
    }

    /*
     * returns a String of all valid commands.
     */
    public String showAll()
    {
        StringBuffer commands = new StringBuffer();
    	for (String command : validCommands) {
            commands.append(command + "  ");
        }
        return commands.toString();
    }
}
