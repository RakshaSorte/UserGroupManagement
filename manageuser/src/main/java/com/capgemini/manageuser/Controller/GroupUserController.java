package com.capgemini.manageuser.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.manageuser.exception.ResourceNotFoundException;
import com.capgemini.manageuser.model.GroupUser;
import com.capgemini.manageuser.repository.GroupRepository;
import com.capgemini.manageuser.repository.GroupUserRepository;
import com.capgemini.manageuser.repository.UserRepository;

@RestController
@RequestMapping("/api/groupuser")
@CrossOrigin(origins="http:localhost:3000")
public class GroupUserController {
@Autowired
private GroupUserRepository groupUserRepository;

@Autowired
private GroupRepository groupRepository;

@Autowired
private UserRepository userRepository;	
@GetMapping("/")
public List<GroupUser> getAllGroupUser()
{
	return groupUserRepository.findAll();
}
@GetMapping("/{id}")
public ResponseEntity<GroupUser> getGroupUserById(@PathVariable int id) throws ResourceNotFoundException {
	GroupUser groupUser=groupUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("group not found"));
			
return  ResponseEntity.ok(groupUser);
}
//http://localhost:8089/api/groupuser/
@PostMapping("/") 
public GroupUser createGroupUser(@RequestBody GroupUser groupUser) { 
	return groupUserRepository.save(groupUser); 
	}
//update user rest api
@PutMapping("/{id}/{gid}")
public ResponseEntity<GroupUser> updateGroupUser(@PathVariable int id,@PathVariable int gid,@RequestBody GroupUser groupDetails) throws ResourceNotFoundException
{
	/*
	 * GroupUser group=groupUserRepository.findById(id).orElseThrow(() -> new
	 * ResourceNotFoundException("group not found")); Group
	 * groupid=groupRepository.findById(gid).orElseThrow(()->new
	 * ResourceNotFoundException("group id not found")); if(groupid!=null) {
	 * groupDetails }
	 */
	GroupUser group=groupUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("group not found"));
	group.setGuid(groupDetails.getGuid());
	group.setGroup(groupDetails.getGroup());
	group.setUser(groupDetails.getUser());

GroupUser updatedgroup=groupUserRepository.save(group);
return ResponseEntity.ok(updatedgroup);
}
//delete group rest api
	@DeleteMapping("/{id}")
	public ResponseEntity< Map<String,Boolean>> deleteGroupUser(@PathVariable int id) throws ResourceNotFoundException
	{
		GroupUser group=groupUserRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("group not found"));
		
		groupUserRepository.delete(group);
		Map<String,Boolean> response=new HashMap<>();
		response.put("deleted",Boolean.TRUE);
	return ResponseEntity.ok(response);
	}

}
