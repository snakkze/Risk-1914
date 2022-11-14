package net.snakkze.risk1914.gamestates;

import net.snakkze.risk1914.Main;

public class GameStateManager {

    private static GameStateManager instance;

    private GameState gameState;

    public static GameStateManager getPlugin() {
        if(instance == null) {
            instance = new GameStateManager();
        }
        return instance;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        if(this.gameState != null) {
            this.gameState.stop();
        }
        this.gameState = gameState;
        this.gameState.start();
    }

    public void checkGameState() {
        if(Main.getPlguin().config.contains("gamestate")) {
            if(Main.getPlguin().getConfig().getString("gamestate").equals("ingame")) {
                setGameState(new IngameState());
            } else if(Main.getPlguin().getConfig().getString("gamestate").equals("endstate")) {

            } else {
                setGameState(new LobbyState());
            }
        } else {
            setGameState(new LobbyState());
        }
    }
}
