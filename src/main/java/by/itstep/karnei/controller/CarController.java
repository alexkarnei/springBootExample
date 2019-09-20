package by.itstep.karnei.controller;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@Controller
@Slf4j
@RequestMapping("cars")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping
    public String listOfCars(Model model,
                             @RequestParam(required = false, defaultValue = "") Car editCar,
                             @RequestParam(required = false, defaultValue = "") Car removeCar,
                             @RequestParam(required = false, defaultValue = "") Car repareCar,
                             @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        Page<Car> page = carService.getAll(pageable);

        page.forEach(pgs -> log.debug("{}", pgs.toString()));

        model.addAttribute("page", page);
        model.addAttribute("url", "/cars");

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
    public String addOrUpdateCar(@Valid Car car, BindingResult bindingResult, Model model,
                                 @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Car> page = carService.getAll(pageable);

        model.addAttribute("page", page);
        model.addAttribute("url", "/cars");

        if (bindingResult.hasErrors()) {
            model.addAttribute("page", page);
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("oneCar", car);
            return "cars";
        } else {
            if (carService.saveCar(car)) {
                return "redirect:cars";
            } else {
                model.addAttribute("page", page);
                model.addAttribute("savingReport", "Car with such vin is already exists!");
                model.addAttribute("oneCar", car);
                return "cars";
            }
        }
    }
}
