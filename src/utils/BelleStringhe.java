package utils;

public final class BelleStringhe
{

 private final static String SPAZIO = " ";
 private final static String CORNICE = "---------------------------------------------------";
 private final static String ACAPO = "\n";
 private final static String ECC = "...";



 public static String incornicia (String s)
	{ 
	 StringBuffer res = new StringBuffer();
		
	 res.append(CORNICE+ACAPO);
	 res.append(s+ACAPO);
	 res.append(CORNICE+ACAPO);

 	 return res.toString();

  }

 
 public static String incolonna (String s, int larghezza)
	{
	 StringBuffer res = new StringBuffer(larghezza);
	 int numCharDaStampare = Math.min(larghezza,s.length());
	 res.append(s.substring(0, numCharDaStampare));
	 for (int i=s.length()+1; i<=larghezza; i++)
		res.append(SPAZIO);
	 return res.toString();
	}
 
 public static String ridimensiona(String s, int larghezza)
	{
	 StringBuffer res = new StringBuffer(larghezza);
	 int differenza = larghezza - s.length();
	 if (differenza < 0) {
		 res.append( s.substring(0, larghezza - ECC.length()) );
		 res.append(ECC);
	 }
	 else {
		 res.append(s);
		 for (int i=s.length(); i<larghezza; i++) res.append(SPAZIO);
	 }
	 
	 return res.toString();
	}
 
 public static String ridimensionaCentrato(String s, int larghezza)
	{
	 StringBuffer res = new StringBuffer(larghezza);
	 int differenza = larghezza - s.length();
	 if (differenza < 0) {
		 res.append( s.substring(0, larghezza - ECC.length()) );
		 res.append(ECC);
	 }
	 else {
		 int spaziPrima = (int) differenza/2;
		 int spaziDopo = (int) differenza/2 + differenza%2;
		 for (int i=0; i<spaziPrima; i++) res.append(SPAZIO);
		 res.append(s);
		 for (int i=0; i<spaziDopo; i++) res.append(SPAZIO);
	 }
	 
	 return res.toString();
	}
}

