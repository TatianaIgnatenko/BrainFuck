package tests.ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.Read;
import ru.nsu.ignatenko.brainfuck.IncreaseElement;
import ru.nsu.ignatenko.brainfuck.IncreasePtr;
import ru.nsu.ignatenko.brainfuck.Program;
import ru.nsu.ignatenko.brainfuck.Memory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class ReadTest
{
    @Test
    public void readTest() throws IOException
    {
        String data = "Hello!";
        System.setIn(new ByteArrayInputStream(data.getBytes()));

        IncreasePtr command1 = new IncreasePtr();
        Read command2 = new Read();
        Memory memory = new Memory();
        Program program = new Program("resource/prog.txt");

        command2.perform(memory, program);
        assertEquals('H', memory.getValue());
        command1.perform(memory, program);
        command2.perform(memory, program);
        assertEquals('e', memory.getValue());
        command1.perform(memory, program);
        command2.perform(memory, program);
        assertEquals('l', memory.getValue());
        command1.perform(memory, program);
        command2.perform(memory, program);
        assertEquals('l', memory.getValue());
        command1.perform(memory, program);
        command2.perform(memory, program);
        assertEquals('o', memory.getValue());
        command1.perform(memory, program);
        command2.perform(memory, program);
        assertEquals('!', memory.getValue());
    }
}