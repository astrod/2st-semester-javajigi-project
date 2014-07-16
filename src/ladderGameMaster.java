import java.util.ArrayList;


public class LadderGameMaster {
	int endPos;
	
	
	public int searchArray(int startNum, ArrayList<LadderCol> ladderList) {
		//시작 번호를 찾는다.
		
		//예외처리를 실시한다. 입력한 숫자가 리스트에 있는 숫자보다 크거나, 1보다 작으면 에러를 발생시킨다. 이 코드는 try - catch로 나중에 변경해야 할 거 같다.
		if(startNum > ladderList.size() || startNum < 1) {
			return -1;
		}
		
		//ArrayList전체를 돌면서 startNum에 입력된 값을 찾고, 찾았으면 인자로 넘겨서 goPath함수를 출력한다.
		for(int i=0; i<ladderList.size(); i++) {
			if(ladderList.get(i).ladderArray[0] == startNum) {
				goPath(ladderList.get(i), 1);
			}
		}
		return endPos;
	}
	
	
	private void goPath(LadderCol startObject, int startIndex) {
		
		if(startObject.ladderArray[startIndex] >= 1) endPos = startObject.ladderArray[startIndex];
		if(startObject.ladderArray[startIndex] == 0) goPath(startObject, startIndex+1);
		if(startObject.ladderArray[startIndex] == -1) goPath(startObject.preLadder, startIndex+1);		
		if(startObject.ladderArray[startIndex] == -2) goPath(startObject.postLadder, startIndex+1);
		
		
	}

}
