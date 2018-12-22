package jp.dip.azurata.jinromc;

import org.bukkit.entity.Player;

import jp.dip.azurata.jinromc.player.JinroPlayer;

public final class JinroAPI {

	public void next() {
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

	public JinroPlayer getJinroPlayer(Player player) {
		for(JinroPlayer jinroPlayer : JinroMC.players) {
			if(jinroPlayer.getPlayer().equals(player)) {
				return jinroPlayer;
			}
		}
		return null;
	}

	public void judgeGoToNextTurn() {
		for(JinroPlayer player : JinroMC.players) {
			if(!player.isTurndEnd())
				return;
		}
		next();
	}
}
