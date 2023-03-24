package project;

import java.util.ArrayList;
import java.util.List;

public class GameList { // 입력된 모든 게임들이 저장되는 List 객체 클래스
	
	private List<GameInfomation> gameList = new ArrayList<GameInfomation>(); // 게임 객체 클래스를 자료형으로 설정하여 여러 게임 객체를 담을 수 있음.

	public GameList() {} // 기본 생성자

	// getter, setter 메소드를 이용하여 게임 객체 리스트를 반환 및 초기화.
	public List<GameInfomation> getGameList() {
		return gameList;
	}

	public void setGameList(List<GameInfomation> gameList) {
		this.gameList = gameList;
	}

}
