package project;

public class SelectGame {
	
	public SelectGame() {}
	
	public void selectGameDeveloper(GameList gameList, String keyword) {
		
		int cnt = 0;
		
		System.out.println("=============제작사==============장르====================이름=========");
		System.out.println();
		for(int i=0; i<gameList.getGameList().size(); i++) {
			if(gameList.getGameList().get(i).getGameDeveloper().equals(keyword)) {
				System.out.printf("     %10s%20s%20s\n"
            			, gameList.getGameList().get(i).getGameDeveloper()
            			, gameList.getGameList().get(i).getGenre()
            			, gameList.getGameList().get(i).getGameName());
				cnt++;
            }
		}
		if(cnt == 0) {
			System.out.println("ERROR : 검색한 게임이 존재하지 않습니다.");
		}
		System.out.println();	
		
	}
	
	public void selectGameName(GameList gameList, String keyword) {
		
		int cnt = 0;
		
		System.out.println("=============제작사==============장르====================이름=========");
		System.out.println();
		for(int i=0; i<gameList.getGameList().size(); i++) {
			if(gameList.getGameList().get(i).getGameName().equals(keyword)) {
				System.out.printf("     %10s%20s%20s\n"
            			, gameList.getGameList().get(i).getGameDeveloper()
            			, gameList.getGameList().get(i).getGenre()
            			, gameList.getGameList().get(i).getGameName());
            }
		}
		if(cnt == 0) {
			System.out.println("ERROR : 검색한 게임이 존재하지 않습니다.");
		}
		System.out.println();	
		
	}
	public void selectGenre(GameList gameList, String keyword) {
		
		int cnt = 0;
		
		System.out.println("=============제작사==============장르====================이름=========");
		System.out.println();
		for(int i=0; i<gameList.getGameList().size(); i++) {
			if(gameList.getGameList().get(i).getGenre().equals(keyword)) {
				System.out.printf("     %10s%20s%20s\n"
            			, gameList.getGameList().get(i).getGameDeveloper()
            			, gameList.getGameList().get(i).getGenre()
            			, gameList.getGameList().get(i).getGameName());
            }
		}
		if(cnt == 0) {
			System.out.println("ERROR : 검색한 게임이 존재하지 않습니다.");
		}
		System.out.println();	
		
	}

	public boolean selectGame(String gameDeveloper, String gameGenre, String gameName, GameList gameList) {
		
		boolean exist = true;
		
		for(int i=0; i<gameList.getGameList().size(); i++) {
			String genre = gameList.getGameList().get(i).getGenre();
			String developer = gameList.getGameList().get(i).getGameDeveloper();
			String name = gameList.getGameList().get(i).getGameName();
			if( developer.equals(gameDeveloper) && genre.equals(gameGenre) && name.equals(gameName)) {
				exist = false;
            }
		}
		
		return exist;
	}
	
}
