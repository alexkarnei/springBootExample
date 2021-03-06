package by.itstep.karnei.controller;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.domain.UsingHistory;
import by.itstep.karnei.service.UsingHistoryService;
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
public class UsingHistoryController {

    @Autowired
    UsingHistoryService usingHistoryService;

    @GetMapping("history/{car}")
    public String allCarHistory(
            Model model,
            @ModelAttribute UsingHistory usingHistory,
            @PathVariable Car car,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<UsingHistory> histories = usingHistoryService.getAll(pageable);
        usingHistory.setCar(car);
        model.addAttribute("usingHistory", usingHistory);
        model.addAttribute("page", histories);
        model.addAttribute("url", "/history");
        return "history";
    }

    @GetMapping("history")
    public String allHistory(
            Model model,
            @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable
    ) {
        Page<UsingHistory> histories = usingHistoryService.getAll(pageable);
        model.addAttribute("page", histories);
        model.addAttribute("url", "/history");
        return "history";
    }

    @PostMapping("history/{id}")
    public String addOrUpdateHistory(@ModelAttribute UsingHistory usingHistory,
                                     Model model,
                                     @PathVariable Long id,
                                     @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        return getString(usingHistory, model, pageable);
    }

    @PostMapping("history")
    public String addHistory(@ModelAttribute UsingHistory usingHistory,
                                     Model model,
                                     @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {

        return getString(usingHistory, model, pageable);
    }


    private String getString(@ModelAttribute UsingHistory usingHistory, Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<UsingHistory> page = usingHistoryService.getAll(pageable);

        model.addAttribute("page", page);
        model.addAttribute("url", "/history");

        if (usingHistoryService.saveUsingHistory(usingHistory)) {
            return "redirect:/history";
        } else {
            model.addAttribute("page", page);
            model.addAttribute("savingReport", "Fatal Error!!!");
            model.addAttribute("usingHistory", usingHistory);
            return "history";
        }
    }
}
