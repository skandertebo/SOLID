package com.directi.training.ocp.exercise;

public abstract class Resource {
    protected int id;
    
    public abstract int allocate();
    public abstract void free();
    public abstract void markBusy(int resourceId);
    public abstract void markFree(int resourceId);
    public abstract int findFree();
} 