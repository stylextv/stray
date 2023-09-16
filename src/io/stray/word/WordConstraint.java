package io.stray.word;

public class WordConstraint {
	
	private static final int MISSING_LENGTH = 0;
	private static final char MISSING_CHARACTER = 0;
	private static final int MISSING_CHARACTER_POSITION = 0;
	
	private final WordConstraintType type;
	
	private final int length;
	private final char character;
	private final int characterPosition;
	
	public WordConstraint(char character, int characterPosition) {
		this(WordConstraintType.FIXED_CHARACTER, MISSING_LENGTH, character, characterPosition);
	}
	
	public WordConstraint(char character) {
		this(WordConstraintType.VARIABLE_CHARACTER, MISSING_LENGTH, character, MISSING_CHARACTER_POSITION);
	}
	
	public WordConstraint(int length) {
		this(WordConstraintType.LENGTH, length, MISSING_CHARACTER, MISSING_CHARACTER_POSITION);
	}
	
	private WordConstraint(WordConstraintType type, int length, char character, int characterPosition) {
		this.type = type;
		this.length = length;
		this.character = character;
		this.characterPosition = characterPosition;
	}
	
	public WordConstraintType getType() {
		return type;
	}
	
	public int getLength() {
		return length;
	}
	
	public char getCharacter() {
		return character;
	}
	
	public int getCharacterPosition() {
		return characterPosition;
	}
	
}
