package by.itstep.karnei.repositiry;

import by.itstep.karnei.domain.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CarRepo extends CrudRepository<Car, Long> {
}
