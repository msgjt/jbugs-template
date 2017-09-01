package edu.msg.ro.business.dao;

import javax.ejb.Stateless;

import edu.msg.ro.persistence.user.entity.User;

@Stateless
public class UserDao extends AbstractDao<User> {

	@Override
	public Class<User> getEntityClass() {
		return User.class;
	}
}
