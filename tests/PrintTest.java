package ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.*;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.*;
import java.io.PrintStream;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;


public class PrintTest
{
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams()
    {
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void cleanUpStreams()
    {
        System.setOut(null);
    }

    @Test
    public void printTest()
    {
        Command command1 = new IncreaseElement();
        Command command2 = new IncreasePtr();
        Command command3 = new Print();
        Memory memory = new Memory();
        Program program = new Program("prog.txt");

        for (int i = 0; i < 'H'; ++i)
        {
            command1.perform(memory, program);
        }
        command3.perform(memory, program);
        command2.perform(memory, program);
        for (int i = 0; i < 'E'; ++i)
        {
            command1.perform(memory, program);
        }
        command3.perform(memory, program);
        command2.perform(memory, program);
        for (int i = 0; i < 'L'; ++i)
        {
            command1.perform(memory, program);
        }
        command3.perform(memory, program);
        command2.perform(memory, program);
        for (int i = 0; i < 'L'; ++i)
        {
            command1.perform(memory, program);
        }
        command3.perform(memory, program);
        command2.perform(memory, program);
        for (int i = 0; i < 'O'; ++i)
        {
            command1.perform(memory, program);
        }
        command3.perform(memory, program);
        command2.perform(memory, program);
        for (int i = 0; i < '!'; ++i)
        {
            command1.perform(memory, program);
        }
        command3.perform(memory, program);

        assertEquals("HELLO!", outContent.toString());
    }
}