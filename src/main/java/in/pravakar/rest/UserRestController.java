package in.pravakar.rest;

import java.util.HashMap;
import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.pravakar.binding.User;

@RestController
public class UserRestController {
	
	private Map<Integer, User> dataMap = new HashMap<>();
	
	@PostMapping("/user")
	public ResponseEntity<String> addUser(@RequestBody User user){
		System.out.println("User :: " + user);
		dataMap.put(user.getId(), user);
		return new ResponseEntity<String>("User Saved", HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public User getUser(@RequestParam("userid") Integer userId) {
		User user = dataMap.get(userId);
		return user;
		
	}
	
	@GetMapping("/user/{id}/data")
	public User getUserData(@PathVariable("id") Integer userId) {
		User user = dataMap.get(userId);
		return user;
		
	}
	
	/*@GetMapping("/user")
	public User getUserData(@RequestParam("userid") Integer userId,@RequestParam("username") String name) {
		User user = dataMap.get(userId);
		return user;
		
	}*/

}
