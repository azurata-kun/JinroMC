package jp.dip.azurata.jinromc.player;

import org.bukkit.entity.Player;

public final class Werewolf extends JinroPlayer {

	private Player attack;

	public Werewolf(Player player) {
		super(player);
		super.role = JinroRole.werewolf;
	}

	public Player getAttack() {
		return this.attack;
	}

	public void setAttack(Player attack) {
		this.attack = attack;
	}

}
