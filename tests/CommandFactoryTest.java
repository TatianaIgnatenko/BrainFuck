package ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.CommandFactory;
import ru.nsu.ignatenko.brainfuck.Command;

import java.lang.Object;
import java.lang.Class;

import static org.junit.Assert.*;
import org.junit.Test;

public class CommandFactoryTest
{
    @Test
    public void CtorTest()
    {
        CommandFactory factory = new CommandFactory("config.txt");
        Command command = factory.create('+');
        assertEquals("ru.nsu.ignatenko.brainfuck.IncreaseElement", command.getClass().getName());
    }

        @Test
        public void CreateTest()
    {
            CommandFactory factory = new CommandFactory("config.txt");
            Command command = factory.create('+');
            assertEquals("ru.nsu.ignatenko.brainfuck.IncreaseElement", command.getClass().getName());
        }
}