package com.fbn.auth.fb.repository;

import com.fbn.auth.fb.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Gives to JPA the ability to communicate with database
 */
@Repository
public interface GroupRepository extends JpaRepository<Group, Long>{
    // Todo add the custom search query
}
