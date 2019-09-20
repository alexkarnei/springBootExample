package by.itstep.karnei.controller;

import by.itstep.karnei.domain.Owner;
import by.itstep.karnei.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.Map;

@Controller
public class OwnerController {

    @Autowired
    OwnerService ownerService;

    @GetMapping
    public String ownerList(Model model) {
        model.addAttribute("owners", ownerService.ownerList());
        return "owners";
    }

    @PostMapping
    public String ownerSave(
            @Valid Owner owner,
            Model model,
            BindingResult bindingResult,
            @RequestParam("birth") LocalDate birthday
    ) {
        Iterable<Owner> owners = ownerService.ownerList();
        if (bindingResult != null) {
            owner.setBirthday(birthday);
        }
        if (bindingResult.hasErrors()) {
            model.addAttribute("birth", birthday);
            model.addAttribute("owners", owners);
            Map<String, String> errorsMap = ControllerUtils.getErrors(bindingResult);
            model.mergeAttributes(errorsMap);
            model.addAttribute("owner", owner);
            return "owners";
        } else {
            return "redirect:owners";
        }
    }
}
