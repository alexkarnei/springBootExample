package by.itstep.karnei.service;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.repositiry.CarRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CarService {
    @Autowired
    CarRepo carRepo;

    public void saveCar(Car car) {
        if (car.getCreatedDate() != null) {
            car.setCreatedDate(LocalDateTime.now());
            car.setUpdatedDate(LocalDateTime.now());
            carRepo.save(car);
        }
    }


    public Iterable<Car> getAll() {
        return carRepo.findAll();
    }
}
