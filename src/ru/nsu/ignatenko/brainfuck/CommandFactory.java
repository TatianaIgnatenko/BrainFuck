package ru.nsu.ignatenko.brainfuck;

import java.util.HashMap;
import java.util.Properties;
import java.lang.Object;
import java.lang.Class;
import java.io.FileInputStream;
import java.lang.ClassLoader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.AbstractMap;

import java.lang.ReflectiveOperationException;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * <p>A CommandFactory creates instances of classes that implements the interface Command.</p>
 * @author Tatiana Ignatenko
 */
public class CommandFactory
{
    final static Logger logger = Logger.getLogger(CommandFactory.class);
    private AbstractMap<Byte, Class> classesOfComands = new HashMap<>();
    private Properties fullNamesOfClasses = new Properties();

    /**
     * <p> Creates a CommandFactory that uses a config file with the given name.</p>
     * @param filename the name of a config file.
     * @throws IOException if a config file with the given name is not found.
     */
    public CommandFactory(String filename) throws IOException
    {
        try( InputStream fin = new FileInputStream(filename))
        {
            fullNamesOfClasses.load(fin);
        }
        catch(IOException e)
        {
            logger.error("Can't find config file.");
            throw new IOException();
        }
    }

    /**
     * <p> Creates an CommandFactory that uses the default config file.</p>
     */
    public CommandFactory()
    {
        try( InputStream fin = new FileInputStream("config.txt"))
        {
            fullNamesOfClasses.load(fin);
        }
        catch(IOException e)
        {
            logger.error("It never happens.");
        }
    }

    /**
     * <p> Creates an instanse of the class that connects with the ASCII code
     * of the passed command symbol in the config file.
     * If the class is not found or class is abstract then null is returned.
     * If the ASCII code of the passed command symbol is not found in the config file
     * then an instanse of the class DoNothing is returned.</p>
     *
     * @param command the ASCII code of the command symbol.
     * @return an instanse of the class that connects with the ASCII code
     * of the passed command symbol in the config file,
     * or null if the class is not found or class is abstract,
     * or an instanse of class DoNothing if the ASCII code of the passed command symbol
     * is not found in the config file .
     */
    public Command create(int command)
    {
        if(command == Program.END_OF_PROGRAM)
        {
            return null;
        }
        else
        {
            try
            {
                Class c;
                if ((c = classesOfComands.get((byte) command)) != null)
                {
                        return (Command) (c.newInstance());
                }
                else
                {
                    byte[] command_ = new byte[1];
                    command_[0] = (byte) command;
                    String fullNameOfClass = fullNamesOfClasses.getProperty(new String(command_));
                    if (fullNameOfClass != null)
                    {
                        c = Class.forName(fullNameOfClass);
                        classesOfComands.put((byte) command, c);
                        return (Command) (c.newInstance());
                    }
                    else
                    {
                        return new DoNothing();
                    }
                }
            }
            catch (ReflectiveOperationException e)
            {
                byte[] command_ = new byte[1];
                String errCommand =  new String(command_);
                logger.error("Can't create class for command - " + errCommand);
                return null;
            }
        }
    }
}
