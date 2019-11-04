package org.launchcode.cheesemvc.controllers;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.launchcode.cheesemvc.models.Cheese;
import org.launchcode.cheesemvc.models.CheeseData;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cheese")
public class CheeseController {

    // static ArrayList<String> cheeses = new ArrayList<>();
    // static HashMap<String, String> cheeses = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {
        //model.addAttribute("cheeses", cheeses);
        model.addAttribute("cheeses", CheeseData.getAll());
        model.addAttribute("title", "My Cheeses");
        return "cheese/index";
    }

    @RequestMapping(value = "add", method = RequestMethod.GET)
    public String displayAddCheeseForm(Model model) {
        model.addAttribute("title", "Add Cheese");
        return "cheese/add";
    }

    // @RequestMapping(value = "add", method = RequestMethod.POST)
    // public String processAddCheeseForm(HttpServletRequest request) {
    // String cheeseName = request.getParameter("cheeseName");
    // public String processAddCheeseForm(@RequestParam String cheeseName) {
    //    cheeses.add(cheeseName);

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String processAddCheeseForm(@ModelAttribute Cheese newCheese) {

        // public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        // cheeses.put(cheeseName, cheeseDescription);
        // new Cheese(cheeseName, cheeseDescription);

        CheeseData.add(newCheese);

        // Redirect to /cheese
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model){
        // model.addAttribute("cheeses", cheeses);
        model.addAttribute("cheeses", CheeseData.getAll());
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
            CheeseData.remove(cheeseId);
        }

        // Redirect to /cheese
        return "redirect:";
    }

    @RequestMapping(value="edit/{cheeseId}", method = RequestMethod.GET)
    public String displayEditForm(Model model, @PathVariable int cheeseId) {
        model.addAttribute("cheese", CheeseData.getById(cheeseId));
        model.addAttribute("title", "Edit Cheese");

        return "cheese/edit";
    }

    @RequestMapping(value="edit/{cheeseId}", method = RequestMethod.POST)
    public String processEditForm(@ModelAttribute Cheese newCheese) {

        CheeseData.update(newCheese);

        return "redirect:/cheese";
    }

}
