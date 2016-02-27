package ru.nsu.ignatenko.brainfuck;

public class EndCycle implements  Command
{
    public void perform(Memory memory, Program program)
    {
        if(memory.getValue() != 0)
        {
            int count_bracets = 1;
            while(count_bracets != 0)
            {
                program.decreasePtr();
                if(program.getCommand() == '[')
                {
                    --count_bracets;
                }
                else if(program.getCommand() == ']')
                {
                    ++count_bracets;
                }
            }
        }
    }
}