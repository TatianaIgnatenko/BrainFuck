package ru.nsu.ignatenko.brainfuck;

public class Interpreter
{
    private CommandFactory factory = null;
    private Memory memory = new Memory();

    public Interpreter(String arg) throws Exception
    {
        factory = new CommandFactory(arg);
    }
    private void run(Program program) throws Exception
    {
        Command command = getCommand(program);
        while(command != null)
        {
            command.perform(memory, program);
            command = getCommand(program);
        }
    }
    private Command getCommand(Program program) throws Exception
    {
        return factory.create(program.getCommand());
    }
    public static void main(String[] args)
    {
        try
        {
            Interpreter interpreter = new Interpreter(args[0]);
            interpreter.run(new Program(args[1]));
        }
        catch(Exception e)
        {

        }
    }
}