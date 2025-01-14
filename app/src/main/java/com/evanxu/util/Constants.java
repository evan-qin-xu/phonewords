package com.evanxu.util;

/**
 * Utility class for storing constants.
 */
public class Constants {
	/** Welcome message. */
	public static final String WELCOME_MSG = "Welcome to phone-words app!\nType your phone number to get all possible phonewords.\nType 'exit' to quit the app.";

	/** User input prompt message. */
	public static final String USER_INPUT_PROMPT = "Enter your number: ";

	/** Exit message. */
	public static final String EXIT_MESSAGE = "Exiting... Thanks for using the phonewords app! To relaunch, use './gradlew run'";

	/** Regex for matching digits. */
	public static final String DIGITS = "\\D";

	/** Empty string. */
	public static final String EMPTY_STR = "";

	/** Regex for non alphabetical letter. */
	public static final String NON_ALPHABETICAL_LETTER = "[^a-zA-Z]";

	/** Default dictionary file path. */
	public static final String DEFAULT_DICTIONARY_FILE_PATH = "src/main/resources/dictionary.txt";
}
