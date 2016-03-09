package ru.nsu.ignatenko.brainfuck;

import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * <p> A Read reads a one symbol from input and writes down it
 * in the element to which memory pointer points.</p>
 *
 * @author Tatiana Ignatenko
 */
public class Read implements  Command
{
    final static Logger logger = Logger.getLogger(Program.class);
    private String name = ",";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p> A Read reads a one symbol from input and writes down it
     * in the element to which memory pointer points.</p>
     *
     * @param memory the Memory Read manipulates.
     * @param program the Program Read ignores.
     */
    public void perform(Memory memory, Program program)
    {
        try
        {
            int element;
            element = System.in.read();
            memory.setValue((byte) element);
        }
        catch(IOException e)
        {
            logger.error("Command Read can't read what you typed.");
        }
    }
}