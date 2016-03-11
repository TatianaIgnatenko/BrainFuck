package ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.IncreaseElement;
import ru.nsu.ignatenko.brainfuck.Program;
import ru.nsu.ignatenko.brainfuck.Memory;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class IncreaseElementTest
{
    @Test
    public void increaseElementPerformTest() throws IOException
    {
        IncreaseElement command = new IncreaseElement();
        Memory memory = new Memory();
        Program program = new Program("resource/prog.txt");

        assertEquals(0, memory.getValue());
        command.perform(memory, program);
        assertEquals(1, memory.getValue());
    }
}