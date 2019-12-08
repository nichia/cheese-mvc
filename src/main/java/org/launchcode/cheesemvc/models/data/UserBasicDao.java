package org.launchcode.cheesemvc.models.data;

import org.launchcode.cheesemvc.models.UserBasic;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserBasicDao extends CrudRepository<UserBasic, Integer> {
}
