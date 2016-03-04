package ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.Program;
import static org.junit.Assert.*;
import org.junit.Test;

public class ProgramTest {
    @Test
    public void CtorTest()
    {
        Program program = new Program("prog.txt");
        assertEquals('+', program.getCommand());
     }

    @Test
    public void getCommandTest()
    {
        Program program = new Program("prog.txt");
        assertEquals('+', program.getCommand());
        program.decreasePtr();
        assertEquals(-1, program.getCommand());
        program.increasePtr();
        program.increasePtr();
        assertEquals('-', program.getCommand());
    }

    @Test
    public void increasePtrTest()
    {
        Program program = new Program("prog.txt");
        assertEquals('+', program.getCommand());
        program.increasePtr();
        assertEquals('-', program.getCommand());
        program.increasePtr();
        assertEquals(-1, program.getCommand());
    }

    @Test
    public void decreasePtrTest()
    {
        Program program = new Program("prog.txt");
        assertEquals('+', program.getCommand());
        program.increasePtr();
        assertEquals('-', program.getCommand());
        program.decreasePtr();
        assertEquals('+', program.getCommand());
        program.decreasePtr();
        assertEquals(-1, program.getCommand());
    }
}