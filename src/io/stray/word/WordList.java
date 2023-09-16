package io.stray.word;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class WordList {
	
	private final List<Word> words = new ArrayList<>();
	
	public void forEachRemaining(Consumer<Word> wordConsumer) {
		words.forEach((word) -> {
			if(!word.isFiltered()) wordConsumer.accept(word);
		});
	}
	
	public void filter(WordConstraint constraint) {
		words.forEach((word) -> word.filter(constraint));
	}
	
	public void addWord(String wordString) {
		wordString = wordString.toLowerCase();
		
		words.add(new Word(wordString));
	}
	
	public static WordList readListFromFile(String path) {
		try {
			
			FileReader reader = new FileReader(path);
			BufferedReader bufferedReader = new BufferedReader(reader);
			
			WordList words = new WordList();
			
			while(true) {
				String wordString = bufferedReader.readLine();
				if(wordString == null) break;
				
				words.addWord(wordString);
			}
			
			return words;
			
		} catch(IOException exception) {
			
			System.out.printf("Error while reading word list: %s", exception);
			return null;
		}
	}
	
}
