package ru.nsu.ignatenko.brainfuck;

/**
 * <p> A Command is responsible for performing commands.</p>
 *
 * @author Tatiana Ignatenko
 */
public interface Command
{
    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName();

    /**
     * <p> Performs the command.</p>
     *
     * @param memory the Memory Command manipulates.
     * @param program the Program Command manipulates.
     */
    public void perform(Memory memory, Program program);



}














