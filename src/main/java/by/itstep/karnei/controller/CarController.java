package by.itstep.karnei.controller;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@RequestMapping("cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public String listOfCars(Model model,
                             @RequestParam(required = false, defaultValue = "") Car editCar,
                             @RequestParam(required = false, defaultValue = "") Car removeCar,
                             @RequestParam(required = false, defaultValue = "") Car repareCar) {

        model.addAttribute("carsList", carService.getAll());

        /*        Edit exist car        */
        if (editCar != null) {
            model.addAttribute("oneCar", editCar);
        }

        /*         Remove car          */
        if (removeCar != null) {
            carService.remove(removeCar);
        }

        /*         Repare car          */

        if (repareCar != null) {
            carService.repareCar(repareCar);
        }
        return "cars";
    }

    @PostMapping
    public String addOrUpdateCar(@Valid Car car, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("carsList", carService.getAll());
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("oneCar", car);
            return "cars";
        } else {
            if (carService.saveCar(car)) {
                return "redirect:cars";
            } else {
                model.addAttribute("carsList", carService.getAll());
                model.addAttribute("savingReport", "Car with such vin is already exists!");
                model.addAttribute("oneCar", car);
                return "cars";
            }
        }
    }
}
