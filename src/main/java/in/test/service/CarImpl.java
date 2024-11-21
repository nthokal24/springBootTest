package in.test.service;

import in.test.model.Car;
import in.test.repo.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarImpl implements CarService{

    @Autowired
    CarRepo carRepo;

    @Override
    public Car saveCar(Car car) {
        return carRepo.save(car);
    }

    @Override
    public Car getCarById(Integer id) {
        return carRepo.findById(id).orElseThrow(
                ()-> new RuntimeException("Car Not found" + id)
        );
    }

    @Override
    public List<Car> getAllCar() {
        return carRepo.findAll();
    }

    @Override
    public String deleteCarById(Integer id) {
        if(carRepo.existsById(id)){
            carRepo.deleteById(id);
            return "Deleted";
        }
        else {
            return "Car Not Found";
        }
    }
}
