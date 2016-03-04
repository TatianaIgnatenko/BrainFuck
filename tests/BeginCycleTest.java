package ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.BeginCycle;
import ru.nsu.ignatenko.brainfuck.Interpreter;
import ru.nsu.ignatenko.brainfuck.IncreaseElement;
import ru.nsu.ignatenko.brainfuck.Program;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Exception;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class BeginCycleTest
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
    public void beginCycleTest()
    {
        Interpreter interpreter = new Interpreter("config.txt");
        interpreter.run(new Program("hello.brainf2"));
        assertEquals("Hello, World!", outContent.toString());

    }
}