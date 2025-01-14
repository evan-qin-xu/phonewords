package com.evanxu;

import java.util.List;
import java.util.Set;

import com.evanxu.dictionary.IDictionary;

public interface IPhonewordsGenerator {
	
	/**
	 * Generates the phone words.
	 * 
	 * @param phoneNumber the phone number
	 * @param dictionary the dictionary
	 * @return list of valid phone words.
	 */
	List<String> generateDictionaryWords(String phoneNumber, IDictionary dictionary);
}
