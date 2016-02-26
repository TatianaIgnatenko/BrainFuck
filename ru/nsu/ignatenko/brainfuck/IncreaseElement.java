package ru.nsu.ignatenko.brainfuck;

public class IncreaseElement implements  Command
{
    public void perform(Memory memory, Program program)
    {
        memory.increaseElement();
    }
}