package utils;

public final class MyMath {

	public static int gcd(int n1, int n2) { // max comun divisore
		
		int min = Math.abs( Math.min(n1, n2) );
		int max = Math.abs( Math.max(n1, n2) );
		
		if (min == 0) { return 1; }
		
		int r;
		
		do {
			r = max % min;
			max = min;
			min = r;
		} while (r != 0);
		
		return max;
	}
	
	public static int lcm (int n1, int n2) { // min comune multiplo
		
		n1 = Math.abs(n1);
		n2 = Math.abs(n2);
		int maxDivisor = gcd(n1, n2);		
		
		return n1 * (n2 / maxDivisor);
	}
	
	public static int absMax(int a, int b) { // restituisce il maggiore in valore assoluto, ma col segno originale
		
		if (Math.abs(a) > Math.abs(b))  return a;
		else							return b;
	}
	
	public static int decimalLenght(int n) {
		
		int length = 0;
		while (n != 0) {
			n = (int) n/10;
			length++;
		}
		return length;
	}
	
	public static int numberOfDigits(int n, int base) {
		
		int length = 0;
		while (n != 0) {
			n = (int) n/base;
			length++;
		}
		return length;
	}

}
