package tests.ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.IncreasePtr;
import ru.nsu.ignatenko.brainfuck.IncreaseElement;
import ru.nsu.ignatenko.brainfuck.Program;
import ru.nsu.ignatenko.brainfuck.Memory;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class IncreasePtrTest
{
    @Test
    public void increasePtrPerformTest() throws IOException
    {
        IncreaseElement command1 = new IncreaseElement();
        IncreasePtr command2 = new IncreasePtr();
        Memory memory = new Memory();
        Program program = new Program("resource/prog.txt");

        command1.perform(memory, program);
        assertEquals(1, memory.getValue());
        command2.perform(memory, program);
        assertEquals(0, memory.getValue());
    }
}