package jp.dip.azurata.jinromc;

public enum GameTime {
	Before("ゲーム前"),
	Night("夜"),
	Day("昼"),
	VoteTime("投票時間");

	private String name;

	private GameTime(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
