package com.arduinoserver;

import java.io.IOException;

import com.arduinoserver.server.ArduinoServer;

public class Main {
	public static void main(String[] args) {
//		ArduinoListener listener = new ArduinoListener();
//		System.out.println("Start: ");
//
//		Thread t=new Thread() {
//			public void run() {
//				//the following line will keep this app alive for 1000 seconds,
//				//waiting for events to occur and responding to them (printing incoming messages to console).
//				try {Thread.sleep(1000000);} catch (InterruptedException ie) {}
//			}
//		};
//		t.start();
//
//		listener.initialize();
//		
//		System.out.println("End: ");

		ArduinoServer server = new ArduinoServer();

		try {
			server.connect();
		} catch (IOException e) {
			System.out.println("Unable to start server: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
