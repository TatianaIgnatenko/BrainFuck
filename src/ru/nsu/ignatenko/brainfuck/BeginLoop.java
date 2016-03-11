package ru.nsu.ignatenko.brainfuck;

/**
 * <p> A BeginLoop checks the value of the element to which the memory pointer points.
 * If the value is not zero then the program pointer moves to the first instruction in the loop.
 * Otherwise the program pointer moves to the next instruction is not in the loop. </p>
 *
 * @author Tatiana Ignatenko
 */
public class BeginLoop implements  Command
{
    private String name = "[";

    /**
     * <p> Returns the name of the command.</p>
     * @return the name of the command.
     */
    public String getName()
    {
        return name;
    }

/**
 * <p>Checks the value of the element to which memory pointer points.
 * If the value is not zero then program pointer moves to the next instruction is in the loop.
 * Otherwise program pointer moves to the next instruction is not in the loop. </p>
 *
 * @param memory the Memory BeginLoop manipulates.
 * @param program the Program BeginLoop manipulates.
 */
    public void perform(Memory memory, Program program)
    {
        if(memory.getValue() == 0)
        {
            int count_brackets = 1;
            while(count_brackets != 0)
            {
                program.increasePtr();
                if(program.getSymbol() == ']')
                {
                    --count_brackets;
                }
                else if(program.getSymbol() == '[')
                {
                    ++count_brackets;
                }
            }
        }
    }
}