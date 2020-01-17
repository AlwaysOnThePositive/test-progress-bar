package com.example.testprogressdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private String TAG = getClass().getSimpleName();

    private ProgressDialog pd;

    private int counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counter = 0;

        Button btnLeft = findViewById(R.id.btnLeft);
        btnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(MainActivity.this);
                pd.setTitle("Title");
                pd.setMessage("Message");
                pd.show();

                CountDownTimer countDownTimer = new CountDownTimer(5000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        Log.i(TAG, "onTick: cdt");
                        counter++;
                        pd.setMessage(String.valueOf(counter));
                    }

                    @Override
                    public void onFinish() {
                        Log.i(TAG, "onFinish: cdt");
                        pd.dismiss();
                    }
                };
                countDownTimer.start();
            }
        });

    }
}
