package ru.nsu.ignatenko.brainfuck;

import java.io.Reader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Program
{
    public static final int END_OF_PROGRAM = -1;
    private ArrayList<Byte> program = new ArrayList<>();
    private int pointer = 0;

    public Program(String filename)
    {
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
            System.err.println("Can't read program file :(");
            System.exit(1);
        }
    }

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

    public void increasePtr()
    {
        ++pointer;
    }

    public void decreasePtr()
    {
        --pointer;
    }
}
