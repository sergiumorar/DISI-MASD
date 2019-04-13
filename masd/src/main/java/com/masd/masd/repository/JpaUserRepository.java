package com.masd.masd.repository;

import com.masd.masd.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaUserRepository extends JpaRepository<User, Integer> {
    User findByUsernameAndPassword(String username, String password);
}
