package ru.nsu.ignatenko.brainfuck;

import java.util.HashMap;
import java.util.Properties;
import java.lang.Object;
import java.lang.Class;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.lang.InstantiationException;
import java.lang.IllegalAccessException;
import java.lang.ClassNotFoundException;
import java.lang.ClassLoader;
import java.io.InputStream;
import java.lang.SecurityException;
import java.lang.IllegalStateException;

public class CommandFactory
{
    private HashMap<Byte, Class> classesOfComands = new HashMap<>();
    private Properties fullNamesOfClasses = new Properties();

    public CommandFactory(String filename) throws IOException, IllegalArgumentException, SecurityException, IllegalStateException
    {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        try(InputStream fin =  loader.getResourceAsStream(filename))
        {
            fullNamesOfClasses.load(fin);
        }
    }

    public Command create(int command) throws InstantiationException, IllegalAccessException, ClassNotFoundException
    {
//        System.out.println("start create");
        if(command == -1)
        {
            return null;
        }
       else
        {
            Class c;
            if ((c = classesOfComands.get((byte)command)) != null)
            {
                return (Command) (c.newInstance());
            }
            else
            {
                byte[] command_ = new byte[1];
                command_[0] = (byte)command;
//                System.out.println("start else");
                String fullNameOfClass = fullNamesOfClasses.getProperty(new String(command_));
                if(fullNameOfClass != null)
                {
//                    System.out.println("get property is done");
                    c = Class.forName(fullNameOfClass);
//                    System.out.println("for name is done");
                    classesOfComands.put((byte) command, c);
//                    System.out.println("put is done");
                    return (Command) (c.newInstance());
                }
                else
                {
                    return new DoNothing();
                }
            }
        }
    }
}
