package jp.dip.azurata.jinromc.player;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import jp.dip.azurata.jinromc.GameTime;
import jp.dip.azurata.jinromc.JinroMC;

public final class Seer extends JinroPlayer {

	public Seer(Player player) {
		super(player);
		super.role = JinroRole.seer;
	}
	/**
	 * 引数に指定されたプレイヤーを占い、結果をプレイヤーに通知
	 * @param player 占う対象のプレイヤー
	 */
	public void uranai(JinroPlayer player) {
		if(JinroMC.time == GameTime.Night)  {
			if(!super.turnEnd) {
				switch(player.getRole()) {
					case werewolf:
						sendMessage(player.getPlayer().getName() + "さんは" + ChatColor.RED + "人狼" + ChatColor.WHITE + "です");
						break;
					case fox:
						JinroMC.nextDead.add(player);
					default:
						sendMessage(player.getPlayer().getName() + "さんは人狼ではありません");
				}
				super.turnEnd = true;
			}
			else {
				sendMessage("1日に一人しか占えません");
			}
		}
		else {
			sendMessage("この時間は占いを実行できません");
		}
	}

}
