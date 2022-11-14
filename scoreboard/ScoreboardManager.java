package net.snakkze.risk1914.scoreboard;

import net.snakkze.risk1914.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardManager {

    public static void createScoreBoard(Player p) {
        org.bukkit.scoreboard.ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();
        String chosenCountry = Main.getPlguin().getConfig().getString(p.getUniqueId() + ".country");
        Objective obj = board.registerNewObjective("WorldWarSB", "dummy", Main.getPlguin().getConfig().getString(chosenCountry + ".countrypref"));
        Score score8 = obj.getScore("§c ");
        score8.setScore(8);
        Score score7 = obj.getScore("§7§lMetal: ");
        score7.setScore(7);
        Score score6 = obj.getScore("§c§lOil: ");
        score6.setScore(6);
        Score score5 = obj.getScore("§e§lFood: ");
        score5.setScore(5);
        Score score4 = obj.getScore("§6§lWood: ");
        score4.setScore(4);
        Score score3 = obj.getScore("§2§lManpower: ");
        score3.setScore(3);
        Score score2 = obj.getScore(" ");
        score2.setScore(2);
        Score score1 = obj.getScore("§d§lsnakkze.net");
        score1.setScore(1);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        p.setScoreboard(board);
    }
}
