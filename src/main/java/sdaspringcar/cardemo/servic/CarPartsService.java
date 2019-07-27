package sdaspringcar.cardemo.servic;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sdaspringcar.cardemo.entity.CarParts;
import sdaspringcar.cardemo.exception.IncorrectPriceParseException;
import sdaspringcar.cardemo.repository.ICarPartsRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CarPartsService implements ICarPartsService {

    @Autowired
    ICarPartsRepository carPartsRepository;

    @Override
    public List<CarParts> showPartsThatCostMoreThan(BigDecimal bigDecimal) {
        return null;
    }

    @Override
    public CarParts createNewPart(String name, String price) {
        if(name!=null && price!=null){
            CarParts carPartsToAdd = new CarParts();
            carPartsToAdd.setName(name);
            carPartsToAdd.setPrice(tryParsePrice(price));
            carPartsRepository.save(carPartsToAdd);
            return carPartsToAdd;
        }
        return null;
    }

    private BigDecimal tryParsePrice(String price) throws IncorrectPriceParseException {
        try {
            return new BigDecimal(price);
        } catch ( Exception e) {
            e.printStackTrace();
            throw new IncorrectPriceParseException();
        }
        return null;
    }
}
