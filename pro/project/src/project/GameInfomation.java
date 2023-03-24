package project;

public class GameInfomation { // 게임 정보 객체를 저장하는 클래스

	private String gameDeveloper; // 제작사
	private String gameGenre; // 장르
	private String gameName; // 이름

	public GameInfomation(String gameDeveloper, String gameGenre, String gameName) { // 생성자로 변수 초기화
		super();
		this.gameDeveloper = gameDeveloper;
		this.gameGenre = gameGenre;
		this.gameName = gameName;
	}

	// getter, setter 메소드를 이용하여 변수 값을 반환 및 초기화.
	
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
