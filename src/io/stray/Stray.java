package io.stray;

import io.stray.word.WordConstraint;
import io.stray.word.WordList;

public class Stray {
	
	public static void main(String[] args) {
		WordList words = WordList.readListFromFile("words.txt");
		
		words.filter(new WordConstraint(7));
		words.filter(new WordConstraint('s', 0));
		words.filter(new WordConstraint('r', 3));
		words.filter(new WordConstraint('e'));
		words.filter(new WordConstraint('e'));
		words.filter(new WordConstraint('o'));
		words.forEachRemaining(System.out::println);
	}
	
}
