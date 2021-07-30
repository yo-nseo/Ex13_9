package kr.hs.emirim.ohyoonseo.ex13_9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {
    SeekBar seek1, seek2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Thread 기본");
        seek1 = findViewById(R.id.seek1);
        seek2 = findViewById(R.id.seek2);
        Button btnStart = findViewById(R.id.btn_start);

        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Thread thread1 = new Thread() {
                    @Override
                    public void run() {
                        for (int i = seek1.getProgress(); i < 100; i+=2) {
                            seek1.setProgress(seek1.getProgress() + 2);
                            SystemClock.sleep(100);
                        }
                    }
                };

                thread1.start();

                Thread thread2 = new Thread() {
                    @Override
                    public void run() {
                        for (int i = seek2.getProgress(); i < 100; i++) {
                            seek2.setProgress(seek2.getProgress() + 1);
                            SystemClock.sleep(100);
                        }
                    }
                };
                thread2.start();
            }
        });
    }
}