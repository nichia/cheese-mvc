package org.launchcode.cheesemvc.models.cheese.data;

import org.launchcode.cheesemvc.models.cheese.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MenuDao extends CrudRepository<Menu, Integer> {
}