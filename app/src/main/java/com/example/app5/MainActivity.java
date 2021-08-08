package com.example.app5;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int counter = 0;
    Button startBtn;
    Button stopBtn;
    TextView txtcounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startBtn = (Button) findViewById(R.id.btnstrt);
        stopBtn = (Button) findViewById(R.id.btnstop);
        txtcounter = (TextView) findViewById(R.id.txtcntr);
        final CountDownTimer[] timecount = {null};
        startBtn.setOnClickListener(v -> {
            timecount[0] = new CountDownTimer(1000000, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    counter++;
                    txtcounter.setText(String.valueOf(counter));
                }

                @Override
                public void onFinish() {
                }
            };
            timecount[0].start();
        });

        stopBtn.setOnClickListener(v -> {
            timecount[0].cancel();
            txtcounter.setText(String.valueOf(counter));
            counter = 0;
        });
    }
}
