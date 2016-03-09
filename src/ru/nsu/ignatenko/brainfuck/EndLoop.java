package ru.nsu.ignatenko.brainfuck;

/**
 * <p> An EndLoop checks the value of the element to which the memory pointer points.
 * If the value is not null then the program pointer decreases to the first instruction in the loop.
 * Otherwise the program pointer increases to the next instruction. </p>
 *
 * @author Tatiana Ignatenko
 */
public class EndLoop implements  Command
{
    private String name = "]";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

    /**
     * <p>Checks the value of the element to which the memory pointer points.
     * If the value is not null then the program pointer decreases to the first instruction in the loop.
     * Otherwise the program pointer increases to the next instruction. </p>
     *
     * @param memory the Memory EndLoop manipulates.
     * @param program the Program EndLoop manipulates.
     */
    public void perform(Memory memory, Program program)
    {
        if(memory.getValue() != 0)
        {
            int count_brackets = 1;
            while(count_brackets != 0)
            {
                program.decreasePtr();
                if(program.getCommand() == '[')
                {
                    --count_brackets;
                }
                else if(program.getCommand() == ']')
                {
                    ++count_brackets;
                }
            }
        }
    }
}