package edu.msg.ro.business.user.boundary;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import edu.msg.ro.business.exception.JBugsBusinessException;
import edu.msg.ro.business.notification.service.NotificationService;
import edu.msg.ro.business.notification.type.NotificationType;
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

	@EJB
	private UserService userService;

	@EJB
	private NotificationService notificationService;

	public boolean deleteUser(final Long userId) {
		try {
			final boolean deletionSuccessful = userService.deleteUser(userId);

			if (deletionSuccessful) {
				notificationService.createNotification(NotificationType.USER_DELETED);
				// TODO send notification to client
			}

			return deletionSuccessful;
		} catch (final JBugsBusinessException e) {
			// TODO add exceptionhandling interceptor
			// TODO add logger decorator?
			e.printStackTrace();
			return false;
		}
	}

}
