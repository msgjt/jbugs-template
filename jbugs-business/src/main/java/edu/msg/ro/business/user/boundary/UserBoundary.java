package edu.msg.ro.business.user.boundary;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.user.service.UserService;

/**
 * Boundary for User Management.
 * 
 * @author Andrei Floricel, msg systems ag
 *
 */
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Stateless
public class UserBoundary {

	private UserService userService;

	public boolean deleteUser(final Long userId) {
		return userService.deleteUser(userId);
	}

}
