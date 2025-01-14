package com.evanxu;

import static com.evanxu.util.Constants.DEFAULT_DICTIONARY_FILE_PATH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.evanxu.dictionary.Dictionary;
import com.evanxu.dictionary.DictionaryLoader;
import com.evanxu.dictionary.IDictionary;
import com.evanxu.generator.IPhonewordsGenerator;
import com.evanxu.generator.PhonewordsGenerator;

/**
 * Unit test for the @{link {@link PhonewordsGenerator}.
 */
public class PhonewordsGeneratorTest {

	/** The phone words generator. */
	IPhonewordsGenerator generator;

	/** Dictionary. */
	private IDictionary dictionary;

	@Before
	public void setUp() {
		dictionary = new Dictionary();
		DictionaryLoader.loadDictionary(DEFAULT_DICTIONARY_FILE_PATH, dictionary);
		generator = new PhonewordsGenerator();
	}

	/**
	 * Tests for the valid phone words. See doc/requirements.txt for the definition
	 * of valid phone words.
	 */
	@Test
	public void testGenerateDictionaryWords() {
		assertTrue("Incorrect phone words", generator.generateDictionaryWords("", dictionary).isEmpty());
		assertTrue("Incorrect phone words", generator.generateDictionaryWords("0", dictionary).isEmpty());
		assertTrue("Incorrect phone words", generator.generateDictionaryWords("1", dictionary).isEmpty());
		assertTrue("Incorrect phone words", generator.generateDictionaryWords("01", dictionary).isEmpty());

		assertEquals("Incorrect phone words", new ArrayList<>(Arrays.asList("GONE-TREE", "HOME-TREE")),
				generator.generateDictionaryWords("46638733", dictionary));
		assertEquals("Incorrect phone words",
				new ArrayList<>(Arrays.asList("GONE-GONE", "GONE-HOME", "HOME-GONE", "HOME-HOME")),
				generator.generateDictionaryWords("46634663", dictionary));

		assertEquals("Incorrect phone words", new ArrayList<>(Arrays.asList("KITTY")),
				generator.generateDictionaryWords("54889", dictionary));

		assertEquals("Incorrect phone words",
				new ArrayList<>(Arrays.asList("GONE-GONE", "GONE-HOME", "HOME-GONE", "HOME-HOME")),
				generator.generateDictionaryWords("46634663", dictionary));

		assertEquals("Incorrect phone words", new ArrayList<>(Arrays.asList("STAR-WARS")),
				generator.generateDictionaryWords("78279277", dictionary));

		assertEquals("Incorrect phone words", new ArrayList<>(Arrays.asList("STAR-WARS-1")),
				generator.generateDictionaryWords("782792771", dictionary));

		assertEquals("Incorrect phone words", new ArrayList<>(Arrays.asList("STAR-WARS-9")),
				generator.generateDictionaryWords("782792779", dictionary));

		assertEquals("Incorrect phone words", new ArrayList<>(Arrays.asList("STAR-WARS-9")),
				generator.generateDictionaryWords("782792779", dictionary));

		assertEquals("Incorrect phone words", new ArrayList<>(Arrays.asList("STAR-9-WARS")),
				generator.generateDictionaryWords("782799277", dictionary));

		assertTrue("Phonewords should not contain more than 2 digits",
				generator.generateDictionaryWords("7827927799", dictionary).isEmpty());
	}

	@After
	public void cleanUp() {
		dictionary = null;
		generator = null;
	}
}
