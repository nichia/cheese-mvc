package org.launchcode.cheesemvc.models.user.data;

import org.launchcode.cheesemvc.models.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {
}
