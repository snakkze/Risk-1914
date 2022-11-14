package net.snakkze.risk1914.inventorys;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import net.snakkze.risk1914.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.codehaus.plexus.util.Base64;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.UUID;

public class SelectionInventory {

    public static void openGUI(Player p) {
        Inventory i = Bukkit.createInventory(null, 3*9, "§a§lSelect a country!");
        i.setItem(0, getSkull("§9United §cKingdom", "http://textures.minecraft.net/texture/c439d7f9c67f32dcbb86b7010b1e14b60de96776a35f61cee982660aacf5264b", "§aChoose the United Kingdom"));
        i.setItem(1, getSkull("§cNorway", "http://textures.minecraft.net/texture/fda048bc153b38467e76a3347f38396860a8bc68603931e91f7af58bec57383d", "§aChoose Norway"));
        i.setItem(2, getSkull("§eSweden", "https://textures.minecraft.net/texture/7d86242b0d97ece9994660f3974d72df7b887f630a4530dadc5b1ab7c2134aec", "§aChoose Sweden"));
        i.setItem(3, getSkull("§cDenmark", "http://textures.minecraft.net/texture/10c23055c392606f7e531daa2676ebe2e348988810c15f15dc5b3733998232", "§aChoose Denmark"));
        i.setItem(4, getSkull("§9Russia", "http://textures.minecraft.net/texture/16eafef980d6117dabe8982ac4b4509887e2c4621f6a8fe5c9b735a83d775ad", "§aChoose Russia"));
        i.setItem(5, getSkull("§c§lGerman Empire", "http://textures.minecraft.net/texture/dd8bc8027843e512b8c76c8e6bba7f62c45afd862071dcc9c09e6944f987db4", "§aChoose the German Empire"));
        i.setItem(6, getSkull("§cAustria §2Hungary", "http://textures.minecraft.net/texture/fca4d63a706a6955f05085d960d4db8651e646143556f289b4054a17061fc3b8", "§aChoose Austria-Hungary"));
        i.setItem(7, getSkull("§eBelgium", "http://textures.minecraft.net/texture/c8e0e0de705d366ba59506b3fb1a04fd3d51aff90e5cfb4ebbea66ea5976c0ff", "§aChoose Belgium"));
        i.setItem(8, getSkull("§9Netherlands", "http://textures.minecraft.net/texture/c23cf210edea396f2f5dfbced69848434f93404eefeabf54b23c073b090adf", "§aChoose the Netherlands"));
        i.setItem(9, getSkull("§bLuxembourg", "http://textures.minecraft.net/texture/3d5effd3f9c15058382d3b2d2936d50b894bfcb11e6b2f1364535ce52aa5", "§aChoose Luxembourg"));
        i.setItem(10, getSkull("§9France", "http://textures.minecraft.net/texture/6903349fa45bdd87126d9cd3c6c0abba7dbd6f56fb8d78701873a1e7c8ee33cf", "§aChoose France"));
        i.setItem(11, getSkull("§cSpain", "http://textures.minecraft.net/texture/32bd4521983309e0ad76c1ee29874287957ec3d96f8d889324da8c887e485ea8", "§aChoose Spain"));
        i.setItem(12, getSkull("§9Montenegro", "http://textures.minecraft.net/texture/5b0483a4f0ddf4fbbc977b127b3d294d7a869f995366e3f50f6b05a70f522510", "§aChoose Montenegro"));
        i.setItem(13, getSkull("§2Italy", "http://textures.minecraft.net/texture/97eac627244c95d125ca0c0221ab3f0ea06ef4bb7982f17aac7a11bb1c8db7ea", "§aChoose Italy"));
        i.setItem(14, getSkull("§cSwitzerland", "http://textures.minecraft.net/texture/572ffabc40a3a82a9dbb081038f9834707b8a7a595e47d63e4c7a7e24a6c8829", "§aChoose Switzerland"));
        i.setItem(15, getSkull("§2Portugal", "http://textures.minecraft.net/texture/ebd51f4693af174e6fe1979233d23a40bb987398e3891665fafd2ba567b5a53a", "§aChoose Portugal"));
        i.setItem(16, getSkull("§bGreece", "http://textures.minecraft.net/texture/834cd1ff839a5167bfb2251833c49b40d16e546e75c6ea8ef2efda7b86a361f8", "§aChoose Greece"));
        i.setItem(17, getSkull("§cAlbania", "http://textures.minecraft.net/texture/57cea7767330dd4943d47496b5186c17e61888a29fba651a23dae75f650b532c", "§aChoose Albania"));
        i.setItem(18, getSkull("§9Serbia", "http://textures.minecraft.net/texture/76461165e48b86c56bb98f48b201aef05a30c914e90f4515f05219c6827e7e1d", "§aChoose Serbia"));
        i.setItem(19, getSkull("§cTurkey", "https://textures.minecraft.net/texture/6bbeaf52e1c4bfcd8a1f4c6913234b840241aa48829c15abc6ff8fdf92cd89e", "§aChoose Turkey"));
        i.setItem(20, getSkull("§2Bulgaria", "http://textures.minecraft.net/texture/a66a8917d7c33cb8bc8464eb689a1a85197376f555d0d24cd37fab620e723f93", "§aChoose Bulgaria"));
        i.setItem(21, getSkull("§eRomania", "http://textures.minecraft.net/texture/dceb1708d5404ef326103e7b60559c9178f3dce729007ac9a0b498bdebe46107", "§aChoose Romania"));
        i.setItem(22, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§c").build());
        i.setItem(23, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§c").build());
        i.setItem(24, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§c").build());
        i.setItem(25, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§c").build());
        i.setItem(26, new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setDisplayname("§c").build());

        p.openInventory(i);
    }

    public static ItemStack getSkull(String name, String url, String... lore) {
        ItemStack head= new ItemStack(Material.PLAYER_HEAD, 1, (short) 3);

        if (url == null || url.isEmpty())
            return head;

        ItemMeta headMeta = head.getItemMeta();
        headMeta.setDisplayName(name);
        headMeta.setLore(Arrays.asList(lore));
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        byte[] encodedData = Base64.encodeBase64(String.format("{textures:{SKIN:{url:\"%s\"}}}", url).getBytes());
        profile.getProperties().put("textures", new Property("textures", new String(encodedData)));
        Field profileField = null;

        try {
            profileField = headMeta.getClass().getDeclaredField("profile");
        } catch (NoSuchFieldException | SecurityException e) {
            e.printStackTrace();
        }

        profileField.setAccessible(true);

        try {
            profileField.set(headMeta, profile);
        } catch (IllegalArgumentException | IllegalAccessException e) {
            e.printStackTrace();
        }

        head.setItemMeta(headMeta);
        return head;
    }
}
