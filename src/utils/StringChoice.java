package utils;

import java.util.Vector;

public class StringChoice {
	
	private final static String  STRING_ERROR = "Given string is not properly formatted";
	private static final int NOT_FOUND = -1;
	private static final char CHOICE_START = '$';
	private static final char CHOICE_END = '�';
	private static final String CHOICE_START_DEFAULT = "(";
	private static final String CHOICE_END_DEFAULT = ")";
	private static final String EMPTY = "";
	
	private String[] choices;
	private String message;
	
	
	public StringChoice(String s) throws IllegalArgumentException {
		this(s, CHOICE_START_DEFAULT, CHOICE_END_DEFAULT);
	}
	
	public StringChoice(String s, String afterChoice) throws IllegalArgumentException {
		this(s, EMPTY, afterChoice);		
	}
	
	public StringChoice(String s, String beforeChoice, String afterChoice) throws IllegalArgumentException {
		if (numOfChoices(s) == 0) throw new IllegalArgumentException(STRING_ERROR);
		
		StringBuffer message = new StringBuffer();
		Vector<String> choices = new Vector<String>();
		
		int startIndex = -1;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			
			if (startIndex >= 0 && c == CHOICE_END) {
				String choice = s.substring(startIndex, i);
				if (unacceptable(choice, choices)) 
					throw new IllegalArgumentException(STRING_ERROR);
				choices.add(choice);
				startIndex = -1;
			}
			else if (startIndex < 0 && c == CHOICE_START) {
				startIndex = i+1;
			}
			else if  (c == CHOICE_END || c == CHOICE_START)
				throw new IllegalArgumentException(STRING_ERROR);
			
			if (c == CHOICE_END) 		message.append(afterChoice);
			else if (c == CHOICE_START) message.append(beforeChoice);
			else 						message.append(c);
		}
		
		if (startIndex >= 0) throw new IllegalArgumentException(STRING_ERROR);
		
		this.message = message.toString();
		this.choices = new String[choices.size()];
		this.choices = choices.toArray(this.choices);
	}
	
	private static int numOfChoices(String s) {
		int ends = 0;
		int starts = 0;
		for (int i=0; i<s.length(); i++) {
			char c = s.charAt(i);
			if 		(c == CHOICE_END) ends++;
			else if (c == CHOICE_START) starts++;
		}
		if (ends != starts) return 0;
		else				return ends;
	}
	
	private int getIndexOf(String s) {
		for (int i=0; i<choices.length; i++)
			if (s.startsWith(choices[i])) return i;
		return NOT_FOUND;
	}
	
	private boolean unacceptable(String s, Vector<String> choices) {
		for (String choice: choices)
			if (choice.startsWith(s) || s.startsWith(choice)) return true;
		return false;
	}
	
	public int choose() {
		int choice = -1;
		while (choice == NOT_FOUND)
			choice = getIndexOf(InputDati.readString(message));
		return choice;
	}

}
