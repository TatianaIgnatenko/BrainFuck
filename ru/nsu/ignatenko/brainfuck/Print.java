package ru.nsu.ignatenko.brainfuck;

public class Print implements  Command
{
    public void perform(Memory memory, Program program)
    {
        System.out.println(memory.getValue());
    }
}