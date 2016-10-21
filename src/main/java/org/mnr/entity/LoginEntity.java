package org.mnr.entity;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;
/**
 * @author Naveen Reddy
 * @version 1.0
 */
public class LoginEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Length(min=1,message="User Id Can't be empty")
	private String userId;
	@Length(min=1,message="Password Can't be empty")
	private String password;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LoginEntity [userId=");
		builder.append(userId);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

}
