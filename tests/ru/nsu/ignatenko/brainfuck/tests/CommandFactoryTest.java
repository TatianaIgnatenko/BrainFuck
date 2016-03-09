package tests.ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.CommandFactory;
import ru.nsu.ignatenko.brainfuck.Command;
import java.lang.Object;
import java.lang.Class;

import java.lang.ReflectiveOperationException;
import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class CommandFactoryTest
{
    @Test
    public void CtorTest() throws IOException
    {
        CommandFactory factory = new CommandFactory("config.txt");
        Command command = factory.create('+');
        assertEquals("ru.nsu.ignatenko.brainfuck.IncreaseElement", command.getClass().getName());
    }

    @Test(expected = IOException.class)
    public void CtorExceptionTest() throws IOException
    {
        CommandFactory factory = new CommandFactory("doesn't_exist.txt");
    }

    @Test
    public void CreateTest() throws IOException
    {
            CommandFactory factory = new CommandFactory("config.txt");
            Command command = factory.create('+');
            assertEquals("ru.nsu.ignatenko.brainfuck.IncreaseElement", command.getClass().getName());

            factory = new CommandFactory("bad_config.txt");
            command = factory.create('+');
    }
}