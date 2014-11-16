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

public class Scene3Activity extends Activity implements SceneInterface{
    String hint = "Match the colours in the screen";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scene3);

        Button b3 = (Button)findViewById(R.id.button3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    isAnswerCorrect("{\"r\" : 0, \"g\" : 0, \"b\" : 0}");
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
        getMenuInflater().inflate(R.menu.menu_scene3, menu);
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

        int rValue = answer.getInt("r");
        int gValue = answer.getInt("g");
        int bValue = answer.getInt("b");

        if(rValue == 000 && gValue == 000 && bValue == 000){
            setResult(SceneInterface.YES);
            finish();
            return true;
        }
        else {
            return false;
        }
    }
}
