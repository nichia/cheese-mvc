package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.data.CategoryDao;
import org.launchcode.cheesemvc.models.data.CheeseDao;
import org.launchcode.cheesemvc.models.data.MenuDao;
import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.data.UserDao;
import org.launchcode.cheesemvc.models.data.UserBasicDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AbstractController {

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected UserBasicDao userBasicDao;

    @Autowired
    protected CheeseDao cheeseDao;

    @Autowired
    protected CategoryDao categoryDao;

    @Autowired

    protected MenuDao menuDao;
    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if (userId == null) return null;
        return userDao.findById(userId).get();
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }

}
