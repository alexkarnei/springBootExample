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

    public boolean saveCar(Car car) {

        Car carFromDb = carRepo.findByVin(car.getVin());

        if (car.getId() == null) {
            if (carFromDb == null) {
                carRepo.save(car);
                return true;
            } else {
                return false;
            }
        } else {

            if (carFromDb == null || carFromDb != null && car.getId() == carFromDb.getId()) {
                carRepo.save(car);
                return true;
            } else {
                return false;
            }
        }

    }

    public Iterable<Car> getAll() {
        return carRepo.findAll();
    }

    public void remove(Car removeCar) {
        removeCar.setDeleted(true);
        carRepo.save(removeCar);
    }

    public void repareCar(Car repareCar) {
        repareCar.setDeleted(false);
        carRepo.save(repareCar);
    }
}
