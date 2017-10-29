package com.example.vgpierce.supertictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;


/**
 * Created by vgpierce on 10/21/17.
 */



public class GameboardActivity extends Activity {
    draw drawView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawView = new draw(this);
        drawView.setBackgroundColor(Color.WHITE);
        setContentView(drawView);
        }
    }

