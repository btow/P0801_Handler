package com.example.samsung.p0801_handler;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.TimeUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    final String LOG_TAG = "myLogs";

    Handler handler;
    TextView tvInfo;
    Button btnStart, btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvInfo = (TextView) findViewById(R.id.tvInfo);
    }


    public void onClickButton(View view) {

        String message = "";

        switch (view.getId()) {

            case R.id.btnStart :

                for (int index = 1; index <= 10; index++) {

                    message = getString(R.string.download_files) + index;
                    //Это долгий процесс
                    downloadFile();
                    //Обновление TextView
                    tvInfo.setText(message);
                    //Запись в лог
                    Log.d(LOG_TAG, message);

                }
                break;
            case R.id.btnTest :
                message = "test";
                Log.d(LOG_TAG, message);
                break;
            default:
                break;
        }
    }

    private void downloadFile() {
        //Пауза 1 секунда
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
