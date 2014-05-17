package com.sr.biz.freightbit.core.service;

import java.util.List;

import com.sr.biz.freightbit.core.dao.UserDao;
import com.sr.biz.freightbit.core.entity.User;
import com.sr.biz.freightbit.core.exceptions.UserAlreadyExistsException;

public interface UserService {

	public void addUser(User user) throws UserAlreadyExistsException;

	public void updateUser(User user);

	/**
	 * Can't use updateUser(User) as this need not update the lastModifiedDate
	 * @param user
	 */
	public void updateLastVisitDate(User user);
	
	public void deleteUser(User user);

	public User findUserById(long userId);

	public List<User> findAllUsers();
	
	public List<User> findAllUsersByClientId(long clientId);
	
	public User findUserByUserName(String userName);

}