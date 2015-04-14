package utils;
import java.util.*;
public final class InputDati 
{
	  private static Scanner lettore = creaScanner();
	  
	  private final static String ERRORE_FORMATO = "Attenzione: il dato inserito non e' nel formato corretto";
	  private final static String ERRORE_MINIMO= "Attenzione: e' richiesto un valore maggiore o uguale a ";
	  private final static String ERRORE_STRINGA_VUOTA= "Attenzione: non hai inserito alcun carattere";
	  private final static String ERRORE_MASSIMO= "Attenzione: e' richiesto un valore minore o uguale a ";
	  private final static String MESSAGGIO_AMMISSIBILI= "Attenzione: i caratteri ammissibili sono: ";
	  private final static String ERRORE_POSITIVO = "Attenzione: � richiesto un valore positivo";
	  
	  private final static char RISPOSTA_SI='S';
	  private final static char RISPOSTA_NO='N';
	  
	  private final static String ELEMENTO_MENU = "{%d: %s} ";
	  private final static String ELEMENTO_MENU_VERT = "[%d] %s\n";
	  private final static int RIGA_MENU_MAX_LENGTH = 140;

	  
	  private final static int DEFAULT_MENU_OFFSET = 1;

	  private static boolean mostraMessErr = true;
	  
	  private static Scanner creaScanner ()
	  {
	   Scanner creato = new Scanner(System.in);
	   creato.useDelimiter(System.getProperty("line.separator"));
	   return creato;
	  }
	  
