package com.sr.biz.freightbit.core.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sr.biz.freightbit.core.dao.GroupDao;
import com.sr.biz.freightbit.core.dao.GroupUserDao;
import com.sr.biz.freightbit.core.entity.Group;
import com.sr.biz.freightbit.core.entity.GroupUser;
import com.sr.biz.freightbit.core.entity.User;
import com.sr.biz.freightbit.core.exceptions.GroupAlreadyExistsException;
import com.sr.biz.freightbit.core.service.GroupService;

/**
 * 
 * @author junoroxas
 *
 */
public class GroupServiceImpl implements GroupService {
	
	GroupDao groupDao;
	GroupUserDao groupUserDao;

	public void setGroupUserDao(GroupUserDao groupUserDao) {
		this.groupUserDao = groupUserDao;
	}

	public void setGroupDao(GroupDao groupDao) {
		this.groupDao = groupDao;
	}


	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addGroup(Group group) throws GroupAlreadyExistsException {
		try {
			if (groupDao.findByGroupId(group.getGroupId())!=null) 
				throw new GroupAlreadyExistsException(group.getName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		groupDao.addGroup(group);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void updateGroup(Group group) {
		groupDao.updateGroup(group);
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void deleteGroup(Group group) {
		
		//remove all entries under GroupUser table
	    List<GroupUser> groupUsers = groupUserDao.findAllUsersByGroupId(group.getGroupId());
	    for (int i=0; i < groupUsers.size(); i++) {
	        GroupUser groupUser = (GroupUser) groupUsers.get(i);
	        groupUserDao.deleteGroupUser(groupUser);
	    }
	    
	    //permissionDao.deletePermissions(group);
	    groupDao.deleteGroup(group);
	}

	@Override
	public List<Group> findAllGroups() {
		return null;
	}

	@Override
	public Group findGroupByGroupId(long groupId) {
		return groupDao.findByGroupId(groupId);
	}

	@Override
	public Group findGroupByGroupName(String groupName) {
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void addUser(Group group, User user) {
		// TODO Auto-generated method stub
		
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	@Override
	public void removeUser(Group group, User user) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUser(long userId, long groupId, long clientId) {
		GroupUser groupUser = new GroupUser();
		groupUser.setUserId(userId);
		groupUser.setGroupId(groupId);
		groupUser.setClientId(clientId);
		//groupUserDao.addGroupUser(groupUser);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteUser(GroupUser groupUser) {
		//groupUserDao.deleteGroupUser(groupUser);
	}

	

	@Override
	public List<GroupUser> findAllUsersByGroupId(long groupId) {
		//return groupUserDao.findAllUsersByGroupId(groupId);
		return null;
	}

	@Override
	public List<GroupUser> findAllGroupsByUserId(long userId) {
		//return groupUserDao.findAllGroupsByUserId(userId);
		return null;
	}


	@Override
	public boolean isMember(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
