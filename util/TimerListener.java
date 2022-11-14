package net.snakkze.risk1914.util;

public interface TimerListener {

    void onTick(int time);
    void onPause(int time);
    void onResume(int time);
    void onStop();

}
