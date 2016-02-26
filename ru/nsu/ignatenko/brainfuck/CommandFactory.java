package ru.nsu.ignatenko.brainfuck;

import java.util.HashMap;
import java.util.Properties;
import java.lang.Object;
import java.lang.Class;
import java.io.FileInputStream;

public class CommandFactory
{
    private HashMap<Byte, Class> classesOfComands = new HashMap<>();
    private Properties fullNamesOfClasses = new Properties();

    public CommandFactory(String filename) throws Exception
    {
        FileInputStream fin = new FileInputStream(filename);
        fullNamesOfClasses.load(fin);
    }

    public Command create(int command) throws Exception
    {
        if(command == -1)
        {
            return null;
        }
       else
        {
            byte[] command_ = new byte[1];
            command_[0] = (byte)command;
            Class c;
            if ((c = classesOfComands.get((byte)command)) != null)
            {
                return (Command) c.cast(c.newInstance());
            }
            else
            {
                String fullNameOfClass = fullNamesOfClasses.getProperty(new String(command_));
                c = Class.forName(fullNameOfClass);
                classesOfComands.put((byte)command, c);
                return (Command) c.cast(c.newInstance());
            }
        }
    }
}
