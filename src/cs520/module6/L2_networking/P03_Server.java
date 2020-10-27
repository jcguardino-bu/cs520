package cs520.module6.L2_networking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class P03_Server {

	private static boolean listening = true;
	private static InputStreamReader inputStream = null;
	private static BufferedReader reader = null;
	private static PrintWriter writer = null;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			// Instantiate the ServerSocket
			serverSocket = new ServerSocket(8080);
			
			// Listen for client connections
			while (listening) {
				socket = serverSocket.accept();
				processConnection(socket);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close Socket and ServerSocket 
			try {
				if (socket != null) socket.close();
				if (serverSocket != null) serverSocket.close();
			} catch (Exception e2) {
				// Exception when trying to close Socket and ServerSocket
				e2.printStackTrace();
			}
		}
	}

	public static void processConnection(Socket socket) throws Exception {
		try {
			System.out.println("Received connection from " + socket.getRemoteSocketAddress());
	
			// Create a reader from the socket's input stream
			inputStream = new InputStreamReader(socket.getInputStream());
			reader = new BufferedReader(inputStream);
	
			// Create a writer to the socket's output stream
			writer = new PrintWriter(socket.getOutputStream(), true);
	
			// Process the input from the client and write the response
			String input = reader.readLine();
			String response = new StringBuffer(input).reverse().toString();

			// Send back acknowledgment
			writer.println("ACK :" + response);
	
			// Check whether the server must terminate
			if (input.equalsIgnoreCase("quit")) {
				listening = false;
			}
		} catch (Exception e) {
			// Throw the exception back to main()
			throw e;
		} finally {
			try {
				// Close the writer and reader
				if (writer != null) writer.close();
				if (reader != null) reader.close();
			} catch (Exception e2) {
				// Exception when trying to close Socket and ServerSocket
				e2.printStackTrace();
			}
		}
	}
}
