package tests.ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.EndLoop;
import ru.nsu.ignatenko.brainfuck.Interpreter;
import ru.nsu.ignatenko.brainfuck.Program;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import java.lang.Exception;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class EndLoopTest
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
    public void EndLoopTest() throws IOException
    {
        Interpreter interpreter = new Interpreter("config.txt");
        interpreter.run(new Program("hello.brainf2"));
        assertEquals("Hello, World!", outContent.toString());

    }
}