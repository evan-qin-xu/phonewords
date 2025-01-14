package com.evanxu.handler;

import static com.evanxu.util.Constants.DIGITS;
import static com.evanxu.util.Constants.EMPTY_STR;
import static com.evanxu.util.Constants.EXIT_MESSAGE;
import static com.evanxu.util.Constants.USER_INPUT_PROMPT;
import static com.evanxu.util.Constants.WELCOME_MSG;

import java.util.List;
import java.util.Scanner;

import com.evanxu.IPhonewordsGenerator;
import com.evanxu.PhonewordsGenerator;
import com.evanxu.dictionary.Dictionary;
import com.evanxu.dictionary.DictionaryLoader;
import com.evanxu.dictionary.IDictionary;

/**
 * A command line handler to handle user input for generating the phonewords.
 */
public class CommandLineHandler implements IInputHandler {

	/** Input scanner. */
	private Scanner scanner;

	/** Dictionary. */
	private IDictionary dictionary;
	
	/** Phonewords generator. */
	IPhonewordsGenerator generator;

	/**
	 * Constructor.
	 * 
	 * @param dictPath the dictionary file path
	 */
	public CommandLineHandler(String dictPath) {
		this.scanner = new Scanner(System.in);
		this.dictionary = new Dictionary();
		DictionaryLoader.loadDictionary(dictPath, dictionary);
		generator = new PhonewordsGenerator();
	}

	@Override
	public void start() {
		System.out.println(WELCOME_MSG);

		while (true) {
			System.out.print(USER_INPUT_PROMPT);
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
	 * Generates the phonewords and prints them to the console.
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
		List<String> phonewords = generator.generateDictionaryWords(inputNumber, dictionary);
		phonewords.forEach(w -> System.out.println(w));
	}

	@Override
	public void close() {
		if (scanner != null) {
			scanner.close();
		}
	}
}