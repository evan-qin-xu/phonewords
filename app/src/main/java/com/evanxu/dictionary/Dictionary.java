package com.evanxu.dictionary;

import java.util.HashSet;
import java.util.Set;

public class Dictionary implements IDictionary{
	
	/** Unique Dictionary words. */
	private Set<String> words = new HashSet<>();

	@Override
	public String toString() {
		return "Dictionary [dictionary=" + words + "]";
	}

	@Override
	public Set<String> getWords() {
		return words;
	}

	@Override
	public boolean addWord(String word) {
		return words.add(word);
	}
}
