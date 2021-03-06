package com.springboot.learning.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.springboot.learning.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {

	private static final AtomicLong idCounter = new AtomicLong(); 
	
	private static List<User> users;
	
	static {
		users = populateUsers();
	}
	
	@Override
	public List<User> getAllUsers() {
		
		return users;
	}

	@Override
	public User getUserDetails(long id) {
		for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
	}
	
	@Override
	public boolean isUserPresent(User user) {
		for(User euser : users){
            if(euser.getFirstName().equals(user.getFirstName())){
                return true;
            }
        }
		return false;
	}
	
	@Override
	public void saveUser(User user) {
		user.setId(idCounter.incrementAndGet());
		users.add(user);
	}
	
	@Override
	public void updateUser(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }
	
	@Override
	public void deleteUser(User user) {
		users.remove(user);
	}
	
	private static List<User> populateUsers(){
        List<User> users = new ArrayList<User>();
        users.add(new User(idCounter.incrementAndGet(),"Sam", "Log", 30, "3102 Kings Court", 70000));
        users.add(new User(idCounter.incrementAndGet(),"Tom", "Ranganath", 40, "3106 Kings Court", 50000));
        users.add(new User(idCounter.incrementAndGet(),"Jerome", "King", 45, "3100 Kings Court", 30000));
        users.add(new User(idCounter.incrementAndGet(),"Silvia", "Nanja", 50, "3104 Kings Court", 40000));
        return users;
    }

	


	
	
	
}
