package ru.nsu.ignatenko.brainfuck;

import org.apache.log4j.Logger;

import java.io.IOException;

/**
 *
 * <p>An Interpreter can translate source code into some efficient intermediate
 *    representation and can immediately execute this.</p>
 *
 * @author Tatiana Ignatenko
 */
public class Interpreter
{
    final static Logger logger = Logger.getLogger(Interpreter.class);
    private CommandFactory factory = null;
    private Memory memory = new Memory();

    /**
     * <p> Creates an Interpreter that uses a config file with the given name.</p>
     * @param configName the name of a config file.
     * @throws IOException if a config file with the given name is not found.
     */
    public Interpreter(String configName) throws IOException
    {
        factory = new CommandFactory(configName);
        logger.debug("Created factory.");
    }

    /**
     * <p> Creates an Interpreter that uses the default config file.</p>
     */
    public Interpreter()
    {
        factory = new CommandFactory();
        logger.debug("Created factory.");
    }

    /**
     * <p> Run the given Program.</p>
     * @param program a running Program.
     */
    public void run(Program program)
    {
        logger.debug("Got program: " + program.getName());
        Command command = getCommand(program);
        while(command != null)
        {
            logger.debug("Got command: " + command.getName());
            command.perform(memory, program);
            logger.debug("Performed command.");
            program.increasePtr();
            logger.debug("Increased program pointer.");
            command = getCommand(program);
        }
    }

    private Command getCommand(Program program)
    {
        return factory.create(program.getCommand());
    }

    public static void main(String[] args)
    {
        Interpreter interpreter = null;
        try
        {
           interpreter = new Interpreter(args[0]);
        }
        catch(IOException e)
        {
            interpreter = new Interpreter();
        }
        try
        {
            interpreter.run(new Program(args[1]));
        }
        catch(IOException e)
        {
            interpreter.run(new Program());
        }
    }
}