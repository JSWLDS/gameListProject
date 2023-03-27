package project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
	
		GameList gameList = new GameList();  // 모든 게임 객체를 담을 gameList 클래스 객체 생성
		Scanner sc = new Scanner(System.in); // console로 입력 받기 때문에 Scanner 클래스 객체 생성.
		SelectGame selectGame = new SelectGame(); // 검색한 결과를 검색하여 출력하거나, 중복된 게임을 검색하여 boolean 값을 반환하는 클래스 객체 생성.
		
		// 게임 list 객체에 기본 값을 설정하여 테스트에 편의성을 높임.
		gameList.getGameList().add(new GameInfomation("라이엇", "MOBA", "리그오브레전드"));  // 제작사, 장르, 게임 이름
		gameList.getGameList().add(new GameInfomation("블리자드", "FPS", "오버워치"));
		gameList.getGameList().add(new GameInfomation("넥슨", "MMORPG", "메이플스토리"));
		gameList.getGameList().add(new GameInfomation("넥슨", "캐주얼레이싱", "카트라이더"));
		gameList.getGameList().add(new GameInfomation("모장", "오픈월드", "마인크래프트"));
		gameList.getGameList().add(new GameInfomation("호요버스", "오픈월드", "원신"));
		gameList.getGameList().add(new GameInfomation("네오플", "MORPG", "던전앤파이터"));
		gameList.getGameList().add(new GameInfomation("유비소프트", "FPS", "레인보우식스시즈"));
		gameList.getGameList().add(new GameInfomation("넥슨", "스포츠", "피파온라인4"));
		gameList.getGameList().add(new GameInfomation("블리자드", "ARPG", "디아블로4"));
		
		
		
		
	      while(true) { // 사용자가 종료를 원할 때 까지 서비스를 이용하게 하기위해 while문의 조건을 true로 하였다.  
    	  
            System.out.println("1. 등록 | 2. 조회(전체) | 3. 검색 | 4. 수정 | 5. 삭제 | 6. 종료"); // 기능 종류
            System.out.print("번호를 선택하시오 : ");	             
        	
            switch (sc.nextInt()) { // 정수형으로 입력받아 기능을 선택할 수 있게 switch문을 사용하였다.
            
            case 1: // 등록 기능
            	
                System.out.println("==================게임 등록=================");
                // 등록할 게임의 이름, 장르, 제작사를 문자열로 입력받는다.
                String gameName, gameDeveloper, gameGenre;
                System.out.print("게임 이름 : "); gameName = sc.next();
                System.out.print("게임 장르 : "); gameGenre = sc.next();
                System.out.print("게임 제작사 : "); gameDeveloper = sc.next(); 
               
                // 등록할 게임의 정보가 이미 있는지 검사함.               
                System.out.println();
              	if(selectGame.selectGame(gameDeveloper, gameGenre, gameName, gameList)) { // 등록할 게임이 이미 존재하면 문구 출력하고 넘어감.
              		System.out.println("ERROR : 이미 존재하는 게임입니다.");
              	} else { // 등록할 게임이 존재하지 않으면 gameList에 등록한다.
              		gameList.getGameList().add(new GameInfomation(gameDeveloper, gameGenre, gameName));
              		System.out.println("등록 완료");
              	}
              	System.out.println();
                break;

            case 2:		
            	
            	// 저장된 모든 게임을 출력하기 위해 제작사를 기준으로 정렬하여 출력하게한다.
            	// 그래서 저장된 제작사를 list로 담기위해 list 객체를 만들었다.
                List<String> getGameDeveloper = new ArrayList<String>(); 
                
                // 중복 없는 제작사 list 완성.
                getGameDeveloper = selectGame.deduplication(getGameDeveloper, gameList);

            	System.out.println("=============제작사===============장르===================이름=========");
            	System.out.println();
            	
            	// 2중 for문을 이용하여 모든 게임의 제작사를 중복이 제거된 제작사 list객체의 값과 순서대로 검사하여 출력한다.
                for(int i=0; i<getGameDeveloper.size(); i++) {
                	for(int j=0; j<gameList.getGameList().size(); j++) {
	                	if(getGameDeveloper.get(i).toString().equals(gameList.getGameList().get(j).getGameDeveloper().toString())) {
	                		System.out.printf("     %10s%20s%19s\n"
		                			, gameList.getGameList().get(j).getGameDeveloper()
		                			, gameList.getGameList().get(j).getGenre()
		                			, gameList.getGameList().get(j).getGameName());
		                }
                	}
        		}
                System.out.println();
        		System.out.println("=================================================================");
                break;
                
            case 3 :
            	
            	// 검색할 키워드 출력.
            	System.out.print("검색 키워드를 입력하세요 [ 1 : 제작사 | 2 : 장르 | 3 : 이름 ] : ");
            	int num = sc.nextInt();
            	
            	// 키워드별로 검색하여 출력한다.
            	if(num == 1) {
            		
            		System.out.print("검색할 제작사를 입력하세요 : ");
            		String keyword = sc.next();      	
            		selectGame.selectGameDeveloper(gameList, keyword);
            		
               	} else if(num == 2) {
            		
            		System.out.print("검색할 장르를 입력하세요 : ");
            		String keyword = sc.next();
            		selectGame.selectGenre(gameList, keyword);
            		
            	} else if(num == 3) {
            		
            		System.out.print("검색할 게임 이름을 입력하세요 : ");
            		String keyword = sc.next();
            		selectGame.selectGameName(gameList, keyword);
            		
            	} else {
            		
            		System.out.println("ERROR : 잘못 입력하셨습니다.");
            		
            	}
            	System.out.println("=================================================================");
            	System.out.println();
            	break;
            	
            case 4 :
            	
            	System.out.print("변경할 게임 이름을 입력하세요 : ");
        		String keyword_4 = sc.next();
        		int errorCount = 0;
        		for(int i=0; i<gameList.getGameList().size(); i++) {
        			if(gameList.getGameList().get(i).getGameName().equals(keyword_4)) {
        				System.out.print("변경할 키워드를 입력하세요 [ 1 : 제작사 | 2 : 장르 | 3 : 이름 | 4 : 모두 ] : ");
                    	int num1 = sc.nextInt();
                    	boolean success = false;
                    	
                    	if(num1 == 1) {

                    		System.out.print("새로운 제작사 이름을 입력하세요 : ");
                    		String newDeveloper = sc.next();
                    		
                    		// 중복 검사 메소드를 호출하여 중복을 검사함.
                    		if(selectGame.selectGame(newDeveloper, gameList.getGameList().get(i).getGenre(), gameList.getGameList().get(i).getGameName(), gameList)) {
                    			System.out.println();
                    			System.out.println("ERROR : 새로운 이름이 이미 존재합니다.");
                    			break;
                    		}
                    		else { // 중복이 없으면 변경.
                    			gameList.getGameList().get(i).setGameDeveloper(newDeveloper);
                    			success = true;
                    		}
                    		
                    	} else if(num1 == 2) {
                    		
                    		System.out.print("새로운 장르를 입력하세요 : ");
                    		String newGenre = sc.next();
                    		
                    		// 중복 검사 메소드를 호출하여 중복을 검사함.
                    		if(selectGame.selectGame(gameList.getGameList().get(i).getGameDeveloper() , newGenre, gameList.getGameList().get(i).getGameName(), gameList)) {
                    			System.out.println();
                    			System.out.println("ERROR : 새로운 이름이 이미 존재합니다.");
                    			break;
                    		}
                    		else { // 중복이 없으면 변경.
                    			gameList.getGameList().get(i).setGenre(newGenre);
                    			success = true;
                    		}
                    		
                    		
                    	} else if(num1 == 3) {
                    		
                      		System.out.print("새로운 게임 이름을 입력하세요 : ");
                    		String newGameName = sc.next();
                    		
                    		// 중복 검사 메소드를 호출하여 중복을 검사함.
                    		if(selectGame.selectGame(gameList.getGameList().get(i).getGameDeveloper() , gameList.getGameList().get(i).getGenre(), newGameName, gameList)) {
                    			System.out.println();
                    			System.out.println("ERROR : 새로운 이름이 이미 존재합니다.");
                    		}
                    		else { // 중복이 없으면 변경.
                    			gameList.getGameList().get(i).setGameName(newGameName);
                    			success = true;
                    		}
                    		
                    	}  else if(num1 == 4) {
		
                    		System.out.print("새로운 제작사 이름을 입력하세요 : ");
                    		String newDeveloper = sc.next();
                    		
                    		System.out.print("새로운 장르를 입력하세요 : ");
                    		String newGenre = sc.next();
                    		
                    		System.out.print("새로운 게임 이름을 입력하세요 : ");
                    		String newGameName = sc.next();
                    		
                    		// 중복 검사 메소드를 호출하여 중복을 검사함.
                    		if(selectGame.selectGame(newGameName, newGenre, newGameName, gameList)) {
                    			System.out.println();
                    			System.out.println("ERROR : 새로운 이름이 이미 존재합니다.");
                    			break;
                    		}
                    		else { // 중복이 없으면 변경.
                    			
                    			gameList.getGameList().get(i).setGameDeveloper(newDeveloper);
                        		gameList.getGameList().get(i).setGenre(newGenre);
                        		gameList.getGameList().get(i).setGameName(newGameName);
                        		
                    			success = true;
                    		}  		
                    	}
                    	if(success) { // 변경이 정상적으로 완료 되었으면 알림을 출력.
                        	System.out.println();
                    		System.out.println("변경되었습니다.");	
                    	}
                      	System.out.println();
        			}else { // 검색한 게임이 존재하지 않으면 ERROR 출력.
        				errorCount++;
        				if(errorCount >= gameList.getGameList().size()) {
        					System.out.println();
        					System.out.println("ERROR : 해당 게임을 찾을 수 없습니다.");
        					break;
        				}
        			}
        		}
            	break;
            	
            case 5 :
            	
            	System.out.print("삭제할 게임의 이름을 입력하세요 : ");
            	String keyword_5 = sc.next();
            	boolean exist = false;
            	
            	// 삭제할 게임이 존재하면 삭제를 진행한다.
            	for(int i=0; i<gameList.getGameList().size(); i++) {
        			if(gameList.getGameList().get(i).getGameName().equals(keyword_5)) {
        				gameList.getGameList().remove(i);
        				// 존재하면 true로 초기화한다.
        				exist  = true;
        			}
        		}
            	System.out.println();
            	
            	// 존재하지 않으면 ERROR 출력.
            	if(exist == false) {
            		System.out.println("ERROR : 삭제할 게임이 존재하지 않습니다.");
            	} else { // 존재하면 알림 출력.
            		System.out.println("삭제되었습니다.");
            	}
              	System.out.println();
            	break;
            	
            case 6:
            	// 종료를 선택하면 return으로 프르세스 종료.
            	System.out.println();
                System.out.println("종료되었습니다.");
                sc.close();
                return;
                
            default: // 오류 출력
                throw new IllegalArgumentException("Unexpected value: ");
            }
        }
	}

}

