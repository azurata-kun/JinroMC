package jp.dip.azurata.jinromc.player;

import org.bukkit.entity.Player;

public final class Werewolf extends JinroPlayer {

	private Player attackee;

	public Werewolf(Player player) {
		super(player);
		super.role = JinroRole.werewolf;
	}

	/**
	 * 夜のターンの攻撃先を取得
	 * @return 攻撃先
	 */
	public Player getAttack() {
		return this.attackee;
	}

	/**
	 * 夜のターンの攻撃先を設定
	 * @param attackee 攻撃先
	 */
	public void setAttack(Player attackee) {
		this.attackee = attackee;
	}

}
