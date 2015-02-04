package org.apache.http.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.omg.CORBA_2_3.portable.InputStream;


public class Test {

	 
	 
	public static String postURL(URL a_Url, String a_sParamsToPost)
	{
	      StringBuilder o_oSb = new StringBuilder();
	 
	      //recup du saut de ligne
	      String o_sLineSep = null;
	      try
	      {
	         o_sLineSep = System.getProperty("line.separator");
	      }
	      catch (Exception e)
	      {
	         o_sLineSep = "\n";
	      }
	 
	      try
	      {
	         HttpURLConnection o_oUrlConn = (HttpURLConnection) a_Url.openConnection();
	         o_oUrlConn.setRequestMethod("POST");
	         o_oUrlConn.setAllowUserInteraction(false);
	         //envoyer des params
	         o_oUrlConn.setDoOutput(true);
	 
	         //poster les params
	         PrintWriter o_oParamWriter = new PrintWriter(o_oUrlConn.getOutputStream());
	 
	         o_oParamWriter.print(a_sParamsToPost);
	         //fermer le post avant de lire le resultat ... logique
	         o_oParamWriter.flush();
	         o_oParamWriter.close();
	 
	         //Lire la reponse
	         InputStream  o_oResponse = (InputStream) o_oUrlConn.getInputStream();
	         BufferedReader o_oBufReader = new BufferedReader(new InputStreamReader(o_oResponse));
	         String sLine;
	 
	         while ((sLine = o_oBufReader.readLine()) != null)
	         {
	            o_oSb.append(sLine);
	            o_oSb.append(o_sLineSep);
	         }
	         //deconnection
	         o_oUrlConn.disconnect();
	      }
	      catch(ConnectException ctx)
	      {
	       
	        ctx.printStackTrace();
	      }
	      catch (Exception e)
	      {
	      
	         e.printStackTrace();
	      }
	     
	      return o_oSb.toString();
	    }

}
