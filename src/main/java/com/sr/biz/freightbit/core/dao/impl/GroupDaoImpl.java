package com.sr.biz.freightbit.core.dao.impl;


import static org.hibernate.criterion.Example.create;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.sr.biz.freightbit.core.dao.GroupDao;
import com.sr.biz.freightbit.core.entity.Group;

/**
 * Home object for domain model class Group.
 * @see com.com.sr.biz.freightbit.core.entity.Group
 * @author Hibernate Tools
 */
@Transactional
public class GroupDaoImpl extends HibernateDaoSupport implements GroupDao{

	private static final Log log = LogFactory.getLog(GroupDaoImpl.class);

	/* (non-Javadoc)
	 * @see com.sr.biz.freightbit.customer.dao.GroupDao#updateGroup(com.sr.biz.freightbit.customer.entity.Group)
	 */
	@Override
	public void updateGroup(Group group) {
		log.debug("updating a new Group");
		try {
			Session session = getSessionFactory().getCurrentSession();
			session.saveOrUpdate(group);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sr.biz.freightbit.customer.dao.GroupDao#addGroup(com.sr.biz.freightbit.customer.entity.Group)
	 */
	@Override
	public void addGroup(Group group) {
		log.debug("adding a new Group");
		try {			
			Session session = getSessionFactory().getCurrentSession();
			session.save(group);
			log.debug("add successful");
		} catch (RuntimeException re) {
			log.error("add failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.sr.biz.freightbit.customer.dao.GroupDao#deleteGroup(com.sr.biz.freightbit.customer.entity.Group)
	 */
	@Override
	public void deleteGroup(Group group) {
		log.debug("deleting a Group");
		try {
			Session session = getSessionFactory().getCurrentSession();
			session.delete(group);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.sr.biz.freightbit.customer.dao.GroupDao#findByGroupId(java.lang.String)
	 */
	@Override
	public Group findByGroupId(Long id) {
		log.debug("getting Group instance with id: " + id);
		try {
			Group instance = (Group) getSessionFactory().getCurrentSession()
					.get(Group.class, id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	/* (non-Javadoc)
	 * @see com.sr.biz.freightbit.customer.dao.GroupDao#findGroupByExample(com.sr.biz.freightbit.customer.entity.Group)
	 */
	@Override
	public List<Group> findGroupByExample(Group instance) {
		log.debug("finding Group instance by example");
		try {
			List<Group> results = (List<Group>) getSessionFactory()
					.getCurrentSession()
					.createCriteria(Group.class)
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@Override
	public List<Group> findAllGroups() {
		log.debug("finding all groups");
		try {
			List<Group> groups = (List <Group>) getSessionFactory()
			.getCurrentSession().createQuery("from Group").list();
			
			return groups;
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
}
