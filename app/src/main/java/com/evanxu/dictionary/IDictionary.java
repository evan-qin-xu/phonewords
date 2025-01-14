package com.evanxu.dictionary;

import java.util.Set;

/**
 * The dictionary interface.
 */
public interface IDictionary {
	/**
	 * Retrieves the dictionary words.
	 * 
	 * @return the dictionary words
	 */
	Set<String> getWords();

	/**
	 * Adds a word to the dictionary.
	 * 
	 * @param word the word
	 * @return true if the word is successfully added.
	 */
	boolean addWord(String word);
}
