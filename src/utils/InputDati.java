package utils;
import java.util.*;


public final class InputDati {
	  private static Scanner reader = createScanner();
	  
	  private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non e' nel formato corretto";
	  private final static String ERRORE_MINIMO= "Attenzione: e' richiesto un valore maggiore o uguale a ";
	  private final static String ERRORE_STRINGA_VUOTA= "Attenzione: non hai inserito alcun carattere";
	  private final static String ERRORE_MASSIMO= "Attenzione: e' richiesto un valore minore o uguale a ";
	  private static boolean showErrMessage = true;
	  
	  private static Scanner createScanner () {
	   Scanner created = new Scanner(System.in);
	   created.useDelimiter(System.getProperty("line.separator"));
	   return created;
	  }
	  
	  public static int readInteger(String message, int min, int max) {
		   boolean finito = false;
		   int value = 0;
		   do {
				 value = readInt(message);
				 if (value >= min && value<= max)
				  finito = true;
				 else
				  if (value < min) {
					 if (showErrMessage) System.out.println(ERRORE_MINIMO + min);
				  	 } else
				  		 if (showErrMessage) System.out.println(ERRORE_MASSIMO + max); 
		    } while (!finito);
		     
		   return value;
	  }
	  
	  public static String readString (String message) {
		  System.out.print(message);
		  return reader.next();
	  }
	  
	  public static String readStringNoEmpty(String message) {
		   boolean finish=false;
		   String str = null;
		   do {
				 str = readString(message);
				 str = str.trim();
				 if (str.length() > 0)
					 finish=true;
				 else
					 if (showErrMessage) System.out.println(ERRORE_STRINGA_VUOTA);
		   } while (!finish);
		   
		   return str;
		  }
		  
	  public static int readInt (String messaggio) {
		   boolean finish = false;
		   int value = 0;
		   do {
			     System.out.print(messaggio);
			     if (reader.hasNextInt())
			      {
			       value = reader.nextInt();
			       finish = true;
			      } else {
			    	  if (showErrMessage) System.out.println(ERRORE_FORMATO);
			    	  	reader.next();
			      }
		   } while (!finish);
		   
		   return value;
	 }
}
