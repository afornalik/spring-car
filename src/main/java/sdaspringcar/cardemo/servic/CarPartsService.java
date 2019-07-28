package sdaspringcar.cardemo.servic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sdaspringcar.cardemo.entity.Car;
import sdaspringcar.cardemo.entity.CarParts;

import sdaspringcar.cardemo.exception.IncorrectPriceParseException;
import sdaspringcar.cardemo.repository.ICarPartsRepository;
import sdaspringcar.cardemo.repository.ICarRepository;
import sdaspringcar.cardemo.servic.utils.ComparisonEnum;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarPartsService implements ICarPartsService {


    private final ICarPartsRepository carPartsRepository;
    private final ICarRepository carRepository;

    @Autowired
    public CarPartsService(ICarPartsRepository carPartsRepository, ICarRepository carRepository) {
        this.carPartsRepository = carPartsRepository;
        this.carRepository = carRepository;
    }


    @Override
    public List<CarParts> showPartsThatCost(BigDecimal price, ComparisonEnum comparisonEnum) {
        switch (comparisonEnum) {
            case LOWER: {
                return carPartsRepository.findByPriceIsLessThan(price);
            }
            case GREATER: {
                return carPartsRepository.findByPriceGreaterThan(price);
            }
            case EQUAL: {
                return carPartsRepository.findByPriceEquals(price);
            }
        }
        return null;
    }

    @Override
    public CarParts createNewPart(String name, String price) {
        if (name != null && price != null) {
            CarParts carPartsToAdd = new CarParts();
            carPartsToAdd.setName(name);
            try {
                carPartsToAdd.setPrice(tryParsePrice(price));
            } catch (IncorrectPriceParseException e) {
                return null;
            }
            carPartsRepository.save(carPartsToAdd);
            return carPartsToAdd;
        }
        return null;
    }

    @Override
    public CarParts createNewPart(CarParts carParts) {
        return carPartsRepository.save(carParts);
    }

    @Override
    public Boolean assignCarPartsToCar(Long partId,Long carId) {

        Optional<Car> optionalCar = carRepository.findById(carId);
        Optional<CarParts> optionalCarParts = carPartsRepository.findById(partId);
        if(optionalCar.isPresent() && optionalCarParts.isPresent()){
            optionalCarParts.get().setCar(optionalCar.get());
            carPartsRepository.save(optionalCarParts.get());
            return true;
        }
        return false;
    }



    private BigDecimal tryParsePrice(String price) throws IncorrectPriceParseException {
        try {
            return new BigDecimal(price);
        } catch (NumberFormatException e) {
            throw new IncorrectPriceParseException("Incorrect price.");
        }
    }
}
