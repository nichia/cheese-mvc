package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Category;
import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.Menu;
import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("cheese")
public class CheeseController extends AbstractController {

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute(new Cheese());
        model.addAttribute("title", "Add Cheese");
        model.addAttribute("categories", categoryDao.findAll());
        return "cheese/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese cheese,
                                       Errors errors, @RequestParam int categoryId, Model model,
                                       HttpServletRequest request) {
        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("categories", categoryDao.findAll());
            return "cheese/add";
        }

        User owner = getUserFromSession(request.getSession());
        cheese.setOwner(owner);

        Category category = categoryDao.findById(categoryId).get();
        cheese.setCategory(category);
        cheeseDao.save(cheese);

        // Redirect to /cheese
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model, HttpServletRequest request){
        User user = getUserFromSession(request.getSession());

        model.addAttribute("cheeses", cheeseDao.findByOwner(user));
        model.addAttribute("title", "Remove Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {
        for (int cheeseId : cheeseIds){
            cheeseDao.deleteById(cheeseId);
        }

        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value="edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId, HttpServletRequest request) {
        model.addAttribute("cheese", cheeseDao.findById(cheeseId).orElse(null));
        model.addAttribute("title", "Edit Cheese");
        model.addAttribute("categories", categoryDao.findAll());

        return "cheese/edit";
    }

    @RequestMapping(value="edit/{cheeseUid}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese cheese, Errors errors, Model model, @RequestParam int uid, @RequestParam Category category) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Cheese");
            model.addAttribute("categories", categoryDao.findAll());
            return "cheese/edit";
        }

        // Update an instance of cheese
        Cheese theCheese = cheeseDao.findById(uid).get();
        theCheese.setName(cheese.getName());
        theCheese.setDescription(cheese.getDescription());
        theCheese.setRating(cheese.getRating());
        Category cate = categoryDao.findById(category.getUid()).get();
        theCheese.setCategory(cate);

        cheeseDao.save(theCheese);

        return "redirect:/cheese";
    }

    @RequestMapping(value = "category", method = RequestMethod.GET)
    public String category(Model model, @RequestParam int uid) {
        Category cate = categoryDao.findById(uid).get();
        List<Cheese> cheeses = cate.getCheeses();
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Cheeses in Category: " + cate.getName());
        return "cheese/index";
    }

    @RequestMapping(value = "menu", method = RequestMethod.GET)
    public String menu(Model model, @RequestParam int uid) {
        Menu menuItem = menuDao.findById(uid).get();
        List<Cheese> cheeses = menuItem.getCheeses();
        model.addAttribute("cheeses", cheeses);
        model.addAttribute("title", "Cheeses in Menu: " + menuItem.getName());
        return "cheese/index";
    }

}
