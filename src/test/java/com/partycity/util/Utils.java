package com.partycity.util;
import java.util.Random;

public class Utils {

	
	    private static final String[] DOMAINS = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "aol.com"};
	    private static final int PASSWORD_LENGTH = 8;

	    public static void main(String[] args) {
	        String email = generateRandomEmail();
	        String password = generateRandomPassword();
	        System.out.println("Random email: " + email);
	        System.out.println("Random password: " + password);
	    }

	    private static String generateRandomEmail() {
	        Random random = new Random();
	        String username = "user" + random.nextInt(1000);
	        String domain = DOMAINS[random.nextInt(DOMAINS.length)];
	        return username + "@" + domain;
	    }

	    private static String generateRandomPassword() {
	        String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
	        String CHAR_UPPER = CHAR_LOWER.toUpperCase();
	        String NUMBER = "0123456789";
	        String OTHER_CHAR = "#_";
	        String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;
	        Random random = new Random();
	        StringBuilder password = new StringBuilder();
	        for (int i = 0; i < PASSWORD_LENGTH; i++) {
	            int randomIndex = random.nextInt(PASSWORD_ALLOW_BASE.length());
	            password.append(PASSWORD_ALLOW_BASE.charAt(randomIndex));
	        }
	        return password.toString();
	    }
	}


