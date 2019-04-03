
package jp.dip.azurata.jinromc.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jp.dip.azurata.jinromc.GameTime;
import jp.dip.azurata.jinromc.JinroAPI;
import jp.dip.azurata.jinromc.JinroMC;
import jp.dip.azurata.jinromc.player.JinroPlayer;
import jp.dip.azurata.jinromc.player.JinroRole;
import jp.dip.azurata.jinromc.player.Seer;

public class Uranai implements CommandExecutor {

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    JinroPlayer senderJ = JinroMC.api.getJinroPlayer((Player)sender);
    if(senderJ.equals(null))
      sender.sendMessage("[JinroMC]" + "あなたはプレイヤーではないためこのコマンドを実行できません");
    else if(senderJ.getRole() == JinroRole.seer) {
      Seer senderU = (Seer)senderJ;
      JinroPlayer uranaiee = JinroMC.api.getJinroPlayer(Bukkit.getPlayer(args[0]));
      if(!uranaiee.equals(null))
        senderU.uranai(uranaiee);
      else
        senderU.sendMessage(args[0] + "というプレイヤーは存在しません");
    }
    else
      senderJ.sendMessage("あなたは占い師ではないため、このコマンドを実行できません");
    return true;
  }
}