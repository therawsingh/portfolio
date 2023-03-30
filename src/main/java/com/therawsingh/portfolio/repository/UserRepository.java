package com.therawsingh.portfolio.repository;

import com.therawsingh.portfolio.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByName(String name);

}
