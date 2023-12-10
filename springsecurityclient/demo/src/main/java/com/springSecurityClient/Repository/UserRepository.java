package com.springSecurityClient.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springSecurityClient.Entity.User2;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User2,Long> {

}
