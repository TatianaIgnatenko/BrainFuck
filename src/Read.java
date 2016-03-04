package ru.nsu.ignatenko.brainfuck;

import java.io.IOException;
import java.util.Scanner;

public class Read implements  Command
{
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
            System.err.println("Can't read what you typed :(");
            System.exit(1);
        }
    }
}