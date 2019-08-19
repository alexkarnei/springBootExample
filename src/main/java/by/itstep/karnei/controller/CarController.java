package by.itstep.karnei.controller;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public String listOfCars(Model model) {
        model.addAttribute("carsList", carService.getAll());
        return "cars";
    }

    @PostMapping
    public String addOrUpdateCar(@Valid Car car, BindingResult bindingResult, Model model) {
        model.addAttribute("oneCar", car);
        carService.saveCar(car);
        return "redirect:cars";
    }
}
