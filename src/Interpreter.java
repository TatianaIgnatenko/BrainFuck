package ru.nsu.ignatenko.brainfuck;

import java.io.IOException;

public class Interpreter
{
    private CommandFactory factory = null;
    private Memory memory = new Memory();

    public Interpreter(String arg) throws Exception
    {
//        System.out.println("Start Ctor");
        factory = new CommandFactory(arg);
//        System.out.println("End Ctor");
    }
    public void run(Program program) throws Exception
    {
//        System.out.println("Start Run");
        Command command = getCommand(program);
//        System.out.println("Get command is done");
        while(command != null)
        {
//            System.out.println("while");
            command.perform(memory, program);
//            System.out.println("Perform is done");
            program.increasePtr();
//            System.out.println("incr ptr is done");
            command = getCommand(program);
//            System.out.println("get command is done");
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
        catch(IOException e)
        {
            System.out.println("Oh no, IOexception ;(");
        }
        catch(Exception e)
        {
            System.out.println("Oh no, exception ;(");
        }
    }
}