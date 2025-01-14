package com.evanxu.dictionary;

import static com.evanxu.util.Constants.NON_ALPHABETICAL_LETTER;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Utility loader for the dictionary.
 */
public class DictionaryLoader {
	
	/** Logger. */
	private static final Logger LOGGER = Logger.getLogger(DictionaryLoader.class.getName());
	
	/**
	 * Loads the dictionary.
	 * 
	 * @param filePath the dictionary file path
	 * @param dictionary the dictionary
	 */
    public static void loadDictionary(String filePath, IDictionary dictionary) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String cleanedWord = line.replaceAll(NON_ALPHABETICAL_LETTER, "").toUpperCase();
                if (!cleanedWord.isEmpty()) {
                    dictionary.addWord(cleanedWord);
                }
            }
        } catch (IOException e) {
        	LOGGER.warning(() -> "Cannot load dictionary");
			e.printStackTrace();
		}
    }
}
