package org.qe.hawkular.util;

/**
 * @author Armine Hovsepyan - ahovsepy@redhat.com
 */

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;


public class BrowsersAndOs {

	public static List<String> readBrowsersAndOsFromFile() {

		List<String> browsersList = new ArrayList<String>();
		Properties prop = new Properties();
		InputStream input;

		try {
			
			input = new FileInputStream("src/test/resources/browserAndOs.properties");
			prop.load(input);
			
			System.out.println("browsersAndOs.properties Loaded Succesfully");

			Set<String> browsers = prop.stringPropertyNames();
			for (String browser : browsers) {
				String browserVersionOsProperty = prop.getProperty(browser);

				browsersList.add(browserVersionOsProperty);

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return browsersList;
	}
	
	public static void main(String[] args) {
		readBrowsersAndOsFromFile();
	}

}
