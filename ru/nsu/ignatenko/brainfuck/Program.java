package ru.nsu.ignatenko.brainfuck;
import java.io.FileReader;
import java.util.ArrayList;

public class Program
{
    private ArrayList<Byte> program = new ArrayList<>();
    private int pointer = 0;

    public Program(String filename) throws Exception
    {
        FileReader reader = new FileReader(filename);
        int element = 0;
        while((element = reader.read()) != -1)
        {
            program.add((byte)element);
        }
    }

    public int getCommand()
    {
        if(pointer > 0 && pointer < program.size())
        {
            return program.get(pointer);
        }
        else
        {
            return -1;
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
