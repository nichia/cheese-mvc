package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.cheese.data.CategoryDao;
import org.launchcode.cheesemvc.models.cheese.data.CheeseDao;
import org.launchcode.cheesemvc.models.cheese.data.MenuDao;
import org.launchcode.cheesemvc.models.user.data.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractController {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected CheeseDao cheeseDao;

    @Autowired
    protected CategoryDao categoryDao;

    @Autowired
    protected MenuDao menuDao;

}
