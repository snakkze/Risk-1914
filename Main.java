package net.snakkze.risk1914;

import net.snakkze.risk1914.gamestates.GameStateManager;
import net.snakkze.risk1914.util.Config;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public final class Main extends JavaPlugin {

    public static final String prefix = "§7[§aRisk 1914§7] » ";
    private static Main plguin;
    public Config config;

    @Override
    public void onEnable() {
        plguin = this;

        saveDefaultConfig();
        config = new Config("config.yml", getDataFolder());

        if(!config.contains("worldname")) {
            try {
                config.set("worldname", "WORLDNAME");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(!config.contains("min_players")) {
            try {
                config.setInt("min_players", 15);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        GameStateManager gameStateManager = GameStateManager.getPlugin();
        gameStateManager.checkGameState();
    }

    @Override
    public void onDisable() {

    }

    public static Main getPlguin() {
        return plguin;
    }
}
