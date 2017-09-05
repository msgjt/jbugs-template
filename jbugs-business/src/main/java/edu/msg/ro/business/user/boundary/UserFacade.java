package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.interceptor.Interceptors;

import edu.msg.ro.business.common.exception.BusinessException;
import edu.msg.ro.business.common.interceptor.LoggingInterceptor;
import edu.msg.ro.business.user.control.UserSomething;
import edu.msg.ro.business.user.dto.UserDTO;

/**
 * Boundary for user component.
 * 
 * @author floricea
 * 
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
@Interceptors(LoggingInterceptor.class)
public class UserFacade {

	@EJB
	private UserSomething userSomething;

	public UserDTO createUser(UserDTO user) throws BusinessException {

		return userSomething.createUser(user);
	}

}
