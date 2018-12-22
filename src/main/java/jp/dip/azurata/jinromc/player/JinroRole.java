package jp.dip.azurata.jinromc.player;

public enum JinroRole {
	werewolf("人狼"),
	madman("狂人"),
	fox("妖狐"),
	seer("占い師"),
	psychic("霊能者"),
	knight("騎士"),
	villager("村人");

	private String name;

	private JinroRole(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
