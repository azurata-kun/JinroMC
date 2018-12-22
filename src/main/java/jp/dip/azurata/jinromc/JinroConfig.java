package jp.dip.azurata.jinromc;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;

public final class JinroConfig {

	private FileConfiguration config = JinroMC.plugin.getConfig();

	public boolean isOneNight;
	public boolean isKake;
	public World world;

	public int werewolf;
	public int madman;
	public int fox;
	public int seer;
	public int psychic;
	public int knight;
	public int villager;
	public int RoleSum;
	public int playerLimit;

	public void loadConfig() {
		try {
			isOneNight = config.getBoolean("onenight");
			isKake = config.getBoolean("kake");
			world = Bukkit.getWorld(config.getString("playing-world"));
			werewolf = Math.abs(config.getInt("role.werewolf"));
			madman = Math.abs(config.getInt("role.madman"));
			fox = Math.abs(config.getInt("role.fox"));
			seer = Math.abs(config.getInt("role.seer"));
			psychic = Math.abs(config.getInt("role.psychic"));
			knight = Math.abs(config.getInt("role.knight"));
			villager = Math.abs(config.getInt("role.villager"));
		}
		catch(NullPointerException e) {
			JinroMC.log("コンフィグが正しく設定されていないため、デフォルトの設定を読み込みます");
			isOneNight = false;
			isKake = true;
			world = Bukkit.getWorlds().get(0);
			werewolf = 1;
			madman = 0;
			fox = 0;
			seer = 1;
			psychic = 0;
			villager = 3;
		}
		RoleSum = werewolf + madman + fox + seer + psychic + knight + villager;
		if(isKake) playerLimit = RoleSum - 1;
		else playerLimit = RoleSum;
	}

}
