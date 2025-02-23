package com.directi.training.lsp.exercise;

public class Pool
{
    public void run()
    {
        Duck donaldDuck = new Duck();
        ElectronicDuck electricDuck = new ElectronicDuck();
        
        electricDuck.turnOn();
        
        quackAndSwim(donaldDuck);
        quackAndSwim(electricDuck);
        
        demonstratePoweredDuck(electricDuck);
    }

    private void quackAndSwim(IDuck duck)
    {
        duck.quack();
        duck.swim();
    }
    
    private void demonstratePoweredDuck(ElectronicDuck duck)
    {
        System.out.println("\nDemonstrating powered duck:");
        duck.turnOff();
        duck.quack();
        duck.turnOn();
        duck.quack();
    }

    public static void main(String[] args)
    {
        Pool pool = new Pool();
        pool.run();
    }
}
