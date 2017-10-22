package com.example.vgpierce.supertictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button sButton = (Button) findViewById(R.id.startButton_id);
        final Button oButton = (Button) findViewById(R.id.optionsButton_id);
        final Button eButton = (Button) findViewById(R.id.quitButton_id);

        sButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //Change to gameBoard Activity
                Intent intent = new Intent(v.getContext(), GameboradActivity.class);
                startActivity(intent);
            }
        });
        oButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), OptionsActivity.class);
                startActivity(intent);
            }
        });
        eButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finishAndRemoveTask ();
            }
        });
    }

}
