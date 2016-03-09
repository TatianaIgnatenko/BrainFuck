package tests.ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.Program;

import java.io.IOException;

import static org.junit.Assert.*;
import org.junit.Test;

public class ProgramTest
{
    @Test
    public void CtorTest() throws IOException
    {
        Program program = new Program("prog.txt");
        assertEquals('+', program.getCommand());
     }

    @Test(expected = IOException.class)
    public void CtorExceptionTest() throws IOException
    {
        Program program = new Program("doesn't_exist.txt");
    }

    @Test
    public void getCommandTest() throws IOException
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
    public void increasePtrTest() throws IOException
    {
        Program program = new Program("prog.txt");
        assertEquals('+', program.getCommand());
        program.increasePtr();
        assertEquals('-', program.getCommand());
        program.increasePtr();
        assertEquals(-1, program.getCommand());
    }

    @Test
    public void decreasePtrTest() throws IOException
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