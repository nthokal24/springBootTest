package in.test.controller;

import in.test.model.Car;
import in.test.service.CarImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {

    @Autowired
    CarImpl carImpl;

    @PostMapping("/save")
    public ResponseEntity<Car> saveCars(@RequestBody Car car){
        return  new ResponseEntity<Car>(carImpl.saveCar(car), HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Car> getCarByIds(@PathVariable Integer id){
        return new ResponseEntity<Car>(carImpl.getCarById(id), HttpStatus.OK);
    }


    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars(){
        return new ResponseEntity<List<Car>>(carImpl.getAllCar(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteCarById(@PathVariable Integer id){
        return new ResponseEntity<String>(carImpl.deleteCarById(id), HttpStatus.OK);
    }

}
