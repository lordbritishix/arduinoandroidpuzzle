package com.arduinoserver.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

public class ArduinoServer {
	public static final String HOST = "192.168.1.4";
	public static final int PORT = 9100;
	private ServerSocket serverSocket;

	public void connect() throws IOException {
		System.out.println("Starting ArduinoServer at: " + HOST + ":" + PORT);
	    serverSocket = new ServerSocket(PORT);
		System.out.println("Waiting for connection");

		final List<PrintWriter> sockets = new ArrayList<PrintWriter>();
		
		while(true) {
		    final Socket clientSocket = serverSocket.accept();
		    
		    Thread t = new Thread(new Runnable() {
				@Override
				public void run() {
				    PrintWriter out = null;
				    BufferedReader in = null;
					try {
						out = new PrintWriter(clientSocket.getOutputStream(), true);
					    in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
						    
						System.out.println("Connection with client established: " + clientSocket.getLocalAddress().getHostName());
				
					    String inputLine = "";
					    
						out.println("ack");
					    
					    sockets.add(out);
					    
					    while ((inputLine = in.readLine()) != null) {
					    	System.out.println("Message from client: " + inputLine);
					    	
					    	//Broadcast
					    	for (PrintWriter writer : sockets) {
					    		String testData = getDataForTestData(inputLine);
					    		
					    		if (testData != null) {
					    			writer.println(testData);	
					    		}
					    	}
					    }
					    
				    	System.out.println("Connection closed!");
	
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
					    try {
						    out.close();
							in.close();
						    clientSocket.close();
						    sockets.remove(out);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
				}
			});
		    
		    t.start();
		}
	}
	
	private String getDataForTestData(String str) {
		JSONObject object = JSONObject.fromObject(str);
		
		if ((object != null) && (object.optBoolean("test"))) {
			return object.toString();
		}
		else {
			return null;
		}
	}
}
