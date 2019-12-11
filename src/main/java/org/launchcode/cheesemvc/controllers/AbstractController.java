package org.launchcode.cheesemvc.controllers;

import org.launchcode.cheesemvc.models.User;
import org.launchcode.cheesemvc.models.data.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AbstractController {

    @Autowired
    protected UserBaseDao userBaseDao;

    @Autowired
    protected UserDao userDao;

    @Autowired
    protected CheeseDao cheeseDao;

    @Autowired
    protected CategoryDao categoryDao;

    @Autowired
    protected MenuDao menuDao;

    public static final String userSessionKey = "user_id";

    @ModelAttribute("user")
    protected User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findById(userId).get();
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    @ModelAttribute("userId")
    public Integer getUserIdFromSession(HttpServletRequest request) {
        return (Integer) request.getSession().getAttribute(userSessionKey);
    }
}
