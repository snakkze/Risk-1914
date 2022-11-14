package net.snakkze.risk1914.util;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Config {

    private FileConfiguration fileConfiguration;
    private File file;

    public Config(String name, File path) {
        file = new File(path, name);

        if(!file.exists()) {
            path.mkdirs();
            try {
                file.createNewFile();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }

        fileConfiguration = new YamlConfiguration();
        try {
            fileConfiguration.load(file);
        } catch(IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    public boolean contains(String path) {
        return fileConfiguration.contains(path);
    }

    public void set(String path, String string) throws IOException {
        fileConfiguration.set(path, string);
        fileConfiguration.save(file);
    }

    public void setInt(String path, int arg) throws IOException {
        fileConfiguration.set(path, arg);
        fileConfiguration.save(file);
    }

    public void setBool(String path, Boolean bool) throws IOException {
        fileConfiguration.set(path, bool);
        fileConfiguration.save(file);
    }

    public File getFile(String path) {
        if(!contains(path)) {
            return null;
        }
        return (File) fileConfiguration.get(path);
    }

    public FileConfiguration toFileConfiguration() {
        return fileConfiguration;
    }

    public void save() {
        try {
            fileConfiguration.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        try {
            fileConfiguration.load(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

}
