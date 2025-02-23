package com.directi.training.ocp.exercise;

public class SpaceSlotResource extends Resource {
    @Override
    public int allocate() {
        int resourceId = findFree();
        markBusy(resourceId);
        return resourceId;
    }

    @Override
    public void free() {
        markFree(id);
    }

    @Override
    public void markBusy(int resourceId) {
        // Implementation for marking space slot as busy
    }

    @Override
    public void markFree(int resourceId) {
        // Implementation for marking space slot as free
    }

    @Override
    public int findFree() {
        // Implementation for finding free space slot
        return 0;
    }
} 