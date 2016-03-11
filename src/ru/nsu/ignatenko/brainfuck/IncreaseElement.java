package ru.nsu.ignatenko.brainfuck;

/**
 * <p> An IncreaseElement increases the value of the element to which memory pointer points. </p>
 *
 * @author Tatiana Ignatenko
 */
public class IncreaseElement implements  Command
{
    private String name = "+";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p> Increases the value of the element to which memory pointer points. </p>
     *
     * @param memory the Memory IncreaseElement manipulates.
     * @param program the Program IncreaseElement ignores.
     */
    public void perform(Memory memory, Program program)
    {
        memory.increaseElement();
    }
}