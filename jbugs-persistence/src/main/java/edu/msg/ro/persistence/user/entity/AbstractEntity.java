package edu.msg.ro.persistence.user.entity;

import javax.persistence.Version;

public abstract class AbstractEntity {

	@Version
	private Long lockVersion;

	public Long getLockVersion() {
		return lockVersion;
	}

	public void setLockVersion(Long lockVersion) {
		this.lockVersion = lockVersion;
	}

	public abstract Long getId();

}
