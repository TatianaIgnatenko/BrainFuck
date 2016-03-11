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
        Program program = new Program("resource/prog.txt");
        assertEquals('+', program.getSymbol());
     }

    @Test(expected = IOException.class)
    public void CtorExceptionTest() throws IOException
    {
        Program program = new Program("doesn't_exist.txt");
    }

    @Test
    public void getSymbolTest() throws IOException
    {
        Program program = new Program("resource/prog.txt");
        assertEquals('+', program.getSymbol());
        program.decreasePtr();
        assertEquals(-1, program.getSymbol());
        program.increasePtr();
        program.increasePtr();
        assertEquals('-', program.getSymbol());
    }

    @Test
    public void increasePtrTest() throws IOException
    {
        Program program = new Program("resource/prog.txt");
        assertEquals('+', program.getSymbol());
        program.increasePtr();
        assertEquals('-', program.getSymbol());
        program.increasePtr();
        assertEquals(-1, program.getSymbol());
    }

    @Test
    public void decreasePtrTest() throws IOException
    {
        Program program = new Program("resource/prog.txt");
        assertEquals('+', program.getSymbol());
        program.increasePtr();
        assertEquals('-', program.getSymbol());
        program.decreasePtr();
        assertEquals('+', program.getSymbol());
        program.decreasePtr();
        assertEquals(-1, program.getSymbol());
    }
}