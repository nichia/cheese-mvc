package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.user.User;
import org.launchcode.cheesemvc.models.user.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    UserDao userDao;

    // Request path: /user
    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("title", "Users");
        model.addAttribute("users", userDao.findAll());
        return "user/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddUserForm(Model model) {
        model.addAttribute("title", "Add User");
        model.addAttribute(new User());
        return "user/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddUserForm(@ModelAttribute @Valid User user, Errors errors, Model model) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add User");
            return "user/add";
        }
        userDao.save(user);

        // Redirect to /user
        return "redirect:";
    }

    @RequestMapping(value="{userId}", method = RequestMethod.GET)
    public String displayUserForm(Model model, @PathVariable int userId) {
        model.addAttribute("user", userDao.findById(userId));
        model.addAttribute("title", "User");
        return "user/show";
    }
}
