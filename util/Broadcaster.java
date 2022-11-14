package net.snakkze.risk1914.util;

import net.snakkze.risk1914.Main;
import org.bukkit.Bukkit;

public class Broadcaster {

    private static int onlinePlayers = Bukkit.getOnlinePlayers().size();
    private static int missingPlayers = Settings.MIN_PLAYERS - Bukkit.getOnlinePlayers().size();

    public static void startBroadcast() {
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlguin(), new Runnable() {
            @Override
            public void run() {
                if(onlinePlayers < Settings.MIN_PLAYERS) {
                    Bukkit.broadcastMessage(Main.prefix + "§cThere are still missing " + missingPlayers + " players!");
                }
            }
        }, 0,120);
    }

}
