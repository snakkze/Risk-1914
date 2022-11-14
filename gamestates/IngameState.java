package net.snakkze.risk1914.gamestates;

import net.snakkze.risk1914.Main;
import net.snakkze.risk1914.events.IngameStateListeners;
import net.snakkze.risk1914.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;

public class IngameState implements GameState {

    @Override
    public void start() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new IngameStateListeners(), Main.getPlguin());
        for(Player p: Bukkit.getOnlinePlayers()){
            p.closeInventory();
            p.getInventory().clear();
            ScoreboardManager.createScoreBoard(p);
        }

    }

    @Override
    public void stop() {
        HandlerList.unregisterAll(new IngameStateListeners());
    }
}
