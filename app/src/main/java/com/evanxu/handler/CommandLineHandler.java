package com.evanxu.handler;

import static com.evanxu.util.Constants.DIGITS;
import static com.evanxu.util.Constants.EMPTY_STR;
import static com.evanxu.util.Constants.EXIT_MESSAGE;
import static com.evanxu.util.Constants.USER_INPUT_PROMT;
import static com.evanxu.util.Constants.WELCOME_MSG;

import java.util.Scanner;

/**
 * A command line handler to handler user input for generating the phone-words.
 */
public class CommandLineHandler implements IInputHandler {

	/** Input scanner. */
	private Scanner scanner;

	/**
	 * Constructor.
	 */
	public CommandLineHandler() {
		this.scanner = new Scanner(System.in);
	}

	@Override
	public void start() {
		System.out.println(WELCOME_MSG);

		while (true) {
			System.out.print(USER_INPUT_PROMT);
			String input = scanner.nextLine();

			/* Exit the app. */
			if ("exit".equalsIgnoreCase(input)) {
				System.out.println(EXIT_MESSAGE);
				break;
			}

			processInput(input);
		}
	}

	/**
	 * Generates the phone words and prints them to the console.
	 * 
	 * @param input the user input
	 */
	private void processInput(String input) {
		/* Sanity check. */
		if (input == null) {
			return;
		}

		/* Remove all non-digit characters. */
		String inputNumber = input.replaceAll(DIGITS, EMPTY_STR);

		System.out.println("You entered: " + inputNumber.toUpperCase());
	}

	@Override
	public void close() {
		if (scanner != null) {
			scanner.close();
		}
	}
}