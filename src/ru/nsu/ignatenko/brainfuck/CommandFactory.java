package ru.nsu.ignatenko.brainfuck;

import java.util.HashMap;
import java.util.Properties;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.AbstractMap;

import java.lang.ReflectiveOperationException;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * <p>A CommandFactory creates instances of classes that implement the interface Command.</p>
 *
 * @author Tatiana Ignatenko
 */
public class CommandFactory
{
    final static Logger logger = Logger.getLogger(CommandFactory.class);
    private AbstractMap<Byte, Class> classesOfComands = new HashMap<>();
    private Properties fullNamesOfClasses = new Properties();

    /**
     * <p> Creates a CommandFactory that uses a config file with the given name.</p>
     * <p>A config file contains associations between command names and classes
     * that implement them.</p>
     *
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
        try( InputStream fin = new FileInputStream("resource/config.txt"))
        {
            fullNamesOfClasses.load(fin);
        }
        catch(IOException e)
        {
            logger.fatal("That mustn't ever happen.");
            throw new RuntimeException();
        }
    }

    /**
     * <p> Creates an instanse of the class that is associated with the ASCII code
     * of the given command symbol.
     * If the class is not found or class is abstract then null is returned.
     * If the association to the ASCII code of the passed command symbol is not found
     * then an instanse of the class DoNothing is returned.</p>
     *
     * @param command the ASCII code of the command symbol.
     * @return <ul>
     * <li>an instanse of class DoNothing -  If the association to
     * the ASCII code of the passed command symbol is not found</li>
     * <li>null -  if the class is not found or class is abstract</li>
     * <li>an instanse of the class associated with the ASCII code
     * of the given command symbol - otherwise</li>
     * </ul>
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
