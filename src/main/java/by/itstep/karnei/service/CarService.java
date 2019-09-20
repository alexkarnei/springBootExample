package by.itstep.karnei.service;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.repository.CarRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
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

    public Page<Car> getAll(Pageable pageable) {

        return carRepo.findAll(pageable);
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
