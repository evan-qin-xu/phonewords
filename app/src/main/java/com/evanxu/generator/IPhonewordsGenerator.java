package com.evanxu.generator;

import java.util.List;

import com.evanxu.dictionary.IDictionary;

/**
 * The phonewords generator interface.
 */
public interface IPhonewordsGenerator {
	/**
	 * Generates the phone words.
	 * 
	 * @param phoneNumber the phone number
	 * @param dictionary  the dictionary
	 * @return list of valid phone words.
	 */
	List<String> generateDictionaryWords(String phoneNumber, IDictionary dictionary);
}
