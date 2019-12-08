package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.UserBase;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("userBase")
public class UserController  extends AbstractController {

    // Request path: /user
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Users");
        model.addAttribute("users", userBaseDao.findAll());
        return "userBase/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add UserBase");
        model.addAttribute(new UserBase());
        return "userBase/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid UserBase userBase, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add UserBase");
            return "userBase/add";
        }
        userBaseDao.save(userBase);

        // Redirect to /userBase
        return "redirect:";
    }

    @RequestMapping(value="{userId}", method = RequestMethod.GET)
    public String displayUserForm(Model model, @PathVariable int userId) {
        model.addAttribute("user", userBaseDao.findById(userId).get());
        model.addAttribute("title", "UserBase");
        return "userBase/show";
    }
}
