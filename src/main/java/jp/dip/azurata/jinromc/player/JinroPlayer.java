package jp.dip.azurata.jinromc.player;

import org.bukkit.entity.Player;

import jp.dip.azurata.jinromc.JinroMC;

public class JinroPlayer {

	protected final Player player;
	protected JinroRole role;
	protected Player vote;
	protected boolean turnEnd;

	public JinroPlayer(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return this.player;
	}

	public JinroRole getRole() {
		return this.role;
	}

	public Player getVote() {
		return this.vote;
	}

	public boolean isTurndEnd() {
		return this.turnEnd;
	}

	public void setVote(Player vote) {
		this.vote = vote;
		setTurnEnd(true);
		JinroMC.api.judgeGoToNextTurn();
	}

	public void setTurnEnd(boolean turnEnd) {
		this.turnEnd = turnEnd;
	}

	public void sendMessage(String message) {
		player.sendMessage("[JinroMC]" + message);
	}

}
