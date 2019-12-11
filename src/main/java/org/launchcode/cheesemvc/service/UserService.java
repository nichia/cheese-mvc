package org.launchcode.cheesemvc.service;

import org.launchcode.cheesemvc.models.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public void saveUser(User user);
    public boolean isUserAlreadyPresent(User user);

}
