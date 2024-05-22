package com.func;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NormasEsc {

	public final static boolean REGEX_EMAIL_VALIDO(String email) {
		Pattern email_valido = Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{1,8}$");
		Matcher email_matcher = email_valido.matcher(email);
		System.out.println(email_matcher.matches() + "email");
		return email_matcher.matches();
	}

	public final static boolean REGEX_USER_VALIDO(String usuario) {
		Pattern user_valido = Pattern.compile("^[A-Za-z0-9]{3,10}[_%-]{1,3}$");
		Matcher user_matcher = user_valido.matcher(usuario);
		System.out.println(user_matcher.matches() + "user");
		return user_matcher.matches();
	}

}
