package jp.dip.azurata.jinromc.player;

import org.bukkit.entity.Player;

public final class Madman extends JinroPlayer {

	public Madman(Player player) {
		super(player);
		super.role = JinroRole.madman;
	}

}
