package sdaspringcar.cardemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sdaspringcar.cardemo.entity.Car;
import sdaspringcar.cardemo.servic.ICarService;

@RestController
@RequestMapping("/Car")
public class CarController {

   private final ICarService carService;

    @Autowired
    public CarController(ICarService carService) {
        this.carService = carService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        try {
            return new ResponseEntity<>(carService.createCar(car), HttpStatus.OK);
        }catch(Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getCar/{id}",produces = "application/json")
    private ResponseEntity<java.util.Optional<Car>> getCar(@PathVariable Long id){
        try {
            return new ResponseEntity<>(carService.getSingleCar(id),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}

/*  {
          "idCarParts": 3,
          "price": 4500.00,
          "name": "Window",
          "car": null
          }*/


