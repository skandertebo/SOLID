package com.directi.training.lsp.exercise;

public class ElectronicDuck implements IDuck, IPoweredDevice
{
    private boolean _on = false;

    @Override
    public void quack()
    {
        if (_on) {
            System.out.println("Electronic duck quack...");
        }
    }

    @Override
    public void swim()
    {
        if (_on) {
            System.out.println("Electronic duck swim");
        }
    }

    @Override
    public void turnOn()
    {
        _on = true;
    }

    @Override
    public void turnOff()
    {
        _on = false;
    }

    @Override
    public boolean isOn()
    {
        return _on;
    }
}
