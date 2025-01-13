package com.evanxu;

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
		CommandLineHandler inputHandler = new CommandLineHandler();
		inputHandler.start();
		inputHandler.close();
	}
}
