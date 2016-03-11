package tests.ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.DecreasePtr;
import ru.nsu.ignatenko.brainfuck.DecreaseElement;
import ru.nsu.ignatenko.brainfuck.Program;
import ru.nsu.ignatenko.brainfuck.Memory;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class DecreasePtrTest
{
    @Test
    public void decreasePtrPerformTest() throws IOException
    {
        DecreaseElement command1 = new DecreaseElement();
        DecreasePtr command2 = new DecreasePtr();
        Memory memory = new Memory();
        Program program = new Program("resource/prog.txt");

        command1.perform(memory, program);
        assertEquals(-1, memory.getValue());
        command2.perform(memory, program);
        assertEquals(0, memory.getValue());
    }
}