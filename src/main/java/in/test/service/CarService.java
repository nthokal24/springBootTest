package in.test.service;

import in.test.model.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    Car saveCar(Car car);

    Car getCarById(Integer id);

    List<Car> getAllCar();

    String deleteCarById(Integer id);
}
