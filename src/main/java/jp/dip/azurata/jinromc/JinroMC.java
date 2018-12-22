package jp.dip.azurata.jinromc;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import jp.dip.azurata.jinromc.player.JinroPlayer;
import jp.dip.azurata.jinromc.runnunble.Runnuble;

public final class JinroMC extends JavaPlugin {

	public static JavaPlugin plugin;
	public static JinroConfig config = new JinroConfig();
	public static JinroAPI api = new JinroAPI();

	public static List<Player> joinList = new ArrayList<>();
	public static List<JinroPlayer> players = new ArrayList<>();

	public static GameTime time = GameTime.Before;
	public static List<JinroPlayer> nextDead = new ArrayList<>();

	public static Runnuble runnuble;

	@Override
	public void onDisable() {
		log("プラグインが無効になりました");
	}

	@Override
	public void onEnable() {
		plugin = this;
		config.loadConfig();
		getServer().getPluginManager().registerEvents(new JinroListener(), plugin);
		log("プラグインが有効になりました");
	}

	public static void log(String message) {
		System.out.println(message);
	}

	public static void broadcastMessage(String message) {
		Bukkit.broadcastMessage("[JinroMC]" + message);
	}

}
