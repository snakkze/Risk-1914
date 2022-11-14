package net.snakkze.risk1914.gamestates;

import net.snakkze.risk1914.Main;
import net.snakkze.risk1914.events.LobbyStateListeners;
import net.snakkze.risk1914.util.Settings;
import net.snakkze.risk1914.util.Timer;
import net.snakkze.risk1914.util.TimerListener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.PluginManager;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class LobbyState implements GameState {

    private Timer timer;

    @Override
    public void start() {
        if(!Main.getPlguin().config.contains("gamestate")) {
            try {
                Main.getPlguin().config.set("gamestate", "lobby");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new LobbyStateListeners(), Main.getPlguin());
        //Broadcaster.startBroadcast();
        startTimer();
    }

    @Override
    public void stop() {
        HandlerList.unregisterAll(new LobbyStateListeners());
    }

    public void startTimer() {
        timer = new Timer(new TimerListener() {

            @Override
            public void onTick(int time) {
                switch (time) {
                    case 60:
                    case 45:
                    case 30:
                    case 15:
                    case 10:
                    case 5:
                    case 4:
                    case 3:
                    case 2:
                        Bukkit.broadcastMessage(Main.prefix + "§aThe game starts in " + time + " seconds");
                        break;
                    case 1:
                        Bukkit.broadcastMessage(Main.prefix + "§aThe game starts in " + time + " second");
                        for(Player p: Bukkit.getOnlinePlayers()){
                            if(!Main.getPlguin().config.contains(p.getUniqueId().toString())) {
                                ArrayList<String> availableCountrys = new ArrayList<String>();
                                if(!Main.getPlguin().config.contains("uk")) {
                                    availableCountrys.add("uk");
                                }
                                if(!Main.getPlguin().config.contains("norway")) {
                                    availableCountrys.add("norway");
                                }
                                if(!Main.getPlguin().config.contains("sweden")) {
                                    availableCountrys.add("sweden");
                                }
                                if(!Main.getPlguin().config.contains("denmark")) {
                                    availableCountrys.add("denmark");
                                }
                                if(!Main.getPlguin().config.contains("russia")) {
                                    availableCountrys.add("russia");
                                }
                                if(!Main.getPlguin().config.contains("german-empire")) {
                                    availableCountrys.add("german-empire");
                                }
                                if(!Main.getPlguin().config.contains("austria-hungary")) {
                                    availableCountrys.add("austria-hungary");
                                }
                                if(!Main.getPlguin().config.contains("belgium")) {
                                    availableCountrys.add("belgium");
                                }
                                if(!Main.getPlguin().config.contains("netherlands")) {
                                    availableCountrys.add("netherlands");
                                }
                                if(!Main.getPlguin().config.contains("luxembourg")) {
                                    availableCountrys.add("luxembourg");
                                }
                                if(!Main.getPlguin().config.contains("france")) {
                                    availableCountrys.add("france");
                                }
                                if(!Main.getPlguin().config.contains("spain")) {
                                    availableCountrys.add("spain");
                                }
                                if(!Main.getPlguin().config.contains("montenegro")) {
                                    availableCountrys.add("montenegro");
                                }
                                if(!Main.getPlguin().config.contains("italy")) {
                                    availableCountrys.add("italy");
                                }
                                if(!Main.getPlguin().config.contains("switzerland")) {
                                    availableCountrys.add("switzerland");
                                }
                                if(!Main.getPlguin().config.contains("portugal")) {
                                    availableCountrys.add("portugal");
                                }
                                if(!Main.getPlguin().config.contains("greece")) {
                                    availableCountrys.add("greece");
                                }
                                if(!Main.getPlguin().config.contains("serbia")) {
                                    availableCountrys.add("serbia");
                                }
                                if(!Main.getPlguin().config.contains("albania")) {
                                    availableCountrys.add("albania");
                                }
                                if(!Main.getPlguin().config.contains("turkey")) {
                                    availableCountrys.add("turkey");
                                }
                                if(!Main.getPlguin().config.contains("bulgaria")) {
                                    availableCountrys.add("bulgaria");
                                }
                                if(!Main.getPlguin().config.contains("romania")) {
                                    availableCountrys.add("romania");
                                }

                                for(String AllAvailableCountry : availableCountrys){
                                    System.out.println(AllAvailableCountry);
                                }
                                Random r = new Random();
                                int rInt = r.nextInt(availableCountrys.size());
                                String rString = availableCountrys.get(rInt);
                                try {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", rString);
                                    Main.getPlguin().config.setBool(rString + ".available", false);
                                    if(rString.equals("uk")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§9United §cKingdom");
                                    }
                                    if(rString.equals("norway")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§cNorway");
                                    }
                                    if(rString.equals("sweden")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§eSweden");
                                    }
                                    if(rString.equals("denmark")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§cDenmark");
                                    }
                                    if(rString.equals("russia")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§9Russia");
                                    }
                                    if(rString.equals("german-empire")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§c§lGerman Empire");
                                    }
                                    if(rString.equals("austria-hungary")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§cAustria §2Hungary");
                                    }
                                    if(rString.equals("belgium")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§eBelgium");
                                    }
                                    if(rString.equals("netherlands")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§9Netherlands");
                                    }
                                    if(rString.equals("luxembourg")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§bLuxembourg");
                                    }
                                    if(rString.equals("france")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§9France");
                                    }
                                    if(rString.equals("spain")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§cSpain");
                                    }
                                    if(rString.equals("montenegro")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§9Montenegro");
                                    }
                                    if(rString.equals("italy")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§2italy");
                                    }
                                    if(rString.equals("switzerland")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§cSwitzerland");
                                    }
                                    if(rString.equals("portugal")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§2Portugal");
                                    }
                                    if(rString.equals("greece")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§bGreece");
                                    }
                                    if(rString.equals("albania")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§cAlbania");
                                    }
                                    if(rString.equals("serbia")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§9Serbia");
                                    }
                                    if(rString.equals("turkey")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§cTurkey");
                                    }
                                    if(rString.equals("bulgaria")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§2Bulgaria");
                                    }
                                    if(rString.equals("romania")) {
                                        Main.getPlguin().config.set(rString + ".countrypref", "§eRomania");
                                    }

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        break;
                    case 0:
                        try {
                            Main.getPlguin().config.set("gamestate", "ingame");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Main.getPlguin().saveDefaultConfig();
                        Bukkit.reload();
                        GameStateManager gameStateManager = GameStateManager.getPlugin();
                        gameStateManager.setGameState(new IngameState());
                        stop();
                    }
                }

            @Override
            public void onPause(int time) {

            }

            @Override
            public void onResume(int time) {

            }

            @Override
            public void onStop() {

            }
        }, 50);
    }

    public Timer getTimer() {
        return timer;
    }

    public void recalculateTime() {
        if(Main.getPlguin().getConfig().getString("gamestate").equals("lobby")) {
            int players = Bukkit.getOnlinePlayers().size();
            boolean running = !timer.isPaused();
            if(!running && players == Settings.MIN_PLAYERS) {
                timer.setTime(10);
                timer.setPaused(false);
                return;
            }

            if(running && players <= Settings.MIN_PLAYERS) {
                timer.setPaused(true);
                Bukkit.broadcastMessage(Main.prefix + "§cThe timer has stopped because there were not enough players!");
                return;
            }
            skipTime(timer.getTime(), players);
        }
    }

    public void skipTime(int time, int players) {
        if(Settings.SKIP_TIME >= players && !(time < 20)) {
            timer.setTime(20);
        }
    }
}
