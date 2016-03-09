package ru.nsu.ignatenko.brainfuck;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 *
 * <p>A Program stores data from a program file.</p>
 *
 * @author Tatiana Ignatenko
 */
public class Program
{
    final static Logger logger = Logger.getLogger(Program.class);
    public static final int END_OF_PROGRAM = -1;
    private ArrayList<Byte> program = new ArrayList<>();
    private int pointer = 0;
    private String name = null;

    /**
     * <p> Creates a Program that stores data from a program file with the given name.</p>
     * @param filename the name of a program file.
     * @throws IOException if a program file with the given name is not found.
     */
    public Program(String filename) throws IOException
    {
        name = filename;
        try(Reader reader = new FileReader(filename))
        {
            int element = 0;
            while ((element = reader.read()) != -1)
            {
                program.add((byte) element);
            }
        }
        catch(IOException e)
        {
            logger.error("Can't read program file.");
            throw new IOException();
        }
    }

    /**
     * <p> Creates a Program that stores data from the default program file.</p>
     */
    public Program()
    {
        name = "hello.bf";
        try(Reader reader = new FileReader(name))
        {
            int element = 0;
            while ((element = reader.read()) != -1)
            {
                program.add((byte) element);
            }
        }
        catch(IOException e)
        {
            logger.error("It never happens.");
        }
    }

    /**
     * <p> Returns the ASCII code of the command symbol to which the program pointer points
     * or END_OF_PROGRAM if pointer points to the end of the program.</p>
     *
     * @return the ASCII code of the command symbol to which the program pointer points
     * or END_OF_PROGRAM if pointer points to the end of the program.
     */
    public int getCommand()
    {
        if(pointer >= 0 && pointer < program.size())
        {
            return program.get(pointer);
        }
        else
        {
            return END_OF_PROGRAM;
        }
    }

    /**
     * <p> Returns the name of the program which data is stored by this Program.</p>
     * @return the name of the program which data is stored by this Program.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p> Increases the program pointer of this Program.</p>
     */
    public void increasePtr()
    {
        ++pointer;
    }

    /**
     * <p> Increases the program pointer of this Program.</p>
     */
    public void decreasePtr()
    {
        --pointer;
    }
}
