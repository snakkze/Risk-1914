package net.snakkze.risk1914.events;

import net.snakkze.risk1914.Main;
import net.snakkze.risk1914.gamestates.GameStateManager;
import net.snakkze.risk1914.gamestates.LobbyState;
import net.snakkze.risk1914.inventorys.SelectionInventory;
import net.snakkze.risk1914.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;


public class LobbyStateListeners implements Listener {

    HashMap<UUID, Boolean> hasChosen = new HashMap<>();

    public boolean hasChosenBool(UUID uuid) {
        if(hasChosen.get(uuid) != null) {
            return true;
        } else {
            return false;
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        LobbyState lobbyState = (LobbyState) GameStateManager.getPlugin().getGameState();
        lobbyState.recalculateTime();

        p.teleport(new Location(Bukkit.getWorld(Main.getPlguin().getConfig().getString("worldname")), 540.500, 32, 1235.500, 0, -10));
        p.getInventory().clear();
        p.setGameMode(GameMode.SURVIVAL);
        p.setAllowFlight(true);
        p.setFlying(true);
        p.getInventory().setItem(4, new ItemBuilder(Material.COMPASS).setDisplayname("§aChoose your country").setLore("§aChoose the country that", "§ayou want to play").build());
        e.setJoinMessage("");
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        new BukkitRunnable() {

            @Override
            public void run() {
                LobbyState lobbyState = (LobbyState) GameStateManager.getPlugin().getGameState();
                lobbyState.recalculateTime();
            }
        }.runTaskLater(Main.getPlguin(), 1);
        e.setQuitMessage("");
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        if(e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        if(e.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onFoodLevelChange(FoodLevelChangeEvent e) {
        if(e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInteractEvent(PlayerInteractEvent e) {
        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {
            Player p = e.getPlayer();
            if(e.getItem() != null && e.getItem().hasItemMeta() && e.getItem().getItemMeta().getDisplayName().equals("§aChoose your country")) {
                SelectionInventory.openGUI(p);
            }
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) throws IOException {
        if(e.getCurrentItem() != null) {
            if(e.getView().getTitle().equals("§a§lSelect a country!")) {
                Player p = (Player) e.getWhoClicked();
                e.setCancelled(true);
                if(e.getCurrentItem().getItemMeta().hasDisplayName()) {
                    if(!hasChosenBool(p.getUniqueId())) {
                        switch (e.getCurrentItem().getItemMeta().getDisplayName()) {
                            case "§9United §cKingdom":
                                if(!Main.getPlguin().config.contains("uk")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "uk");
                                    Main.getPlguin().config.set("uk" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("uk" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen the " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§cNorway":
                                if(!Main.getPlguin().config.contains("norway")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "norway");
                                    Main.getPlguin().config.set("norway" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("norway" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§eSweden":
                                if(!Main.getPlguin().config.contains("sweden")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "sweden");
                                    Main.getPlguin().config.set("sweden" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("sweden" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§cDenmark":
                                if(!Main.getPlguin().config.contains("denmark")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "denmark");
                                    Main.getPlguin().config.set("denmark" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("denmark" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§9Russia":
                                if(!Main.getPlguin().config.contains("russia")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "russia");
                                    Main.getPlguin().config.set("russia" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("russia" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§c§lGerman Empire":
                                if(!Main.getPlguin().config.contains("german-empire")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "german-empire");
                                    Main.getPlguin().config.set("german-empire" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("german-empire" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen the " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§cAustria §2Hungary":
                                if(!Main.getPlguin().config.contains("austria-hungary")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "austria-hungary");
                                    Main.getPlguin().config.set("autria-hungary" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("austria-hungary" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§eBelgium":
                                if(!Main.getPlguin().config.contains("belgium")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "belgium");
                                    Main.getPlguin().config.set("belgium" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("belgium" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§9Netherlands":
                                if(!Main.getPlguin().config.contains("netherlands")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "netherlands");
                                    Main.getPlguin().config.set("netherlands" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("netherlands" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen the " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§bLuxembourg":
                                if(!Main.getPlguin().config.contains("luxembourg")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "luxembourg");
                                    Main.getPlguin().config.set("luxembourg" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("luxembourg" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§9France":
                                if(!Main.getPlguin().config.contains("france")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "france");
                                    Main.getPlguin().config.set("france" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("france" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§cSpain":
                                if(!Main.getPlguin().config.contains("spain")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "spain");
                                    Main.getPlguin().config.set("spain" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("spain" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§9Montenegro":
                                if(!Main.getPlguin().config.contains("montenegro")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "montenegro");
                                    Main.getPlguin().config.set("montenegro" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("montenegro" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§2Italy":
                                if(!Main.getPlguin().config.contains("italy")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "italy");
                                    Main.getPlguin().config.set("italy" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("italy" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§cSwitzerland":
                                if(!Main.getPlguin().config.contains("switzerland")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "switzerland");
                                    Main.getPlguin().config.set("switzerland" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("switzerland" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§2Portugal":
                                if(!Main.getPlguin().config.contains("portugal")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "portugal");
                                    Main.getPlguin().config.set("portugal" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("portugal" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§bGreece":
                                if(!Main.getPlguin().config.contains("greece")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "greece");
                                    Main.getPlguin().config.set("greece" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("greece" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§cAlbania":
                                if(!Main.getPlguin().config.contains("albania")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "albania");
                                    Main.getPlguin().config.set("albania" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("albania" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§9Serbia":
                                if(!Main.getPlguin().config.contains("serbia")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "serbia");
                                    Main.getPlguin().config.set("serbia" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("serbia" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§cTurkey":
                                if(!Main.getPlguin().config.contains("turkey")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "turkey");
                                    Main.getPlguin().config.set("turkey" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("turkey" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§2Bulgaria":
                                if(!Main.getPlguin().config.contains("bulgaria")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "bulgaria");
                                    Main.getPlguin().config.set("bulgaria" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("bulgaria" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                            case "§eRomania":
                                if(!Main.getPlguin().config.contains("romania")) {
                                    Main.getPlguin().config.set(p.getUniqueId() + ".country", "romania");
                                    Main.getPlguin().config.set("romania" + ".countrypref", e.getCurrentItem().getItemMeta().getDisplayName());
                                    Main.getPlguin().config.setBool("romania" + ".available", false);
                                    hasChosen.put(p.getUniqueId(), true);
                                    p.sendMessage("§aYou have chosen " + e.getCurrentItem().getItemMeta().getDisplayName());
                                    p.closeInventory();
                                } else {
                                    p.sendMessage("§cThat country is already chosen by another Player!");
                                }
                                break;
                        }
                    } else {
                        p.sendMessage("§cYou have already chosen a country!!!");
                    }
                }
            }
        }
    }
}
