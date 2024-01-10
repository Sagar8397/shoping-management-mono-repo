package org.sagar.repo;

import java.util.List;

import org.sagar.dto.UserData;
import org.sagar.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<Users, Long> {

	List<UserData> findByUsernameAndPassword(String useruame, String password);
}
