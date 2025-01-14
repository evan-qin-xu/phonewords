package com.evanxu;

import static com.evanxu.util.Constants.DEFAULT_DICTIONARY_FILE_PATH;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

import com.evanxu.handler.CommandLineHandler;
import com.sun.tools.javac.Main;

/**
 * The main class of the application.
 */
public class App {

	/** Logger. */
	private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

	/**
	 * Entry point of the program.
	 */
	public static void main(String[] args) {
		LOGGER.info(() -> "App starting");

		String dictPath;
		String customDictPath = System.getProperty("dictionnary");
		if (customDictPath != null && Files.exists(Paths.get(customDictPath))) {
			dictPath = customDictPath;
			LOGGER.info(() -> "Loading custom dictionary from " + dictPath);
		} else {
			dictPath = DEFAULT_DICTIONARY_FILE_PATH;
			LOGGER.info(() -> "Loading default dictionary from" + dictPath);
		}

		CommandLineHandler inputHandler = new CommandLineHandler(dictPath);
		inputHandler.start();
		inputHandler.close();
	}
}
