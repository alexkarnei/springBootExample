package by.itstep.karnei.controller;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.repository.CarRepo;
import by.itstep.karnei.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarRestController {

    @Autowired
    CarService carService;

    @Autowired
    CarRepo carRepo;

    @GetMapping
    public Page<Car> page(@PageableDefault(sort = {"mark"}, direction = Sort.Direction.ASC) Pageable pageable) {

        return carService.getAll(pageable);
    }

    @GetMapping
    public List<Car> list(){
        return carRepo.findAll();
    }

}
