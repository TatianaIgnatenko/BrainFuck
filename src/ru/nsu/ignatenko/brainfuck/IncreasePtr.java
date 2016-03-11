package ru.nsu.ignatenko.brainfuck;

/**
 * <p> An IncreasePtr increases the memory pointer of the given Memory.</p>
 *
 * @author Tatiana Ignatenko
 */
public class IncreasePtr implements  Command
{
    private String name = ">";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p>Increases the memory pointer of the given Memory.</p>
     *
     * @param memory the Memory IncreasePtr manipulates.
     * @param program the Program IncreasePtr ignores.
     */
    public void perform(Memory memory, Program program)
    {
        memory.increasePtr();
    }
}