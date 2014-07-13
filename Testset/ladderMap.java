
public class ladderMap {

	public int playerNum;
	public int[][] Array;
	
	ladderMap(int playerNum) {
		this.playerNum = playerNum;
		Array = new int[12][playerNum];
		
		//생성자에서 Array에 필요한 값을 입력함
		for(int i =0; i<playerNum; i++) {
			Array[0][i] = i+1;
		}
		for(int i =0; i<playerNum; i++) {
			Array[11][i] = i+1;
		}
		
	}
	
}
