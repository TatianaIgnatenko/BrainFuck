package ru.nsu.ignatenko.brainfuck;

import java.util.HashMap;
import java.util.Properties;
import java.lang.Object;
import java.lang.Class;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ReflectiveOperationException;
import java.lang.ClassLoader;
import java.io.InputStream;

public class CommandFactory
{
    private HashMap<Byte, Class> classesOfComands = new HashMap<>();
    private Properties fullNamesOfClasses = new Properties();

    public CommandFactory(String filename)
    {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try(InputStream fin =  loader.getResourceAsStream(filename))
        {
            fullNamesOfClasses.load(fin);
        }
        catch(IOException e)
        {
            System.err.println("Oops, something wrong with config file :(");
            System.exit(1);
        }
    }

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
                System.err.println("Oops, can't create class for command " + command);
                System.exit(1);
                return null;
            }
        }
    }
}
