package com.hackathon.androidpuzzle;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ArduinoListener extends Service {
    Socket socket;
    PrintWriter out;
    BufferedReader in;
    public ArduinoListener() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("@@@@@@@@@@@@@", "Starting service!");


        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
            try {
                Log.i("@@@@@@@@@@@@", "Connecting");
                socket = new Socket("192.168.1.4", 9100);
                out = new PrintWriter(socket.getOutputStream(), true);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                Log.i("@@@@@@@@@@@@", "Connected");

            } catch (IOException e) {
                Log.i("@@@@@@@@@@@@", e.getMessage());
                System.out.println("@@@@@@@@@@@@@@@" + e.getMessage());
                e.printStackTrace();
            }

            String input = "";
            try {
                while ((input = in.readLine()) != null) {
                    Log.i("@@@@@@@@@@@@@", input);
                    Intent intent = new Intent("arduino_event");
                    // You can also include some extra data.
                    intent.putExtra("message", input);
                    LocalBroadcastManager.getInstance(getApplicationContext()).sendBroadcast(intent);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            }
        });
        t.start();

        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
