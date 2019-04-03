package jp.dip.azurata.jinromc;

import org.bukkit.entity.Player;

import jp.dip.azurata.jinromc.player.JinroPlayer;

public final class JinroAPI {

	public void nextTurn() {
		switch(JinroMC.time) {
		case Before:
			JinroMC.log("現在はゲーム前のため、次の時間に進めません");
			break;
		case Day:
			break;
		case Night:
			break;
		case VoteTime:
			break;
		}
	}

	/**
	 * 引数で指定されたプレイヤーと紐づけたれたJinroPlayer型のオブジェクトを返す
	 * @param player プレイヤーを指定
	 * @return playerを持つJinroPlayer型のオブジェクト。プレイヤーリストから見つからない場合はnullを返す
	 */
	public JinroPlayer getJinroPlayer(Player player) {
		for(JinroPlayer jinroPlayer : JinroMC.players) {
			if(jinroPlayer.getPlayer().equals(player)) {
				return jinroPlayer;
			}
		}
		return null;
	}

}
