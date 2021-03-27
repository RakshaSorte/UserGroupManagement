package com.capgemini.manageuser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.capgemini.manageuser.model.User;


@Repository
public interface LoginRepository extends JpaRepository<User,Integer> {
@Query("select rs from User rs where rs.username=?1")
Optional<User>findByName(String username);
}
