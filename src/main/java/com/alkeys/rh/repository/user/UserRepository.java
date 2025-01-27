package com.alkeys.rh.repository.user;

import com.alkeys.rh.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
  User findByUserEmailAndPassword(String email, String password);
}