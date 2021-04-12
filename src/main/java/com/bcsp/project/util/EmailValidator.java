package com.bcsp.project.util;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component("emailValidator")
public class EmailValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	public EmailValidator() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public boolean valid(final String email) {

		matcher = pattern.matcher(email);
		return matcher.matches();

	}
	// validate first name
	public static boolean firstName( String firstName ) {
		return firstName.matches( "[A-Z][a-z]*" );
	}
	// validate last name
	public static boolean lastName( String lastName ) {
		return lastName.matches( "[A-Z]+([ '-][a-zA-Z]+)*" );
	}
	// validate mobile number
	public static boolean mobileNumber( String mobileNumber ) {
		return mobileNumber.matches( "(0/91)?[7-9][0-9]{9}" );
	}

	// validate mobile number
	public static boolean emailAddress( String emailAddress ) {
		return emailAddress.matches( "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" );
	}

}