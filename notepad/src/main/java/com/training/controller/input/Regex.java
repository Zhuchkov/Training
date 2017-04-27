package com.training.controller.input;

import java.util.regex.Pattern;

import com.training.view.ResourceManager;

 interface Regex {
	Pattern NICKNAME_PATTERN = Pattern.compile(ResourceManager.INSTANCE.getString("regex.nickname"));
	Pattern NAME_PATTERN = Pattern.compile(ResourceManager.INSTANCE.getString("regex.name"));
	Pattern PHONE_PATTERN = Pattern.compile(ResourceManager.INSTANCE.getString("regex.phonenumber"));

}
