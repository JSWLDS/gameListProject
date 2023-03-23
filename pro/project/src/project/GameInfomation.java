package project;

public class GameInfomation {

	private String gameDeveloper;
	private String gameGenre;
	private String gameName;

	public GameInfomation(String gameDeveloper, String gameGenre, String gameName) {
		super();
		this.gameDeveloper = gameDeveloper;
		this.gameGenre = gameGenre;
		this.gameName = gameName;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public String getGameDeveloper() {
		return gameDeveloper;
	}

	public void setGameDeveloper(String gameDeveloper) {
		this.gameDeveloper = gameDeveloper;
	}

	public String getGenre() {
		return gameGenre;
	}

	public void setGenre(String gameGenre) {
		this.gameGenre = gameGenre;
	}
	
}
