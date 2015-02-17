package utils;

import java.util.Vector;

public class StringColumns {

	private static final char DEFAULT_COLUMN_SEPARATOR = '|';
	public static final char LIST_SEPARATOR = ';';
	
	private char separator;
	private int[] columnLengths;
	private String[] titles;
	private int size;
	
	public StringColumns (String[] titles, int[] columnLengths) {
		this(titles, columnLengths, DEFAULT_COLUMN_SEPARATOR);
	}
	
	public StringColumns (String[] titles, int[] columnLengths, char separator) throws IllegalArgumentException {
		if (titles.length != columnLengths.length) throw new IllegalArgumentException();
		this.size = titles.length;
		this.titles = titles;
		this.columnLengths = columnLengths;
		this.separator = separator;
	}
	
	public StringColumns (String[] titles, int length) {		
		this.size = titles.length;
		this.titles = titles;
		this.separator = DEFAULT_COLUMN_SEPARATOR;
		this.columnLengths = new int[size];
		for (int i=0; i<size; i++)
			this.columnLengths[i] = length;
	}
	
	public String columnRow(String ... elements) throws IllegalArgumentException {
		if (elements.length != size) throw new IllegalArgumentException();
		StringBuffer sb = new StringBuffer();
		sb.append(separator);
		for (int i=0; i<elements.length; i++)
			sb.append(BelleStringhe.ridimensionaCentrato(elements[i], columnLengths[i]) + separator);
		return sb.toString();
	}
	
	public String columnRow(String list) throws IllegalArgumentException {
		String[] elements = separate(list);
		if (elements.length != size) throw new IllegalArgumentException();
		return columnRow(elements);
	}
	
	public String presentation(String[] separatedLists) throws IllegalArgumentException {
		StringBuffer sb = new StringBuffer();
		sb.append(getTitles() + "\n");
		for (String s: separatedLists)
			sb.append(columnRow(s) + "\n");
		return sb.toString();
	}
	
	public String presentation(String[][] elementsArray) throws IllegalArgumentException {
		if (elementsArray[0].length != size) throw new IllegalArgumentException();
		StringBuffer sb = new StringBuffer();
		sb.append(getTitles() + "\n");
		for (int i=0; i<size; i++)
			sb.append(columnRow(elementsArray[i]) + "\n");
		return sb.toString();
	}
	
	public String getTitles() {
		return columnRow(titles);
	}
	
	private static String[] separate(String list) {
		Vector<String> vect = new Vector<String>();
		int index = list.indexOf(LIST_SEPARATOR);
		while (index >= 0) {
			vect.add(list.substring(0, index));
			list = list.substring(index+1);
			index = list.indexOf(LIST_SEPARATOR);
		}
		if (list.length() > 0) vect.add(list);
		String[] elements = new String[1];
		return vect.toArray(elements);
	}
	
}
