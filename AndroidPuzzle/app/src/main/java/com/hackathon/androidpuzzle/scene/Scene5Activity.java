package com.hackathon.androidpuzzle.scene;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.hackathon.androidpuzzle.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Scene5Activity extends Activity implements SceneInterface{
    String hint = "Enter the Error#: _ _ _ Sleep not found";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene5);

        Button b5 = (Button)findViewById(R.id.button5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    isAnswerCorrect("{\"num1\" : 4, \"num2\" : 0, \"num3\" : 4}");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("arduino_event"));
    }

    private BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra("message");
            try {
                isAnswerCorrect(message);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scene5, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean isAnswerCorrect(String input) throws JSONException {
        JSONObject answer = new JSONObject(input);

        int num1 = answer.getInt("num1");
        int num2 = answer.getInt("num2");
        int num3 = answer.getInt("num3");

        if(num1 == 4 && num2 == 0 && num3 == 4) {
            setResult(SceneInterface.YES);
            finish();
            return true;
        }
        else {
            return false;
        }
    }
}
