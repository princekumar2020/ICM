package com.icm.security;

/*
 * This class is used to make getter and setter methods
 * to send and receive data to network as a stream.
 */

import java.io.Serializable;

public class UserSession implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int profileId;

	public UserSession() {
		super();
		
	}

	public UserSession(int talentId) {
		this.profileId = talentId;
	}
	
	public int getProfileId() {
		return profileId;
	}

}
