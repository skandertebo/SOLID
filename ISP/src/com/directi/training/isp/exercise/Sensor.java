package com.directi.training.isp.exercise;

import java.util.Random;

public class Sensor
{
    public void register(ProximitySensor sensor)
    {
        while (true) {
            if (isPersonClose()) {
                sensor.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose()
    {
        return new Random().nextBoolean();
    }
}
