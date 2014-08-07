/*
 * 사다리의 세로줄 역할을 하는 클래스이다. 그러므로 이 클래스에선 사다리의 새로줄의 숫자를 보관하는 인스턴스 변수가 존재한다. 
 * 또한 직접적으로 사다리를 시작화하는 메소드도 존재한다. 
 */

public class LadderCol {
	public int [] ladderArray;
	public LadderCol preLadder;
	public LadderCol postLadder;
	
	public static final int LEFT = -1;
	public static final int RIGHT = -2;

	
	public LadderCol(int ladderRowSize) {
		ladderArray = new int [ladderRowSize];
	}
	

	public LadderCol getPreLadder() {
		return preLadder;
	}
	public void setPreLadder(LadderCol preLadder) {
		this.preLadder = preLadder;
	}
	public LadderCol getPostLadder() {
		return postLadder;
	}
	public void setPostLadder(LadderCol postLadder) {
		this.postLadder = postLadder;
	}
	
	//사다리의 세로줄을 그린다. 
	public void drawCol(int row) {
		String colString = "";
		//사다리의 세로줄을 돌면서 조건을 확인하여 그린다.
		for (int curNum = 0; curNum < ladderArray.length; curNum++) {
			int i = ladderArray[curNum];
		
			if (curNum == row)
				colString += "★";
			else colString += "━";

			/**
			 * 다음 if/else 제거해 본다.
			 * 각 상태에 대한 enum 또는 클래스를 만들어 제거 가능하다.
			 * 객체 지향의 다형성 개념 활용해 제거 시도해 본다. from javajigi
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
}
