package com.tcs.fresco;

public interface UserAuthenticatorInt {

	public boolean authenticateUser(String username, String password)
			throws FailedToAuthenticateException;
}
