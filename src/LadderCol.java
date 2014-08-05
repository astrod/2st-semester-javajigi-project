/* 사다리 세로줄 객체인 LadderCol로, 외부로부터 이 객체가 해 주었으면 하는 명령을 받아 수행한다.
 * 하는 기능으로는 선을 긋거나, 입력받은 값을 가지고 사다리의 시작 객체를 찾거나, 재귀적으로 사다리를 타고 내려가거나, 자기 자신을 시각화하는 메소드가 존재한다.
 */

public class LadderCol {
	private int [] colLadderArray;
	private LadderCol preLadder;
	private LadderCol postLadder;
	
	public static final int NORMAL = 0;
	public static final int LEFT = -1;
	public static final int RIGHT = -2;
	
	public LadderCol(int arrayCount) {
		colLadderArray = new int[arrayCount];
	}

	//좌우 사다리의 레퍼런스 변수를 받아서, 인스턴스 변수에 대입한다.
	public void connectOtherObject(LadderCol preLadder, LadderCol postLadder) {
		this.preLadder = preLadder;
		this.postLadder = postLadder;
	}

	//자기 사다리의 초기값을 입력한다.
	public void setInitialValue(LadderCol object, int count) {
		object.colLadderArray[0] = count;
		object.colLadderArray[colLadderArray.length-1] = count;
	}

	//오른쪽으로 이동하는 선을 긋는다. (왼쪽->오른쪽)
	public void setPrivateArrayRight(int rowNum) {
		colLadderArray[rowNum] = RIGHT;
	}
	//왼쪽으로 이동하는 선을 긋는다. (오른쪽->왼쪽)
	public void setPrivateArrayLeft(int rowNum) {
		colLadderArray[rowNum] = LEFT;
	}

	/* 입력값 : 찾고 싶은 숫자.
	 * 출력값 : 그 숫자가 있으면 1, 없으면 0을 리턴한다.
	 */
	public int findNum(int startNum) {
		if(colLadderArray[0] == startNum) return 1;
		return 0;
	}

	//재귀적으로 접근한다. 사다리를 타고 내려가서 LEFT, RIGHT에 맞춰서 재귀적으로 method를 호출한다.
	public void goAhead(int startIdx, LadderGameMaster master, LadderMap map) {
		
		//재귀함수의 종료조건.
		if(colLadderArray[startIdx] >= 1) master.endPos = colLadderArray[startIdx];
		
		//입력한 값에 맞춰서 사다리를 재귀적으로 내려간다.
		if(colLadderArray[startIdx] == NORMAL) master.goPath(this, startIdx+1, map);
		if(colLadderArray[startIdx] == LEFT) master.goPath(this.preLadder, startIdx+1, map);
		if(colLadderArray[startIdx] == RIGHT) master.goPath(this.postLadder, startIdx+1, map);
	}
	
	public void drawCol(int row) {
		String colString = "";
		//사다리의 세로줄을 돌면서 조건을 확인하여 그린다.
		for (int curNum = 0; curNum < colLadderArray.length; curNum++) {
			int i = colLadderArray[curNum];
		
			if (curNum == row)
				colString += "★";
			else colString += "━";

			if (i == LEFT)
				colString += "┻";
			else if (i == RIGHT)
				colString += "┳";
			else
				colString += "━";		
		}
		System.out.println(colString);
	}

	public boolean checkBlank(int rowNum) {
		if(colLadderArray[rowNum] == 0) return true;
		else return false;
	}
}
