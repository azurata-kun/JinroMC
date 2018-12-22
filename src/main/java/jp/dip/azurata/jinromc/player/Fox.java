package jp.dip.azurata.jinromc.player;

import org.bukkit.entity.Player;

public class Fox extends JinroPlayer {

	public Fox(Player player) {
		super(player);
		super.role = JinroRole.fox;
	}

}
