package edu.msg.ro.business.user.dto;

import edu.msg.ro.business.dto.AbstractoDTO;

public class UserDTO extends AbstractoDTO {

	private String firstName;

	private String lastName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "UserDTO [firstName=" + firstName + ", lastName=" + lastName + "]";
	}

}
