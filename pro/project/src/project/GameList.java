package project;

import java.util.ArrayList;
import java.util.List;

public class GameList {
	
	private List<GameInfomation> gameList = new ArrayList<GameInfomation>();

	public GameList() {}

	public GameList(List<GameInfomation> gameList) {
		super();
		this.gameList = gameList;
	}
	
	
	public List<GameInfomation> getGameList() {
		return gameList;
	}

	public void setGameList(List<GameInfomation> gameList) {
		this.gameList = gameList;
	}

}
