package by.itstep.karnei.controller;

import by.itstep.karnei.domain.Car;
import by.itstep.karnei.domain.Owner;
import by.itstep.karnei.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@Controller
@RequestMapping("owners")
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping
    public String ownerList(Model model, @PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable) {
        Page<Owner> page = ownerService.getAll(pageable);
        model.addAttribute("page", page);
        model.addAttribute("url", "/owners");
//        model.addAttribute("owners", ownerService.ownerList());
        return "owners";
    }

    @PostMapping
    public String ownerSave(
            @Valid Owner owner,
            Model model,
            BindingResult bindingResult,
            @RequestParam("birth") String birthday
    ) {
        Iterable<Owner> owners = ownerService.ownerList();
        if (!birthday.isEmpty()) {
            owner.setBirthday(LocalDate.parse(birthday));
        }
        if (bindingResult.hasErrors() || birthday.isEmpty()) {
            if (birthday.isEmpty()) {
                model.addAttribute("birthdayError", "Please fill the correct date");
            } else {
                model.addAttribute("birthdayError", null);
            }
            model.addAttribute("birth", owner.getBirthday());
            model.addAttribute("owners", owners);
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("owner", owner);
            return "owners";
        } else {
            ownerService.saveOwner(owner);
            return "redirect:owners";
        }
    }
}
