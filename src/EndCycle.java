package ru.nsu.ignatenko.brainfuck;

public class EndCycle implements  Command
{
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