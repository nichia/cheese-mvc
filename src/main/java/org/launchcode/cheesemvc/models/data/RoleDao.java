package org.launchcode.cheesemvc.models.data;

import org.launchcode.cheesemvc.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RoleDao extends CrudRepository<Role, Integer>  {

    public Role findByRole(String role);
}
