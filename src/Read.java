package ru.nsu.ignatenko.brainfuck;

import java.io.IOException;
import java.util.Scanner;

public class Read implements  Command
{
    public void perform(Memory memory, Program program) throws Exception
    {
        int element;
        element = System.in.read();
        memory.setValue((byte)element);
       // element = System.in.read();

//        Scanner scanner = new Scanner(System.in);
//        int element = scanner.nextByte();
//        memory.setValue((byte)element);
    }
}