package by.itstep.karnei.controller;

import by.itstep.karnei.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public String listOfCars(Model model) {

        model.addAttribute("carsList",carService.getAll());
        return "cars";
    }
}
