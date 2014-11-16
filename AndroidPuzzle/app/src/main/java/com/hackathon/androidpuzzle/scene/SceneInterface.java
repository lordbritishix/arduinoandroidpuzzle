package com.hackathon.androidpuzzle.scene;

import org.json.JSONException;

/**
 * Created by MacbookAir on 14-11-08.
 */
public interface SceneInterface {
    public static final int YES = 0x1;
    public static final int NO = 0x2;

    boolean isAnswerCorrect(String input) throws JSONException;

}
