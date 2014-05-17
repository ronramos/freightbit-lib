package com.sr.biz.freightbit.core.dao;

import java.util.List;

import com.sr.biz.freightbit.core.entity.Group;

public interface GroupDao {

	public void updateGroup(Group group);

	public void addGroup(Group group);

	public void deleteGroup(Group group);

	public Group findByGroupId(Long id);

	public List<Group> findGroupByExample(Group instance);
	
	public List<Group> findAllGroups();

}