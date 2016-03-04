package ru.nsu.ignatenko.brainfuck.tests;

import ru.nsu.ignatenko.brainfuck.Memory;
import static org.junit.Assert.*;
import org.junit.Test;

public class MemoryTest {
    @Test
    public void getValueTest()
    {
        Memory memory = new Memory();
        assertEquals(0, memory.getValue());
        memory.setValue((byte)5);
        assertEquals(5, memory.getValue());
    }

    @Test
    public void setValueTest()
    {
        Memory memory = new Memory();
        assertEquals(0, memory.getValue());
        memory.setValue((byte)5);
        assertEquals(5, memory.getValue());
    }

    @Test
    public void increaseElementTest()
    {
        Memory memory = new Memory();
        assertEquals(0, memory.getValue());
        memory.increaseElement();
        assertEquals(1, memory.getValue());
    }

    @Test
    public void decreaseElementTest()
    {
        Memory memory = new Memory();
        assertEquals(0, memory.getValue());
        memory.decreaseElement();
        assertEquals(-1, memory.getValue());
    }

    @Test
    public void increasePtrTest()
    {
        Memory memory = new Memory();
        memory.increaseElement();
        assertEquals(1, memory.getValue());
        memory.increasePtr();
        assertEquals(0, memory.getValue());
    }

    @Test
    public void decreasePtrTest()
    {
        Memory memory = new Memory();
        memory.increaseElement();
        assertEquals(1, memory.getValue());
        memory.decreasePtr();
        assertEquals(0, memory.getValue());
    }
}