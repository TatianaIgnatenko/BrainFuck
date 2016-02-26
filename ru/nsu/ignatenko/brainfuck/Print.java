package ru.nsu.ignatenko.brainfuck;

public class Print implements  Command
{
    public void perform(Memory memory, Program program)
    {
        byte[] str = new byte[1];
        str[0] = memory.getValue();
        System.out.print(new String(str));
    }
}