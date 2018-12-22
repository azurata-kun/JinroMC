package jp.dip.azurata.jinromc.runnunble;

import java.util.Collections;
import java.util.Random;

import jp.dip.azurata.jinromc.JinroMC;
import jp.dip.azurata.jinromc.player.Fox;
import jp.dip.azurata.jinromc.player.JinroKake;
import jp.dip.azurata.jinromc.player.JinroRole;
import jp.dip.azurata.jinromc.player.Madman;
import jp.dip.azurata.jinromc.player.Seer;
import jp.dip.azurata.jinromc.player.Werewolf;

public class Runnuble {

	protected int day;

	public void giveRole() {
		Collections.shuffle(JinroMC.joinList);
		int nowIndex = 0;
		Random r = new Random();
		int kakeIndex = r.nextInt(JinroMC.config.RoleSum);
		for(int i = 0; i < JinroMC.config.werewolf; i++, nowIndex++) {
			if(nowIndex == kakeIndex) kakeIndex = r.nextInt(JinroMC.config.RoleSum - (nowIndex + 1) + nowIndex);
			JinroMC.players.add(new Werewolf(JinroMC.joinList.get(nowIndex)));
		}
		for(int i = 0; i < JinroMC.config.madman; i++, nowIndex++) {
			if(nowIndex == kakeIndex) JinroMC.players.add(new JinroKake(JinroRole.madman));
			else JinroMC.players.add(new Madman(JinroMC.joinList.get(nowIndex)));
		}
		for(int i = 0; i < JinroMC.config.fox; i++, nowIndex++) {
			if(nowIndex == kakeIndex) kakeIndex = r.nextInt(JinroMC.config.RoleSum - (nowIndex + 1) + nowIndex);
			JinroMC.players.add(new Fox(JinroMC.joinList.get(nowIndex)));
		}
		for(int i = 0; i < JinroMC.config.seer; i++, nowIndex++) {
			if(nowIndex == kakeIndex) JinroMC.players.add(new JinroKake(JinroRole.seer));
			else JinroMC.players.add(new Seer(JinroMC.joinList.get(nowIndex)));
		}
	}

	public void end() {

	}

	public void stop() {

	}

}
