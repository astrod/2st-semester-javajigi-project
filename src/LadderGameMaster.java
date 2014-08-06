import java.util.ArrayList;
/*
 * 레더 게임 마스터는 게임을 전체적으로 총괄하는 클래스이다. 이 클래스에서는 다른 클래스에 객체를 요청하여, 사다리게임을 시작하는 역할을 맡는다.
 * 즉 사다리를 타고 내려와서 어디로 도달하는지를 확인하는 일을 한다.
 */

public class LadderGameMaster {
	int endPos;
	
	public static final int LEFT = -1;
	public static final int RIGHT = -2;
	
	public int searchArray(int startNum, ArrayList<LadderCol> ladderList, LadderMap map) {
		//시작 번호를 찾는다.
		//예외처리를 실시한다. 입력한 숫자가 리스트에 있는 숫자보다 크거나, 1보다 작으면 에러를 발생시킨다. 이 코드는 try - catch로 나중에 변경해야 할 거 같다.
		if(startNum > ladderList.size() || startNum < 1) {
			return -1;
		}
		
		//ArrayList전체를 돌면서 startNum에 입력된 값을 찾고, 찾았으면 인자로 넘겨서 goPath함수를 출력한다.
		for(int i=0; i<ladderList.size(); i++) {
			if(ladderList.get(i).ladderArray[0] == startNum) {
				goPath(ladderList.get(i), 1, map);
			}
		}
		return endPos;
	}
	
	//자기 자신을 재귀호출하여 사다리를 타고 내려가는 메소드이다. 
	private void goPath(LadderCol startObject, int startIndex, LadderMap map) {
		map.drawMap(startObject, startIndex);
		
		//종료조건 
		if(startObject.ladderArray[startIndex] >= 1) {
			endPos = startObject.ladderArray[startIndex];
			startObject.ladderArray[startIndex] = startObject.ladderArray[startIndex];
		}
		
		if(startObject.ladderArray[startIndex] == 0) goPath(startObject, startIndex+1, map);
		
		if(startObject.ladderArray[startIndex] == LEFT) goPath(startObject.preLadder, startIndex+1, map);		
		
		if(startObject.ladderArray[startIndex] == RIGHT) goPath(startObject.postLadder, startIndex+1, map);
		
	}
	
	

}
