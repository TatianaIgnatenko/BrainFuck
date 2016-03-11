package ru.nsu.ignatenko.brainfuck;

import org.apache.log4j.Logger;

import java.io.IOException;
/**
 * <p>An Interpreter executes code which is written in BrainFuck.</p>
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
     *
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
     * <p> Runs the given Program.</p>
     * @param program Program to run.
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
        return factory.create(program.getSymbol());
    }
    /**
     * <p> Initializes an interpreter and runs the given program.</p>
     * <p> If the name of a config file is omitted then the default one will be used.
     * If there are no arguments then the default config file and the default program will be used.</p>
     *
     * @param args arguments
     *             <ul><li> first: the name of the program written in BrainFuck</li></ul>
     *             <ul><li> second: the name of the config file with associations between
     *             commands and classes that implements them.</li></ul>
     */
    public static void main(String[] args)
    {
        Interpreter interpreter = null;
        if(args.length >= 2)
        {
            try
            {
                interpreter = new Interpreter(args[1]);
            }
            catch (IOException e)
            {
                interpreter = new Interpreter();
            }
            try
            {
                interpreter.run(new Program(args[0]));
            }
            catch (IOException e)
            {
                interpreter.run(new Program());
            }
         }
        else if(args.length == 1)
        {
            System.out.println("Can't find a second argument, that's why a second default argument will be used.");
            interpreter = new Interpreter();
            try
            {
                interpreter.run(new Program(args[0]));
            }
            catch(IOException e)
            {
                interpreter.run(new Program());
            }
        }
        else
        {
            System.out.println("Can't find arguments, that's why default arguments will be used.");
            interpreter = new Interpreter();
            interpreter.run(new Program());
        }
    }
}