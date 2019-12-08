package org.launchcode.cheesemvc.models.data;

import org.launchcode.cheesemvc.models.UserBase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserBaseDao extends CrudRepository<UserBase, Integer> {
}
