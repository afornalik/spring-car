package sdaspringcar.cardemo.servic;

import sdaspringcar.cardemo.entity.CarParts;

import java.math.BigDecimal;
import java.util.List;

public interface ICarPartsService {

    List<CarParts> showPartsThatCostMoreThan(BigDecimal bigDecimal);

    CarParts createNewPart(String name,String price);
}
