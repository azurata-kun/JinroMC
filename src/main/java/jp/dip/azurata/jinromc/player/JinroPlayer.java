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

	/**
	 * このオブジェクトに紐付けられたプレイヤーを返す
	 * @return 変数player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * プレイヤーの役職を返す
	 * @return 変数role
	 */
	public JinroRole getRole() {
		return this.role;
	}

	/**
	 * プレイヤーの投票先を返す
	 * @return 変数vote
	 */
	public Player getVote() {
		return this.vote;
	}

	/**
	 * プレイヤーのターンが終了しているかを返す
	 * @return 変数turnEnd
	 */
	public boolean isTurndEnd() {
		return this.turnEnd;
	}

	/**
	 * 投票先を設定
	 * @param vote 投票先
	 */
	public void setVote(Player vote) {
		this.vote = vote;
		setTurnEnd(true);
		JinroMC.api.judgeGoToNextTurn();
	}

	/**
	 * ターン開始・終了を設定
	 * @param turnEnd 真偽値
	 */
	public void setTurnEnd(boolean turnEnd) {
		this.turnEnd = turnEnd;
	}

	/**
	 * プレイヤーに通知
	 * @param message メッセージ
	 */
	public void sendMessage(String message) {
		player.sendMessage("[JinroMC]" + message);
	}

}
