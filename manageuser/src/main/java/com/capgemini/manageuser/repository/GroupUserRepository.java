package com.capgemini.manageuser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.capgemini.manageuser.model.GroupUser;


public interface GroupUserRepository extends JpaRepository<GroupUser,Integer> {
	@Query(value = "select * from group_user_table u where u.user_id = ?1", nativeQuery = true)
	List<GroupUser> findGroupUserByUserId(Integer id);
}
