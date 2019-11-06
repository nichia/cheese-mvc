package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.user.User;
import org.launchcode.cheesemvc.models.user.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("user")
public class UserController {
    // Request path: /user
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title", "Users");
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User newUser, Errors errors, String verify_password, Model model) {
        if(errors.hasErrors() || !(newUser.getPassword().equals(verify_password))) {
            if (errors.hasFieldErrors("password")) {
                newUser.setPassword("");
            } else if (!(newUser.getPassword().equals(verify_password))) {
                model.addAttribute("password_error", "Passwords do not match");
            }
            model.addAttribute("title", "Add User");
            return "user/add";
        }

        UserData.add(newUser);

        // Redirect to /user
        return "redirect:";
    }

    @RequestMapping(value="{userId}", method = RequestMethod.GET)
    public String displayUserForm(Model model, @PathVariable int userId) {
        model.addAttribute("user", UserData.getById(userId));
        model.addAttribute("title", "User");
        return "user/show";
    }
}
