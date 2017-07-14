package ro.msg.edu.jbugs.business;

import javax.ejb.Remote;

import ro.msg.edu.jbugs.entities.User;

@Remote
public interface UserServiceRemote {

	public void addUser(User user);
}
