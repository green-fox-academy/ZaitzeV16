package com.greenfox.rename.sb_template.repositories;

import com.greenfox.rename.sb_template.models.entities.ChildOfUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChildOfUserRepository extends CrudRepository<ChildOfUser, Long> {

}
