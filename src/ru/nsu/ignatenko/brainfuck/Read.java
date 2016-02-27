package ru.nsu.ignatenko.brainfuck;

public class Read implements  Command
{
    public void perform(Memory memory, Program program) throws Exception
    {
        int element;
        element = System.in.read();
        memory.setValue((byte)element);
    }
}