package sdaspringcar.cardemo.servic;

import sdaspringcar.cardemo.entity.Car;
import sdaspringcar.cardemo.entity.CarParts;
import sdaspringcar.cardemo.servic.utils.ComparisonEnum;

import java.math.BigDecimal;
import java.util.List;

public interface ICarPartsService {

    List<CarParts> showPartsThatCost(BigDecimal price, ComparisonEnum comparisonEnum);

    CarParts createNewPart(String name,String price);

    CarParts createNewPart(CarParts carParts);

    Boolean assignCarPartsToCar(Long partId, Long carId);
}
