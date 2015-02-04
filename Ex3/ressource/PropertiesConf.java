package ressource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.omg.CORBA_2_3.portable.InputStream;

public class PropertiesConf {
	public static String getProperties(String propertie){
		Properties prop = new Properties();
		FileInputStream input = null;
		String strRet = null;
		try {
			input = new FileInputStream("C:\\Users\\Guillaume\\Programmation\\WorkspaceJava\\Programmation_Concurrentiel_Ex3\\src\\ressource\\config.properties");
			prop.load(input);
			strRet = prop.getProperty(propertie);
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return strRet;
	}

}