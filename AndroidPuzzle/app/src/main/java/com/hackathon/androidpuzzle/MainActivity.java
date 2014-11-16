package com.hackathon.androidpuzzle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.hackathon.androidpuzzle.scene.FinalSceneActivity;
import com.hackathon.androidpuzzle.scene.Scene1Activity;
import com.hackathon.androidpuzzle.scene.Scene2Activity;
import com.hackathon.androidpuzzle.scene.Scene3Activity;
import com.hackathon.androidpuzzle.scene.Scene4Activity;
import com.hackathon.androidpuzzle.scene.Scene5Activity;
import com.hackathon.androidpuzzle.scene.SceneInterface;


public class MainActivity extends Activity {
    Class activeScene;
    public static final int MAIN_CODE = 0x11111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (activeScene == null) {
            Intent intent = new Intent(this, Scene1Activity.class);
            startActivityForResult(intent, MAIN_CODE);
            activeScene = Scene1Activity.class;
        }

        startService(new Intent(this, ArduinoListener.class));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if ((requestCode == MAIN_CODE) && (resultCode == SceneInterface.YES)) {
            if (activeScene == Scene1Activity.class) {
                Intent intent = new Intent(this, Scene2Activity.class);
                activeScene = Scene2Activity.class;
                startActivityForResult(intent, MAIN_CODE);
            }
            else if (activeScene == Scene2Activity.class) {
                Intent intent = new Intent(this, Scene3Activity.class);
                activeScene = Scene3Activity.class;
                startActivityForResult(intent, MAIN_CODE);
            }
            else if (activeScene == Scene3Activity.class) {
                Intent intent = new Intent(this, Scene4Activity.class);
                activeScene = Scene4Activity.class;
                startActivityForResult(intent, MAIN_CODE);
            }
            else if (activeScene == Scene4Activity.class) {
                Intent intent = new Intent(this, Scene5Activity.class);
                activeScene = Scene5Activity.class;
                startActivityForResult(intent, MAIN_CODE);
            }
            else if (activeScene == Scene5Activity.class) {
                Intent intent = new Intent(this, FinalSceneActivity.class);
                activeScene = FinalSceneActivity.class;
                startActivityForResult(intent, MAIN_CODE);
            }
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
