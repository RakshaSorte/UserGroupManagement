package com.capgemini.manageuser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.manageuser.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}