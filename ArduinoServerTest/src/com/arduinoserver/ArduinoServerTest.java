package com.arduinoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

import net.sf.json.JSONObject;

import org.junit.Test;

public class ArduinoServerTest {
	public static final String HOST = "192.168.1.4";
	public static final int PORT = 9100;

	@Test
	public void testConnect() throws UnknownHostException, IOException {
	    Socket socket = new Socket(HOST, PORT);
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(socket.getInputStream()));
	    
	    out.write("Hello!");
	    
	    String input;
	    while ((input = in.readLine()) != null) {
	    	System.out.println("Client recieved: " + input);
	    }
	    
	    out.close();
	    in.close();
	    socket.close();
	}
	
	@Test
	public void sendScene1Solution() throws UnknownHostException, IOException {
	    Socket socket = new Socket(HOST, PORT);
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(socket.getInputStream()));

	    String input;
	    while ((input = in.readLine()) != null) {
	    	System.out.println("Client recieved: " + input);
	    	if (input.equals("ack")) {
	    		break;
	    	}
	    }
	    
		JSONObject object= new JSONObject();
		object.put("test", true);		
		object.put("isLightOn", true);
	    out.write(object.toString());
 
	    out.close();
	    in.close();
	    socket.close();
	}
	
	@Test
	public void sendScene1NoSolution() throws UnknownHostException, IOException {
	    Socket socket = new Socket(HOST, PORT);
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(socket.getInputStream()));

	    String input;
	    while ((input = in.readLine()) != null) {
	    	System.out.println("Client recieved: " + input);
	    	if (input.equals("ack")) {
	    		break;
	    	}
	    }
	    
		JSONObject object= new JSONObject();
		object.put("test", true);		
		object.put("isLightOn", false);
	    out.write(object.toString());
 
	    out.close();
	    in.close();
	    socket.close();
	}
	
	@Test
	public void sendScene2Solution() throws UnknownHostException, IOException {
	    Socket socket = new Socket(HOST, PORT);
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(socket.getInputStream()));

	    String input;
	    while ((input = in.readLine()) != null) {
	    	System.out.println("Client recieved: " + input);
	    	if (input.equals("ack")) {
	    		break;
	    	}
	    }
	    
		JSONObject object= new JSONObject();
		object.put("test", true);		
		object.put("num1", 3);
		object.put("num2", 5);
		object.put("num3", 6);
	    out.write(object.toString());
 
	    out.close();
	    in.close();
	    socket.close();
	}

	@Test
	public void sendScene3Solution() throws UnknownHostException, IOException {
	    Socket socket = new Socket(HOST, PORT);
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(socket.getInputStream()));

	    String input;
	    while ((input = in.readLine()) != null) {
	    	System.out.println("Client recieved: " + input);
	    	if (input.equals("ack")) {
	    		break;
	    	}
	    }
	    
		JSONObject object= new JSONObject();
		object.put("test", true);		
		object.put("r", 0);
		object.put("g", 0);
		object.put("b", 0);
	    out.write(object.toString());
 
	    out.close();
	    in.close();
	    socket.close();
	}

	@Test
	public void sendScene4Solution() throws UnknownHostException, IOException {
	    Socket socket = new Socket(HOST, PORT);
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(socket.getInputStream()));

	    String input;
	    while ((input = in.readLine()) != null) {
	    	System.out.println("Client recieved: " + input);
	    	if (input.equals("ack")) {
	    		break;
	    	}
	    }
	    
		JSONObject object= new JSONObject();
		object.put("test", true);		
		object.put("num1", 1);
		object.put("num2", 0);
	    out.write(object.toString());
 
	    out.close();
	    in.close();
	    socket.close();
	}
	
	@Test
	public void sendScene5Solution() throws UnknownHostException, IOException {
	    Socket socket = new Socket(HOST, PORT);
	    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
	    BufferedReader in = new BufferedReader(
	        new InputStreamReader(socket.getInputStream()));

	    String input;
	    while ((input = in.readLine()) != null) {
	    	System.out.println("Client recieved: " + input);
	    	if (input.equals("ack")) {
	    		break;
	    	}
	    }
	    
		JSONObject object= new JSONObject();
		object.put("test", true);		
		object.put("num1", 4);
		object.put("num2", 0);
		object.put("num3", 4);		
	    out.write(object.toString());
 
	    out.close();
	    in.close();
	    socket.close();
	}


}
