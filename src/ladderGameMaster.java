
public class ladderGameMaster {

	public int searchArray(int startNum, ladderMap map) {
		//시작점을 찾는다.
		
		if(startNum > map.playerNum || startNum < 1) {
			return -1;
		}
		
		int rowPos = 0;
		int colPos = 0;
		
		for(int i=0; i<map.playerNum; i++) {
			if(map.Array[0][i] == startNum) {
				rowPos = 0;
				colPos = i;
			}
		}
		
		return goPath(rowPos, colPos, map);
	}

	private int goPath(int rowPos, int colPos, ladderMap map) {
		rowPos += 1;
		
		while(true) {
			switch (map.Array[rowPos][colPos]) {
			case 0:
				rowPos +=1;
				break;

			case -1:
				rowPos +=1;
				colPos -=1;
				break;
			
			case -2:
				rowPos +=1;
				colPos +=1;
				break;
				
			default:
				return map.Array[rowPos][colPos];
			}
		}
	}

}
