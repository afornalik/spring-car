package sdaspringcar.cardemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sdaspringcar.cardemo.entity.Car;
import sdaspringcar.cardemo.entity.CarParts;
import sdaspringcar.cardemo.servic.CarPartsService;
import sdaspringcar.cardemo.servic.utils.ComparisonEnum;

import java.math.BigDecimal;

@RestController
@RequestMapping("/CarParts")
public class CarPartsController {

    private final CarPartsService carPartsService;

    public CarPartsController(CarPartsService carPartsService) {
        this.carPartsService = carPartsService;
    }


    @RequestMapping(value = "/add",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity addCarPartsWithNameAndPrice(@RequestParam(name = "name") String name, @RequestParam(name="value") String price){
        try {
           return new ResponseEntity(carPartsService.createNewPart(name, price), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }
    }

    @RequestMapping(value = "add",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public ResponseEntity addCarPartsWith(@RequestBody CarParts carParts) {
        try {
            return new ResponseEntity(carPartsService.createNewPart(carParts),HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity((HttpStatus.BAD_REQUEST));
        }
    }


    @RequestMapping(value="/findParts",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity findCarPartsWithPrice(@RequestParam (value = "price")BigDecimal price,@RequestParam (value ="c") ComparisonEnum comparisonEnum){
        try {
            return new ResponseEntity(carPartsService.showPartsThatCost(price,comparisonEnum),HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value="/assignParts",method = RequestMethod.GET,produces = "application/json")
    public ResponseEntity assignPartsToCar(@RequestParam(name = "part") Long partId, @RequestParam(name = "car") long carId){
        try {
            return new ResponseEntity(carPartsService.assignCarPartsToCar(partId,carId),HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
