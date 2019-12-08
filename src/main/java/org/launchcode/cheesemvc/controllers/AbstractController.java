package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.data.CategoryDao;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.launchcode.cheesemvc.models.data.MenuDao;
import org.launchcode.cheesemvc.models.data.UserBaseDao;
import org.springframework.beans.factory.annotation.Autowired;

public class AbstractController {

    @Autowired
    protected UserBaseDao userBaseDao;

    @Autowired
    protected CheeseDao cheeseDao;

    @Autowired
    protected CategoryDao categoryDao;

    @Autowired
    protected MenuDao menuDao;

}