	  public static int readInteger(String messaggio, int minimo, int massimo)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiIntero(messaggio);
	     if (valoreLetto >= minimo && valoreLetto<= massimo)
	      finito = true;
	     else
	      if (valoreLetto < minimo){
	    	 if (mostraMessErr) System.out.println(ERRORE_MINIMO + minimo);
	      	 }
	      else
	    	 if (mostraMessErr) System.out.println(ERRORE_MASSIMO + massimo); 
	    } while (!finito);
	     
	   return valoreLetto;
	  }
	  
	  public static String readString (String messaggio)
	  {
		  System.out.print(messaggio);
		  return lettore.next();
	  }
	  
	  public static String readStringNoEmpty(String messaggio)
	  {
	   boolean finito=false;
	   String lettura = null;
	   do
	   {
		 lettura = readString(messaggio);
		 lettura = lettura.trim();
		 if (lettura.length() > 0)
		  finito=true;
		 else
		  if (mostraMessErr) System.out.println(ERRORE_STRINGA_VUOTA);
	   } while (!finito);
	   
	   return lettura;
	  }
	  
	  
	  // ============================================= \\
	  
	  public static char leggiChar (String messaggio)
	  {
	   boolean finito = false;
	   char valoreLetto = '\0';
	   do
	    {
	     System.out.print(messaggio);
	     String lettura = lettore.next();
	     if (lettura.length() > 0)
	      {
	       valoreLetto = lettura.charAt(0);
	       finito = true;
	      }
	     else
	      {
	      if (mostraMessErr) System.out.println(ERRORE_STRINGA_VUOTA);
	      }
	    } while (!finito);
	   return valoreLetto;
	  }
	  
	  public static char leggiUpperChar (String messaggio, String ammissibili)
	  {
	   boolean finito = false;
	   char valoreLetto = '\0';
	   do
	   {
	    valoreLetto = leggiChar(messaggio);
	    valoreLetto = Character.toUpperCase(valoreLetto);
	    ammissibili = ammissibili.toUpperCase();
	    if (ammissibili.indexOf(valoreLetto) != -1)
		 finito  = true;
	    else
	     if (mostraMessErr) System.out.println(MESSAGGIO_AMMISSIBILI + ammissibili);
	   } while (!finito);
	   return valoreLetto;
	  }
	  
	  
	  public static int leggiIntero (String messaggio)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     System.out.print(messaggio);
	     if (lettore.hasNextInt())
	      {
	       valoreLetto = lettore.nextInt();
	       finito = true;
	      }
	     else
	      {
	       if (mostraMessErr) System.out.println(ERRORE_FORMATO);
	       //String daButtare = 
	       lettore.next();
	      }
	    } while (!finito);
	   return valoreLetto;
	  }

	  public static int leggiInteroPositivo(String messaggio)
	  {
		  return leggiInteroConMinimo(messaggio,1);
	  }
	  
	  public static int leggiInteroNonNegativo(String messaggio)
	  {
		  return leggiInteroConMinimo(messaggio,0);
	  }
	  
	  
	  public static int leggiInteroConMinimo(String messaggio, int minimo)
	  {
	   boolean finito = false;
	   int valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiIntero(messaggio);
	     if (valoreLetto >= minimo)
	      finito = true;
	     else
	      if (mostraMessErr) System.out.println(ERRORE_MINIMO + minimo);
	    } while (!finito);
	     
	   return valoreLetto;
	  }

	  

	  
	  public static double leggiDouble (String messaggio)
	  {
	   boolean finito = false;
	   double valoreLetto = 0;
	   do
	    {
	     System.out.print(messaggio);
	     if (lettore.hasNextDouble())
	      {
	       valoreLetto = lettore.nextDouble();
	       finito = true;
	      }
	     else
	      {
	       if (mostraMessErr) System.out.println(ERRORE_FORMATO);
	       //String daButtare =
	       lettore.next();
	      }
	    } while (!finito);
	   return valoreLetto;
	  }
	 
	  public static double leggiDouble (String messaggio, double minimo)
	  {
	   boolean finito = false;
	   double valoreLetto = 0;
	   do
	    {
	     valoreLetto = leggiDouble(messaggio);
	     if (valoreLetto >= minimo)
	      finito = true;
	     else
	      if (mostraMessErr) System.out.println(ERRORE_MINIMO + minimo);
	    } while (!finito);
	     
	   return valoreLetto;
	  }
	  
	  public static double leggiDoublePositivo(String messaggio) {
		  boolean finito = false;
		   double valoreLetto = 0;
		   do
		    {
		     valoreLetto = leggiDouble(messaggio);
		     if (valoreLetto > 0)
		      finito = true;
		     else
		      if (mostraMessErr) System.out.println(ERRORE_POSITIVO);
		    } while (!finito);
		     
		   return valoreLetto;
	  }

	  
	  public static boolean yesOrNo(String messaggio)
	  {
		  String mioMessaggio = messaggio + "("+RISPOSTA_SI+"/"+RISPOSTA_NO+")";
		  char valoreLetto = leggiUpperChar(mioMessaggio,String.valueOf(RISPOSTA_SI)+String.valueOf(RISPOSTA_NO));
		  
		  if (valoreLetto == RISPOSTA_SI)
			return true;
		  else
			return false;
	  }
	  	  
	  public static byte textMenu(String msg, String ... scelte)
	  {
		  StringBuffer sb = new StringBuffer();
		  for (int i=0; i<scelte.length; i++) {
			  String nuovoElemento = String.format(ELEMENTO_MENU, i, scelte[i]);
			  int lunghezzaRiga = (sb.length() % RIGA_MENU_MAX_LENGTH) + nuovoElemento.length();
			  if (lunghezzaRiga >= RIGA_MENU_MAX_LENGTH) sb.append("\n");
			  sb.append(nuovoElemento);
		  }
		  System.out.print(sb + "\n");
		  return (byte) readInteger(msg, 0, scelte.length - 1);
	  }
	  
	  public static byte textMenu(String[] scelte, String msg)
	  {
		  StringBuffer sb = new StringBuffer();
		  for (int i=0; i<scelte.length; i++) {
			  String nuovoElemento = String.format(ELEMENTO_MENU, i, scelte[i]);
			  int lunghezzaRiga = (sb.length() % RIGA_MENU_MAX_LENGTH) + nuovoElemento.length();
			  if (lunghezzaRiga >= RIGA_MENU_MAX_LENGTH) sb.append("\n");
			  sb.append(nuovoElemento);
		  }
		  System.out.print(sb + "\n");
		  return (byte) readInteger(msg, 0, scelte.length - 1);
	  }
	  
	  public static byte textMenu(String[] scelte, String msg, byte offset)
	  {    // ritorna comunque un val da 0 a length-1!
		  StringBuffer sb = new StringBuffer();
		  for (int i=0; i<scelte.length; i++) {
			  String nuovoElemento = String.format(ELEMENTO_MENU, i+offset, scelte[i]);
			  int lunghezzaRiga = (sb.length() % RIGA_MENU_MAX_LENGTH) + nuovoElemento.length();
			  if (lunghezzaRiga >= RIGA_MENU_MAX_LENGTH) sb.append("\n");
			  sb.append(nuovoElemento);
		  }
		  System.out.print(sb + "\n");
		  return (byte) ( readInteger(msg, offset, scelte.length + offset-1) - offset );
	  }
	  
	  public static byte textMenuVert(String[] scelte, String msg)
	  {
		  for (int i=0; i<scelte.length; i++)
			  System.out.print(String.format(ELEMENTO_MENU_VERT, i, scelte[i]));
		  return (byte) readInteger(msg, 0, scelte.length - 1);
	  }
	  
	  public static byte textMenuVert(String[] scelte, String msg, byte offset)
	  {    // ritorna comunque un val da 0 a length-1!
		  for (int i=0; i<scelte.length; i++)
			  System.out.print(String.format(ELEMENTO_MENU_VERT, i+offset, scelte[i]));
		  return (byte) ( readInteger(msg, offset, scelte.length + offset-1) - offset );
	  }
	  
	  public static byte textMenuVert(String[] scelte, String msg, int offset)
	  {    // ritorna comunque un val da 0 a length-1!
		  for (int i=0; i<scelte.length; i++)
			  System.out.print(String.format(ELEMENTO_MENU_VERT, i+offset, scelte[i]));
		  return (byte) ( readInteger(msg, offset, scelte.length + offset-1) - offset );
	  }
	  
	  public static void noMessErr() {
		  mostraMessErr = false;
	  }
	  
	  public static void mostraMessErr() {
		  mostraMessErr = true;
	  }
	  
	  public static <Q> Q selectElementFrom(Q[] array, String msg) {
		  return array[textMenuVert( MyUtils.parseStringArray(array), msg, DEFAULT_MENU_OFFSET )];
	  }

}
