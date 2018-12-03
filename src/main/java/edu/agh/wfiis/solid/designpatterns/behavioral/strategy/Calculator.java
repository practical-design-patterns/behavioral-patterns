package edu.agh.wfiis.solid.designpatterns.behavioral.strategy;

public class Calculator {
    public static void main(String[] args)
    {
        int val1 = Integer.valueOf(args[0]);
        int val2 = Integer.valueOf(args[2]);
        String operator = args[1];

        if("+".equals(operator)){
            System.out.print(val1 + val2);
        }else if("-".equals(operator)){
            System.out.print(val1 - val2);
        }
    }
}