package net.snakkze.risk1914.util;

import net.snakkze.risk1914.Main;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {

    private TimerListener timerListener;
    private boolean paused;
    private BukkitRunnable runnable;
    private int time;

    public Timer(TimerListener timerListener, int starttime) {
        this.timerListener = timerListener;
        paused = true;

        runnable = new BukkitRunnable() {
            @Override
            public void run() {
                if(!isPaused()) {
                    if(time == -1) {
                        timerListener.onStop();
                        cancel();
                        return;
                    }
                    timerListener.onTick(time);
                    time--;
                }
            }
        };
        runnable.runTaskTimer(Main.getPlguin(), 0, 20);
    }

    public int getTime() {
        return time;
    }

    public boolean isPaused() {
        return paused;
    }

    public void setPaused(boolean paused) {
        if(paused) {
            timerListener.onPause(time);
        } else {
            timerListener.onResume(time);
        }
        this.paused = paused;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
