package ru.nsu.ignatenko.brainfuck;

/**
 *
 * <p>A Memory manipulates (controls, manages) a block of memory.</p>
 *
 * @author Tatiana Ignatenko
 */
public class Memory
{
    private int size = 30000;
    private byte[] mem = new byte[size];
    private int pointer = 0;

    /**
     * <p> Returns the value of the element to which memory pointer points.</p>
     * @return the value of the element to which memory pointer points.
     */
    public byte getValue()
    {
        return mem[pointer];
    }

    /**
     * <p> Sets the value to the element to which memory pointer points.</p>
     * @param val the value which sets to the element to which memory pointer points.
     */
    public void setValue(byte val)
    {
        mem[pointer] = val;
    }

    /**
     * <p> Increases the value of the element to which memory pointer points.</p>
     */
    public void increaseElement()
    {
        ++mem[pointer];
    }

    /**
     * <p> Decreases the value of the element to which memory pointer points.</p>
     */
    public void decreaseElement()
    {
        --mem[pointer];
    }

    /**
     * <p> Increases the memory pointer.</p>
     */
    public void increasePtr()
    {
        if(pointer == size - 1)
        {
            pointer = 0;
        }
        else
        {
            ++pointer;
        }
    }

    /**
     * <p> Decreases the memory pointer.</p>
     */
    public void decreasePtr()
    {
        if(pointer == 0)
        {
            pointer = size - 1;
        }
        else
        {
            --pointer;
        }
    }
}