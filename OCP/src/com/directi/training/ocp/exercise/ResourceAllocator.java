package com.directi.training.ocp.exercise;

public class ResourceAllocator
{
    private static final int INVALID_RESOURCE_ID = -1;

    public int allocate(Resource resource)
    {
        try {
            return resource.allocate();
        } catch (Exception e) {
            System.out.println("ERROR: Attempted to allocate invalid resource");
            return INVALID_RESOURCE_ID;
        }
    }

    public void free(Resource resource)
    {
        try {
            resource.free();
        } catch (Exception e) {
            System.out.println("ERROR: attempted to free invalid resource");
        }
    }
}
