package cs520.module6.L2_networking;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.net.URLConnection;

public class P02_URLConnectionDemo {

	public static void main(String[] args) {

		BufferedInputStream inputStream = null;
		FileOutputStream outputStream = null;
		
		try {
			URL url = new URL("http://www.bu.edu/csmet/files/2012/01/CS-520-OL-Spring-2-2012.pdf");
			URLConnection urlConnection = url.openConnection();

			// Get the content type and the content size
			String contentType = urlConnection.getContentType();
			int contentSize = urlConnection.getContentLength();
			System.out.printf("Content Type:%s, Content Size:%d\n", contentType, contentSize);

			// Create an input stream to retrieve the web resource
			inputStream = new BufferedInputStream(urlConnection.getInputStream());
			
			// Create an output stream that will allow us to create a file
			outputStream = new FileOutputStream("c:/temp/cs520.pdf");
			
			// Read one byte at a time and write to the output file
			int readByte = 0;
			while ((readByte = inputStream.read()) != -1) {
				outputStream.write(readByte);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// Close streams
				if (inputStream != null) inputStream.close();
				if (outputStream != null) outputStream.close();
			} catch (Exception e2) {
				// Exception when trying to close streams
				e2.printStackTrace();
			}
		}
	}
}
