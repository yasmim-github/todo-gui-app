package com.func;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NormasEsc {

	private static Pattern email_valido = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$");

	private static Pattern user_valido = Pattern.compile("^[A-Z]{3,15}+[0-9]{1}+[_%-]{1}");

	public final static boolean REGEX_EMAIL_VALIDO(String email) {
		Matcher email_matcher = email_valido.matcher(email);
		System.out.println(email_matcher.matches());
		return email_matcher.matches();
	}

	public final static boolean REGEX_USER_VALIDO(String usuario) {
		Matcher user_matcher = user_valido.matcher(usuario);
		System.out.println(user_matcher.matches());
		return user_matcher.matches();
	}

}
