package edu.msg.ro.business.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import edu.msg.ro.persistence.user.entity.Role;
import edu.msg.ro.persistence.user.entity.User;

/**
 * TODO make CDI @SessionScoped/ @RequestScoped TODO add SecurityFilter
 * 
 * @author Andrei Floricel, msg systems ag
 *
 */
@Stateless
public class SessionContextHandler {

	public User getCurrentUser() {
		// TODO add concrete implementation when authentication is available
		return new User();
	}

	public List<Role> getCurrentUserRoles() {
		// TODO add concrete implementation when authentication is available
		return new ArrayList<>();
	}
}
