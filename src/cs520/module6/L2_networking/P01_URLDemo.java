package cs520.module6.L2_networking;

import java.net.*;
import java.io.*;

public class P01_URLDemo {

	public static void main(String[] args) {
		InputStreamReader inputStream = null;
		BufferedReader reader = null;
		
		try {
			String page = "https://www.bu.edu/met/degrees-certificates/ms-computer-information-systems?c=webappdev";
			URL urlObject = new URL(page);

			System.out.printf("Protocol (%s), Host (%s)\n", 
				urlObject.getProtocol(), 
				urlObject.getHost());

			System.out.printf("Port (%s), Default Port (%s)\n", 
				urlObject.getPort(), 
				urlObject.getDefaultPort());

			System.out.printf("Path (%s), Query (%s), File (%s)\n", 
				urlObject.getPath(), 
				urlObject.getQuery(),
				urlObject.getFile());

			// Read the data
			StringBuffer buffer = new StringBuffer();
			String inputLine;

			inputStream = new InputStreamReader(urlObject.openStream());
			reader = new BufferedReader(inputStream);
			while ((inputLine = reader.readLine()) != null) {
				buffer.append(inputLine + "\n");
			}

			// Display the first 1,000 characters of the HTML
			System.out.println();
			System.out.println(buffer.toString().substring(0, 1000));

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (inputStream != null) {
					inputStream.close();
				}
				if (reader != null) {
					reader.close();
				}
			} catch (Exception e2) {
				// Exception when trying to close stream/reader
				e2.printStackTrace();
			}
		}
	}
}