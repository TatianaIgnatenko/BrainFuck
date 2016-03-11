package ru.nsu.ignatenko.brainfuck;

/**
 * <p> A DecreaseElement decreases the value of the element to which memory pointer points. </p>
 *
 * @author Tatiana Ignatenko
 */
public class DecreaseElement implements  Command
{
    private String name = "-";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p> Decreases the value of the element to which memory pointer points. </p>
     *
     * @param memory the Memory DecreaseElement manipulates.
     * @param program the Program DecreaseElement ignores.
     */
    public void perform(Memory memory, Program program)
    {
        memory.decreaseElement();
    }


}
