package jp.dip.azurata.jinromc.command;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import jp.dip.azurata.jinromc.GameTime;
import jp.dip.azurata.jinromc.JinroMC;

public class Jinro implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		switch(args[0]) {
			case "start":
				if(JinroMC.time == GameTime.Before) {
					JinroMC.runnuble.giveRole();
				}
				else {
					sender.sendMessage("[JinroMC]ゲームは既に開始されています");
				}
				break;
			case "stop":
				if(JinroMC.time != GameTime.Before) {
					JinroMC.runnuble.stop();
				}
				else {
					sender.sendMessage("[JinroMC]ゲームは開始されていません");
				}
			case "skip":
				if(JinroMC.time == GameTime.Before) {
					sender.sendMessage("[JinroMC]ゲームが開始していないため、スキップできません");
				}
				else {
					JinroMC.api.next();
					sender.sendMessage("[JinroMC]スキップしました");
				}
			case "add":
				if(args.length > 1) {
					Player p = Bukkit.getPlayer(args[1]);
					if(!p.equals(null)) {
						if(!JinroMC.joinList.contains(p)) {
							JinroMC.joinList.add(p);
							sender.sendMessage("[JinroMC]" + p.getName() + "をゲームに参加させました");
							p.sendMessage("[JinroMC]ゲームに参加しました");
						}
						else {
							sender.sendMessage("[JinroMC]該当プレイヤーは既にゲームに参加しています");
						}
					}
					else {
						sender.sendMessage("[JinroMC]該当プレイヤーは存在しません");
					}
				}
				else {
					sender.sendMessage("[JinroMC]プレイヤー名を入力してください");
				}
				break;
			case "remove":
				if(args.length > 1) {
					Player p = Bukkit.getPlayer(args[1]);
					if(!p.equals(null)) {
						if(JinroMC.joinList.contains(p)) {
							JinroMC.joinList.remove(p);
							sender.sendMessage("[JinroMC]" + p.getName() + "をゲームから削除しました");
							p.sendMessage("[JinroMC]ゲームから削除されました");
						}
						else {
							sender.sendMessage("[JinroMC]該当プレイヤーは既にゲームから削除されています");
						}
					}
					else {
						sender.sendMessage("[JinroMC]該当プレイヤーは存在しません");
					}
				}
				else {
					sender.sendMessage("[JinroMC]プレイヤー名を入力してください");
				}
				break;
			case "reload":
				if(JinroMC.time != GameTime.Before) {
					sender.sendMessage("[JinroMC]ゲーム中はコンフィグを再ロードできません");
				}
				else {
					JinroMC.config.loadConfig();
				}
				break;
			default:
				sender.sendMessage("------------------- JinroMC Help -------------------");
				sender.sendMessage("/jinro start: ゲームを開始します");
				sender.sendMessage("/jinro stop: ゲームを停止します");
				sender.sendMessage("/jinro skip: 現在のターンをスキップします");
				sender.sendMessage("/jinro add <player>: playerをゲームに追加します");
				sender.sendMessage("/jinro remove <player>: playerをゲームから削除します");
				sender.sendMessage("/jinro reload: コンフィグを再ロードします");
				sender.sendMessage("----------------------------------------------------");
		}
		return true;
	}

}
