package game;

import java.util.StringTokenizer;

/*
 * This class is part of "World of Zuul". "World of Zuul" is a simple,
 * text based adventure game.
 *
 * This parser takes user input and tries to interpret it as a "Zuul"
 * command. Every time it is called it takes a line as a String and
 * tries to interpret the line as a two word command. It returns the command
 * as an object of class Command.
 *
 * The parser has a set of known command words. It checks user input against
 * the known commands, and if the input is not one of the known commands, it
 * returns a command object that is marked as an unknown command.
 *
 * @author  Michael Kolling and David J. Barnes
 * @version 2.0 (Jan 2003)
 */
public class Parser {

    private CommandWords commands;  // holds all valid command words

    /**
     * Create a new Parser.
     */
    public Parser()
    {
        commands = new CommandWords();
    }

    /**
     * Get a new command from the user. The command is read by
     * parsing the 'inputLine'.
     */
    public Command getCommand(String inputLine)
    {
        //String inputLine = "";   // will hold the full input line
        String word1;
        String word2;

        StringTokenizer tokenizer = new StringTokenizer(inputLine);

        if(tokenizer.hasMoreTokens())
            word1 = tokenizer.nextToken();      // get first word
        else
            word1 = null;
        if(tokenizer.hasMoreTokens())
            word2 = tokenizer.nextToken();      // get second word
        else
            word2 = null;

        // note: we just ignore the rest of the input line.

        // Now check whether this word is known. If so, create a command
        // with it. If not, create a "null" command (for unknown command).

        if(commands.isCommand(word1))
            return new Command(word1, word2);
        else
            return new Command(null, word2);
    }

    /**
     * Print out a list of valid command words.
     */
    public String showCommands()
    {
        return commands.showAll();
    }
}
