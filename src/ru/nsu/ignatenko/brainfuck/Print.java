package ru.nsu.ignatenko.brainfuck;

/**
 * <p> A Print prints an element to which memory pointer points.</p>
 *
 * @author Tatiana Ignatenko
 */
public class Print implements  Command
{
    private String name = ".";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p> Prints an element to which memory pointer points.</p>
     *
     * @param memory the Memory Print manipulates.
     * @param program the Program Print ignores.
     */
    public void perform(Memory memory, Program program)
    {
        byte[] str = new byte[1];
        str[0] = memory.getValue();
        System.out.print(new String(str));
    }
}