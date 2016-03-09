package ru.nsu.ignatenko.brainfuck;

/**
 * <p> A DoNothing does nothing. </p>
 *
 * @author Tatiana Ignatenko
 */
public class DoNothing implements Command
{
    private String name = "Do nothing";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p> Does nothing.</p>
     */
    public void perform(Memory memory, Program program){}
}
