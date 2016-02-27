package ru.nsu.ignatenko.brainfuck;

public class Memory
{
    private int size = 30000;
    private byte[] mem = new byte[size];
    private int pointer = 0;

    public byte getValue()
    {
        return mem[pointer];
    }
    public void setValue(byte val)
    {
        mem[pointer] = val;
    }
    public void increaseElement()
    {
        ++mem[pointer];
    }
    public void decreaseElement()
    {
        --mem[pointer];
    }
    public void increasePtr()
    {
        if(pointer == size - 1)
        {
            pointer = 0;
        }
        else
        {
            ++pointer;
        }
    }
    public void decreasePtr()
    {
        if(pointer == 0)
        {
            pointer = size - 1;
        }
        else
        {
            --pointer;
        }
    }
}