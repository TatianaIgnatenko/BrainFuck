package ru.nsu.ignatenko.brainfuck;

/**
 * <p> A DecreasePtr decreases the pointer of memory it manipulates.</p>
 *
 * @author Tatiana Ignatenko
 */
public class DecreasePtr implements  Command
{
    private String name = "<";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p>Decreases the pointer of memory it manipulates.</p>
     *
     * @param memory the Memory DecreasePtr manipulates.
     * @param program the Program DecreasePtr ignores.
     */
    public void perform(Memory memory, Program program)
    {
        memory.decreasePtr();
    }
}