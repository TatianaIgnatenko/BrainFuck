package ru.nsu.ignatenko.brainfuck;

public class IncreasePtr implements  Command
{
    public void perform(Memory memory, Program program)
    {
        memory.increasePtr();
    }
}