package dao;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;

import entities.Role;
import entities.User;

@Remote
public interface UserManagement extends Serializable {

	void addUser(User user);

	User updateUser(User user);

	List<User> getAllUsers();

	User getUserForUsername(String username);

	void deactivateUser(int id);

	void addRole(Role role);

	void removeRole(Role role);

	Role updateRole(Role role);

	Role getRoleForId(int id);

	List<Role> getAllRoles();
}
