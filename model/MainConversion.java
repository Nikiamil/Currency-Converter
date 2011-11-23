package model;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.StringTokenizer;


public class MainConversion {
  
  public double doConversion (String s1, String s2, String buf) {
    
    double sum,val;
    sum = -1;
    int b = 4;
    try {
    	
    	/* Arxi toy kwdika gia lipsi tis apantisis apo to google.
    	 * Epeita tin kanoume parsing
    	 */
    	if (s1.equals(s2)){
    		sum = Double.parseDouble(buf);
    		return(sum);
    	}
    	
    	val = Double.parseDouble(buf);
    	
    	String googleCv = "http://www.google.com/ig/calculator?hl=en&q=";
    	URL convert = new URL(googleCv + val + s1+ "=?" + s2);
    	BufferedReader in = new BufferedReader(new InputStreamReader(convert.openStream()));
    	String answer = in.readLine();
    	in.close();
    	
		StringTokenizer str = new StringTokenizer(answer);
		int a = str.countTokens();
		
		String arr[] = new String[a];
		

		for (int i=0; i<a; i++){
			arr[i] = str.nextToken();
		}
		
		/*To apotelesma pou mas endiaferei mporei na vrisketai sti thesi 3 i 4 tou pinaka
		 * Stin thesi 3 vrisketai otan to onoma tou nomismatos apoteleitai apo
		 * 1 leksi (px Euros) enw sti thesi 4 apo 2 lekseis (px British Pounds)
		 */
		
		if(s1.equals("EUR")){
			b = 3;
		}
		
		String total = arr[b].substring(1);
		
		/* Dystyxws i google epistrefei enan mi anagnwrisimo xaraktira
		 * Gi'ayto to logo "spame" to teliko apotelesma se dekadiko
		 * kai akeraio meros, afairoume olous tous eidikous xaraktires apo to
		 * akeraio kai to ksanaenwnoume
		 */
		
		StringTokenizer str2 = new StringTokenizer(total, ".");
		
		int c = str2.countTokens();
		String sides[] = new String[c];
		
		for(int j =0; j<c; j++){
		sides[j] = str2.nextToken();
		}
		
		sides[0] = sides[0].replaceAll("\\D","");
		
		
		if (c == 1){
			total = (""+ sides[0]);
		}
		else {
			total = ("" + sides[0] + "." + sides[1]);
		}
		
		sum = Double.parseDouble(total);

    	}
    	catch (MalformedURLException mue) {
    	return(-2);
    	}
    	catch (IOException ioe) {
    	return(-2);
    	} 
   
    catch(NumberFormatException nf){
        
        return(-1);
    }
	return(sum);

  }
}