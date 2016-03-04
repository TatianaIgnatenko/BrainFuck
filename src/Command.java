package ru.nsu.ignatenko.brainfuck;

import java.io.IOException;

public interface Command
{
    public void perform(Memory memory, Program program) throws Exception;
}














