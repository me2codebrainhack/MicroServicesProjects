package com.ecom.userms.repo;

import com.ecom.userms.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    List<User> findByFirstName(String firstName);

    List<User> findByLastName(String lastName);

    User findById(int id);

}
