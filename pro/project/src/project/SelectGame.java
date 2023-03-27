package project;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SelectGame {
	
	public SelectGame() {}
	
	// 입력받은 제작사와 같은 제작사를 가진 게임을 모두 출력한다.
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
		// 아무것도 없으면 ERROR 출력.
		if(cnt == 0) {
			System.out.println("ERROR : 검색한 게임이 존재하지 않습니다.");
		}
		System.out.println();	
		
	}
	
	// 입력받은 이름과 같은 이름을 가진 게임을 모두 출력한다.
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
		// 아무것도 없으면 ERROR 출력.
		if(cnt == 0) {
			System.out.println("ERROR : 검색한 게임이 존재하지 않습니다.");
		}
		System.out.println();	
		
	}
	
	// 입력받은 장르와 같은 장르를 가진 게임을 모두 출력한다.
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
		// 아무것도 없으면 ERROR 출력.
		if(cnt == 0) {
			System.out.println("ERROR : 검색한 게임이 존재하지 않습니다.");
		}
		System.out.println();	
		
	}

	// 추가 및 변경할 게임의 제작사, 장르, 이름과 같은 게임이 이미 존재하면 false를 반환한다.
	public boolean selectGame(String gameDeveloper, String gameGenre, String gameName, GameList gameList) {
		
		// 기본값 true.
		boolean exist = false;
		
		for(int i=0; i<gameList.getGameList().size(); i++) {
			
			String genre = gameList.getGameList().get(i).getGenre();
			String developer = gameList.getGameList().get(i).getGameDeveloper();
			String name = gameList.getGameList().get(i).getGameName();
			
			// 존재하면 존재여부를 false로 초기화.
			if( developer.equals(gameDeveloper) && genre.equals(gameGenre) && name.equals(gameName)) {
				exist = true;
            }
		}
		
		// 존재여부 반환.
		return exist;
	}

	//입력한 정보들을 모든 게임객체 정보가 담겨있는 gameList 객체에서 등록할 게임의 정보가 중복되는지 검사함.
	public List<String> deduplication(List<String> getGameDeveloper, GameList gameList) {

		// 모든 제작사를 가져오기 위해 저장된 게임만큼 반복한다.
        for(int i = 0; i < gameList.getGameList().size(); i++) {
        
        	getGameDeveloper.add(gameList.getGameList().get(i).getGameDeveloper());
	
        }
        
        // HashSer 객체를 이용하여 중복된 데이터를 제거한다.
    	HashSet<String> setDeduplication = new HashSet<>(getGameDeveloper);
    	
    	// 중복된 데이터를 없앤 객체를 ArrayList객체로 제작사 list객체에 초기화 하였다.
    	getGameDeveloper = new ArrayList<String>(setDeduplication);
        
        // 모든 제작사가 저장된 객체를 반환한다.
		return getGameDeveloper;
	}
	
}
