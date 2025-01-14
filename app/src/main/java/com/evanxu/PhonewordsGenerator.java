package com.evanxu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.evanxu.dictionary.IDictionary;

public class PhonewordsGenerator implements IPhonewordsGenerator {

	/* Mapping of digits to corresponding letters. */
	private static final Map<Character, String> digitToLettersMap = new HashMap<>();

	/**
	 * Constructor.
	 */
	public PhonewordsGenerator() {
		digitToLettersMap.put('0', "");
		digitToLettersMap.put('1', "");
		digitToLettersMap.put('2', "ABC");
		digitToLettersMap.put('3', "DEF");
		digitToLettersMap.put('4', "GHI");
		digitToLettersMap.put('5', "JKL");
		digitToLettersMap.put('6', "MNO");
		digitToLettersMap.put('7', "PQRS");
		digitToLettersMap.put('8', "TUV");
		digitToLettersMap.put('9', "WXYZ");
	}

	@Override
	public List<String> generateDictionaryWords(String phoneNumber, IDictionary dictionary) {
		List<String> allValidPhonewords = new ArrayList<>();
		Map<Integer, List<String>> phonewords = new HashMap<>();
		generateWords(phoneNumber, 0, "", phonewords, dictionary.getWords(), 0, "");
		for (Entry<Integer, List<String>> phonewordEntry : phonewords.entrySet()) {
			int numChars = 0;
			String phoneWord = "";
			for (String word : phonewordEntry.getValue()) {
				numChars += word.length();
				phoneWord = phoneWord + word + "-";
			}
			/* Remove the last '-'. */
			String validPhoneWords = phoneWord.substring(0, phoneWord.length() - 1);
			if (numChars == phoneNumber.length()) {
				allValidPhonewords.add(validPhoneWords);
			}
		}
		return allValidPhonewords;
	}

	/**
	 * Depth first traversal, iterate all the possible combinations and store words
	 * that can be found in dictionary.
	 * 
	 * @param phoneNumber the phone number
	 * @param index       the index of the digit
	 * @param currentWord the current word
	 * @param phonewords  the phonewords result list
	 * @param dictionary  the dictionary
	 * @param count       the number of phone words
	 * @param firstWord   the first word of the list of phone words
	 * @return
	 */
	private static int generateWords(String phoneNumber, int index, String currentWord,
			Map<Integer, List<String>> phonewords, Set<String> dictionary, int count, String firstWord) {
		boolean containsCurrentWord = dictionary.contains(currentWord.toUpperCase());
		if (containsCurrentWord) {
			List<String> words = phonewords.getOrDefault(count, new ArrayList<>());
			if (words.isEmpty() && !firstWord.isEmpty()) {
				/* The first word is found, add the first word to the empty list. */
				words.add(firstWord);
			}
			words.add(currentWord);
			phonewords.put(count, words);
			firstWord = currentWord;
			currentWord = "";

			if (index == phoneNumber.length()) {
				/*
				 * This is the last word found, increment the key for the potential newly found
				 * words combination entry.
				 */
				count++;
			}
		}

		if (index == phoneNumber.length()) {
			/*
			 * Search operation reaches the end of the phone number, return the number of
			 * words found.
			 */
			return count;
		}

		/*
		 * For each letter mapped to the digit, recursively search the word for that
		 * letter.
		 */
		char digit = phoneNumber.charAt(index);
		if (digitToLettersMap.containsKey(digit)) {
			String letters = digitToLettersMap.get(digit);
			for (char letter : letters.toCharArray()) {
				count = generateWords(phoneNumber, index + 1, currentWord + letter, phonewords, dictionary, count,
						firstWord);
			}
			/* No words can be generated with this digit, append the digit. */
			if (count == 0 && containsCurrentWord) {
				phonewords.get(phonewords.size() - 1).add(String.valueOf(digit));
				count++;
				/* Continue the search if not reaching the end of the phone number. */
				index++;
				if (index < phoneNumber.length()) {
					digit = phoneNumber.charAt(index);
					for (char letter : digitToLettersMap.get(digit).toCharArray()) {
						count = generateWords(phoneNumber, index + 1, currentWord + letter, phonewords, dictionary,
								--count, "");
					}
				}
			}
		}
		return count;
	}
}
