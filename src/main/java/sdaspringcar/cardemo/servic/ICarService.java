package sdaspringcar.cardemo.servic;

import sdaspringcar.cardemo.entity.Car;

import java.util.Optional;


public interface ICarService {

    Car createCar(Car car);

    Optional<Car> getSingleCar(Long id);

}
