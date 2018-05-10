package org.tools.kyo.mytomatoclock.feature;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            int id = item.getItemId();
            if (id == R.id.navigation_home) {
                mTextMessage.setText(R.string.title_home);
                return true;
            } else if (id == R.id.navigation_dashboard) {
                mTextMessage.setText(R.string.title_dashboard);
                return true;
            } else if (id == R.id.navigation_notifications) {
                mTextMessage.setText(R.string.title_notifications);
                return true;
            }
            return false;
        }
    };
    private TextView textTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        textTimer = (TextView) findViewById(R.id.txtTimer);
        Button button = (Button) findViewById(R.id.btnStart);
        final CountDownTimer countDownTimer = new CountDownTimer(60000 * 25-1, 1000) {

            public void onTick(long millisUntilFinished) {
                textTimer.setText(millisUntilFinished / 60000 + ":" + millisUntilFinished % 60000 / 1000);
            }

            public void onFinish() {
                textTimer.setText("00:00");
            }
        };
        final CountDownHandler countDownHandler = new CountDownHandler(countDownTimer);

        button.setOnClickListener( new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                countDownHandler.Toggle();
                if (countDownHandler.isTimerStart())
                    ((Button)view).setText("Stop");
                else
                    ((Button)view).setText("Start");
            }
        });

    }

}
