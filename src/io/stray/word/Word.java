package io.stray.word;

public class Word {
	
	private static final char USED_CHARACTER = 0;
	
	private final String string;
	private final char[] characters;
	
	private boolean filtered = false;
	
	public Word(String string) {
		this.string = string;
		this.characters = string.toCharArray();
	}
	
	public void filter(WordConstraint constraint) {
		switch(constraint.getType()) {
			case LENGTH -> {
				
				int length = constraint.getLength();
				
				if(characters.length != length) filtered = true;
				
			}
			case FIXED_CHARACTER -> {
				
				char character = constraint.getCharacter();
				int position = constraint.getCharacterPosition();
				
				if(position >= characters.length || characters[position] != character) {
					
					filtered = true;
					return;
				}
				
				characters[position] = USED_CHARACTER;
				
			}
			case VARIABLE_CHARACTER -> {
				
				char character = constraint.getCharacter();
				
				for(int position = 0; position < characters.length; position++) {
					if(characters[position] == character) {
						
						characters[position] = USED_CHARACTER;
						return;
					}
				}
				
				filtered = true;
			}
		}
	}
	
	@Override
	public String toString() {
		return string;
	}
	
	public char[] getCharacters() {
		return characters;
	}
	
	public boolean isFiltered() {
		return filtered;
	}
	
}
