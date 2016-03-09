package tests.ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.DecreaseElement;
import ru.nsu.ignatenko.brainfuck.Program;
import ru.nsu.ignatenko.brainfuck.Memory;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class DecreaseElementTest
{
    @Test
    public void decreaseElementPerformTest() throws IOException
    {
        DecreaseElement command = new DecreaseElement();
        Memory memory = new Memory();
        Program program = new Program("prog.txt");

        assertEquals(0, memory.getValue());
        command.perform(memory, program);
        assertEquals(-1, memory.getValue());
    }
}