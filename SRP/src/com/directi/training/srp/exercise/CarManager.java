package com.directi.training.srp.exercise;

public class CarManager
{
    private final CarRepository _carRepository;
    private final CarFormatter _carFormatter;
    private final CarRanker _carRanker;

    public CarManager()
    {
        _carRepository = new CarRepository();
        _carFormatter = new CarFormatter();
        _carRanker = new CarRanker();
    }

    public Car getFromDb(final String carId)
    {
        return _carRepository.findById(carId);
    }

    public String getCarsNames()
    {
        return _carFormatter.getCarNames(_carRepository.getAllCars());
    }

    public Car getBestCar()
    {
        return _carRanker.getBestCar(_carRepository.getAllCars());
    }
}
