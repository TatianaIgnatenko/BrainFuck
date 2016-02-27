package ru.nsu.ignatenko.brainfuck;

public interface Command
{
    public void perform(Memory memory, Program program) throws Exception;
}














