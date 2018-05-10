package org.tools.kyo.mytomatoclock.feature;

import android.os.CountDownTimer;

/**
 * Created by kyo.lai82 on 5/10/2018.
 */

class CountDownHandler {
    private final CountDownTimer _countDownTimer;
    private boolean _isStart = false;

    public CountDownHandler(CountDownTimer countDownTimer) {
        _countDownTimer = countDownTimer;
    }

    public void Toggle() {
        if (_isStart){
            _countDownTimer.cancel();
            _isStart = false;
        } else {
            _countDownTimer.start();
            _isStart = true;
        }
    }

    public boolean isTimerStart(){
        return _isStart;
    }
}
