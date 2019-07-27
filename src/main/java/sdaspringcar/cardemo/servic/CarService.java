package sdaspringcar.cardemo.servic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdaspringcar.cardemo.entity.Car;
import sdaspringcar.cardemo.repository.ICarRepository;

import java.util.Optional;


@Service
public class CarService implements ICarService {


    final
    ICarRepository carRepository;

    @Autowired
    public CarService(ICarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    @Transactional
    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Optional<Car> getSingleCar(Long id) {
        return carRepository.findById(id);
    }
}
