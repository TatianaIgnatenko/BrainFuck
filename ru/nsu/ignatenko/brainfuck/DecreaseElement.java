package ru.nsu.ignatenko.brainfuck;

public class DecreaseElement implements  Command
{
    public void perform(Memory memory, Program program)
    {
        memory.decreaseElement();
    }
}
