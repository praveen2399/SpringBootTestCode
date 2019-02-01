package com.tcs.fresco;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationCheck {

	Map<String, String> credMap = new HashMap<String, String>();

	public AuthenticationCheck() {
		credMap.put("Dave", "Lemon567&9");
		credMap.put("Fenu", "Q7ua6k34");
		credMap.put("Ohio", "Hend97_a");
	}

	public boolean validateUser(String uname) {
		boolean isValid = false;
		isValid = credMap.containsKey(uname);
		return isValid;
	}

}
