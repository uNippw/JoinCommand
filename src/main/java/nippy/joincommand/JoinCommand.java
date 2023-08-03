package nippy.joincommand;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class JoinCommand extends JavaPlugin implements Listener {

    private FileConfiguration config;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        config = getConfig();

        getServer().getPluginManager().registerEvents(this, this);

        // Enviar mensagem de sucesso para o console do servidor
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin iniciado com sucesso!");
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String playerName = player.getName();

        // Obter a lista de comandos a serem executados do arquivo config.yml
        if (config.contains("commands")) {
            // Simular como se o jogador tivesse digitado cada comando
            for (String command : config.getStringList("commands")) {
                String formattedCommand = command.replace("%player%", playerName);
                player.chat(formattedCommand);
            }
        }
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String message = event.getMessage();

        // Verificar se o comando foi executado pelo plugin (simulado)
        if (message.startsWith("/simulated:")) {
            // Cancelar a execução do comando original
            event.setCancelled(true);

            // Obter o comando real, excluindo o prefixo "/simulated:"
            String realCommand = message.substring("/simulated:".length()).trim();

            // Executar o comando para o jogador
            player.performCommand(realCommand);
        }
    }

    @Override
    public void saveDefaultConfig() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }
        File configFile = new File(getDataFolder(), "config.yml");
        if (!configFile.exists()) {
            saveResource("config.yml", false);
        }
    }
}