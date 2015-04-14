package utils;

import java.util.Random;

public final class NumeriCasuali {
	
	private static Random estrattore = new Random();
	
	public static int estraiIntero(int min, int max)
	{
		 int range = max + 1 - min;
		 int casuale = estrattore.nextInt(range);
		 return casuale + min;
	}
	
	public static int estraiIntero(int max)
	{
		 int range = max;
		 int casuale = estrattore.nextInt(range);
		 return casuale;
	}
	
	public static double estraiDouble() {
		return estrattore.nextDouble();
	}

}
