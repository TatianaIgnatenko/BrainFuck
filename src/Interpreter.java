package ru.nsu.ignatenko.brainfuck;

public class Interpreter
{
    private CommandFactory factory = null;
    private Memory memory = new Memory();

    public Interpreter(String arg)
    {
        factory = new CommandFactory(arg);
    }
    public void run(Program program)
    {
        Command command = getCommand(program);
        while(command != null)
        {
            command.perform(memory, program);
            program.increasePtr();
            command = getCommand(program);
        }
    }
    private Command getCommand(Program program)
    {
        return factory.create(program.getCommand());
    }
    public static void main(String[] args)
    {
        Interpreter interpreter = new Interpreter(args[0]);
        interpreter.run(new Program(args[1]));
    }
}