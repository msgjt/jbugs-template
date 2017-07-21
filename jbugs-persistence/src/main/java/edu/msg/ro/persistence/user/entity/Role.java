package edu.msg.ro.persistence.user.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable {

	public Role() {
	}

	public Role(String roleName) {
		super();
		this.roleName = roleName;
	}

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRole")
	private int id;
	@Column(nullable = false, unique = true, length = 50)
	private String roleName;

	@ManyToMany(mappedBy = "roles")
	private List<User> users;

	@ManyToMany
	@JoinTable(name = "ROLE_PERMISSION", joinColumns = @JoinColumn(name = "id_role", referencedColumnName = "idRole"), inverseJoinColumns = @JoinColumn(name = "id_permission", referencedColumnName = "idPermission"))
	private List<Permission> permissions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}