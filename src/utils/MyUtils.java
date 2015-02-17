package utils;
import java.util.Vector;

public final class MyUtils {
	
	public static int[] parseIntArray(Vector<Integer> intVect) {
		int[] intArray = new int[intVect.size()];
		for (int i=0; i<intVect.size(); i++) intArray[i] = intVect.elementAt(i);
		return intArray;
	}
	
	public static String[] parseStringArray(int[] intArray) {
		String[] stringArray = new String[intArray.length];
		for (int i=0; i<intArray.length; i++)
			stringArray[i] = "" + intArray[i];
		return stringArray;
	}
	
	public static String[] parseStringArray(Object[] anyArray) {
		String[] stringArray = new String[anyArray.length];
		for (int i=0; i<anyArray.length; i++)
			stringArray[i] = anyArray[i].toString();
		return stringArray;
	}

}
