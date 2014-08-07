/* 사다리 세로줄 객체인 LadderCol로, 외부로부터 이 객체가 해 주었으면 하는 명령을 받아 수행한다.
 * 하는 기능으로는 선을 긋거나, 입력받은 값을 가지고 사다리의 시작 객체를 찾거나, 재귀적으로 사다리를 타고 내려가거나, 자기 자신을 시각화하는 메소드가 존재한다.
 */

public class LadderCol {
	/**
	 * 각 int값. 즉 사다리의 각 점을 객체 추출해 본다.
	 * 객체로 추출한 후 로직을 이 객체로 위임하는 리팩토링 해본다. from javajigi
	 */
	private int [] colLadderArray;
	private LadderCol preLadder;
	private LadderCol postLadder;
	
	/**
	 * Direction과 같은 이름으로 enum을 만들어 제거해 본다.
	 */
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
		/**
		 * 앞에서 각 점을 담당하는 객체를 추출한다면 이 로직을 추출한 객체에 위임해서 작업 가능하도록 리팩토링해본다. from javajigi
		 */
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

			/**
			 * LadderCol의 drawCol method의 다음 if/else 제거해 본다.
			 * Direction과 같은 enum 클래스를 만든 후 제거할 수 있는 방법을 찾아본다. from javajigi
			 */
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
		/**
		 * 이런 경우 굳이 else를 사용하지 않아도 된다.
		 */
		else return false;
	}
}
