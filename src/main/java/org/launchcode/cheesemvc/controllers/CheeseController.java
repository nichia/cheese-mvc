package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.cheese.Cheese;
import org.launchcode.cheesemvc.models.cheese.CheeseType;
import org.launchcode.cheesemvc.models.cheese.data.CheeseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    @Autowired
    private CheeseDao cheeseDao;

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {
        //model.addAttribute("cheeses", cheeses);
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        // model.addAttribute("cheese", new Cheese());
        model.addAttribute(new Cheese());
        model.addAttribute("cheeseTypes", CheeseType.values());
        return "cheese/add";
    }

    // @RequestMapping(value = "add", method = RequestMethod.POST)
    // public String processAddCheeseForm(HttpServletRequest request) {
    // String cheeseName = request.getParameter("cheeseName");
    // public String processAddCheeseForm(@RequestParam String cheeseName) {
    //    cheeses.add(cheeseName);

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute @Valid Cheese newCheese, Errors errors, Model model) {

        // public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        // cheeses.put(cheeseName, cheeseDescription);
        // new Cheese(cheeseName, cheeseDescription);

        if (errors.hasErrors()) {
            model.addAttribute("title", "Add Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/add";
        }

        cheeseDao.save(newCheese);

        // Redirect to /cheese
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model){
        // model.addAttribute("cheeses", cheeses);
        model.addAttribute("cheeses", cheeseDao.findAll());
        model.addAttribute("title", "Remove Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    //Dropdown menu - select element
    //public String processRemoveCheeseForm(@RequestParam String cheese) {
        //cheeses.remove(cheese);
    public String processRemoveCheeseForm(@RequestParam int[] cheeseIds) {
        for (int cheeseId : cheeseIds){
            // cheeses.remove(aCheese);
            cheeseDao.deleteById(cheeseId);
        }

        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value="edit/{id}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int id) {
        // model.addAttribute("cheese", CheeseData.getById(cheeseId));
        model.addAttribute("cheese", cheeseDao.findById(id));
        model.addAttribute("title", "Edit Cheese");
        model.addAttribute("cheeseTypes", CheeseType.values());

        return "cheese/edit";
    }

    @RequestMapping(value="edit/{id}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute @Valid Cheese theCheese, Errors errors, Model model, @PathVariable int id) {

        if (errors.hasErrors()) {
            model.addAttribute("title", "Edit Cheese");
            model.addAttribute("cheeseTypes", CheeseType.values());
            return "cheese/edit";
        }

        // Update an instance of cheese
        Cheese cheeseInDB = cheeseDao.findById(id).get();
        cheeseInDB.setName(theCheese.getName());
        cheeseInDB.setDescription(theCheese.getDescription());
        cheeseInDB.setType(theCheese.getType());
        cheeseInDB.setRating(theCheese.getRating());

        cheeseDao.save(cheeseInDB);

        return "redirect:/cheese";
    }

}
