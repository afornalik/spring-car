package sdaspringcar.cardemo.servic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


@Service
public class CarService implements ICarService {


    @Autowired
    ICarService carService;


}
