package com.sr.biz.freightbit.core.service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sr.biz.freightbit.core.entity.Group;
import com.sr.biz.freightbit.core.entity.GroupUser;
import com.sr.biz.freightbit.core.entity.User;
import com.sr.biz.freightbit.core.exceptions.GroupAlreadyExistsException;

public interface GroupService {

	public void addGroup(Group group) throws GroupAlreadyExistsException;

	public void updateGroup(Group group);

	public void deleteGroup(Group group);

	public List<Group> findAllGroups();
	
	public Group findGroupByGroupId(long groupId);
	
	public Group findGroupByGroupName(String groupName);
	
    public void addUser(Group group, User user);

    public void removeUser(Group group, User user);

    public boolean isMember(User user);
    
	public void addUser(long userId, long groupId, long clientId);
	
	public void deleteUser(GroupUser groupUser);

	public List<GroupUser> findAllUsersByGroupId(long groupId);
	
	public List<GroupUser> findAllGroupsByUserId(long userId);
}
