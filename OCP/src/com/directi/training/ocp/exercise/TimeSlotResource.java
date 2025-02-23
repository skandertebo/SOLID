package com.directi.training.ocp.exercise;

public class TimeSlotResource extends Resource {
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
        // Implementation for marking time slot as busy
    }

    @Override
    public void markFree(int resourceId) {
        // Implementation for marking time slot as free
    }

    @Override
    public int findFree() {
        // Implementation for finding free time slot
        return 0;
    }
} 