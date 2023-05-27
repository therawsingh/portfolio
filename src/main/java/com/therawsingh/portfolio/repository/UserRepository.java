package com.therawsingh.portfolio.repository;

import com.therawsingh.portfolio.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    public User findByName(String name);

    public User findByEmail(String email);

}
