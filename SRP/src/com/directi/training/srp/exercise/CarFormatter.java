package com.directi.training.srp.exercise;

import java.util.List;

public class CarFormatter {
    public String getCarNames(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getBrand());
            sb.append(" ");
            sb.append(car.getModel());
            sb.append(", ");
        }
        return sb.length() > 2 ? sb.substring(0, sb.length() - 2) : "";
    }
} 