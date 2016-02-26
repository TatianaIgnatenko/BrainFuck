package ru.nsu.ignatenko.brainfuck;

public class DecreasePtr implements  Command
{
    public void perform(Memory memory, Program program)
    {
        memory.decreasePtr();
    }
}