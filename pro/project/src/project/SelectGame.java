package project;

import java.util.ArrayList;
import java.util.List;

public class SelectGame {
	
	public SelectGame() {}
	
	public void selectGameDeveloper(GameList gameList, String keyword) {
		
		int cnt = 0;
		
		System.out.println("=============제작사===============장르===================이름=========");
		System.out.println();
		for(int i=0; i<gameList.getGameList().size(); i++) {
			if(gameList.getGameList().get(i).getGameDeveloper().equals(keyword)) {
				System.out.printf("     %10s%20s%19s\n"
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
		
		System.out.println("=============제작사===============장르===================이름=========");
		System.out.println();
		for(int i=0; i<gameList.getGameList().size(); i++) {
			if(gameList.getGameList().get(i).getGameName().equals(keyword)) {
				System.out.printf("     %10s%20s%19s\n"
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
	public void selectGenre(GameList gameList, String keyword) {
		
		int cnt = 0;
		
		System.out.println("=============제작사===============장르===================이름=========");
		System.out.println();
		for(int i=0; i<gameList.getGameList().size(); i++) {
			if(gameList.getGameList().get(i).getGenre().equals(keyword)) {
				System.out.printf("     %10s%20s%19s\n"
            			, gameList.getGameList().get(i).getGameDeveloper()
            			, gameList.getGameList().get(i).getGenre()
            			, gameList.getGameList().get(i).getGameName());
            }
			cnt++;
		}
		if(cnt == 0) {
			System.out.println("ERROR : 검색한 게임이 존재하지 않습니다.");
		}
		System.out.println();	
		
	}

	public boolean selectGame(String gameDeveloper, String gameGenre, String gameName, GameList gameList) {
		
		boolean exist = false;
		
		for(int i=0; i<gameList.getGameList().size(); i++) {
			
			String genre = gameList.getGameList().get(i).getGenre();
			String developer = gameList.getGameList().get(i).getGameDeveloper();
			String name = gameList.getGameList().get(i).getGameName();
			
			if( developer.equals(gameDeveloper) && genre.equals(gameGenre) && name.equals(gameName)) {
				exist = true;
            }
		}
		
		return exist;
	}

	//입력한 정보들을 모든 게임객체 정보가 담겨있는 gameList 객체에서 등록할 게임의 정보가 중복되는지 검사함.
	public List<String> deduplication(List<String> getGameDeveloper, GameList gameList) {

        for(int i = 0; i < gameList.getGameList().size(); i++) {
        	if(getGameDeveloper.size() <= 0) {
        		getGameDeveloper.add(gameList.getGameList().get(i).getGameDeveloper());
        	}
        	else {
            	for(int j=0; j<getGameDeveloper.size(); j++) {
            		if(gameList.getGameList().get(i).getGameDeveloper().equals(getGameDeveloper.get(j))) {
            			continue;
            		}
            		getGameDeveloper.add(gameList.getGameList().get(i).getGameDeveloper());
        		}
        	}
        }
		return getGameDeveloper;
	}
	
}
