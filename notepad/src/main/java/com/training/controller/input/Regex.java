package com.training.controller.input;

import java.util.regex.Pattern;

public interface Regex {
	Pattern NICKNAME_PATTERN = Pattern.compile("^[a-zA-Z][a-zA-Z0-9._-]{3,}$");
	Pattern NAME_PATTERN = Pattern.compile("^[a-zA-Z]{3,}$");
	Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10}$");

}
