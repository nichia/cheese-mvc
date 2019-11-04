package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.Cheese;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;


@Controller
@RequestMapping("cheese")
public class CheeseController {

    // static ArrayList<String> cheeses = new ArrayList<>();
//   static HashMap<String, String> cheeses = new HashMap<>();

    // Request path: /cheese
    @RequestMapping(value = "")
    public String index(Model model) {
        //model.addAttribute("cheeses", cheeses);
        model.addAttribute("cheeses", Cheese.getCheeses());
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
    public String processAddCheeseForm(@RequestParam String cheeseName, @RequestParam String cheeseDescription) {
        // cheeses.put(cheeseName, cheeseDescription);
        new Cheese(cheeseName, cheeseDescription);

        // Redirect to /cheese
        return "redirect:";
    }


    @RequestMapping(value = "remove", method = RequestMethod.GET)
    public String displayRemoveCheeseForm(Model model){
        // model.addAttribute("cheeses", cheeses);
        model.addAttribute("cheeses", Cheese.getCheeses());
        model.addAttribute("title", "Remove Cheese");

        return "cheese/remove";
    }

    @RequestMapping(value = "remove", method = RequestMethod.POST)
    //Dropdown menu - select element
    //public String processRemoveCheeseForm(@RequestParam String cheese) {
            //cheeses.remove(cheese);
    public String processRemoveCheeseForm(@RequestParam ArrayList<String> cheese) {
        for (String aCheese : cheese){
            Cheese.removeCheese(aCheese);
//             cheeses.remove(aCheese);
        }

        // Redirect to /cheese
        return "redirect:";
    }
}
