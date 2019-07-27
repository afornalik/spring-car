package sdaspringcar.cardemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sdaspringcar.cardemo.servic.CarPartsService;

@RestController
@RequestMapping("/CarParts")
public class CarPartsController {

    @Autowired
    CarPartsService carPartsService;


    @RequestMapping(value = "/add",method = RequestMethod.GET,produces = "application/json")
    private ResponseEntity addCarPartsWithNameAndPrice(@RequestParam(name = "name") String name, @RequestParam(name="value") String price){
        try {
           return new ResponseEntity(carPartsService.createNewPart(name, price), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }
    }
}
