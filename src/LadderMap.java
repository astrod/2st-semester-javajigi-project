import java.util.ArrayList;
import java.util.Random;

/*
LadderMap클래스는 사다리게임에서 Map을 다루는 역할을 한다. 또한 맵을 그리는 데 사용하는 자료구조를 저장하는 역할을 한다.
기본적으로 LadderCol 에서 제공하는 세로 줄 객체를 담는 ArrayList를 인스턴스 변수로 가지고 있다. 이 객체들을 생성하고 연결시키는
역할을 하는 메소드도 존재한다. 그 외에는 선을 그리고 맵을 시각화하는 메소드가 존재한다.
*/

public class LadderMap {

	public static final int LEFT = -1;
	public static final int RIGHT = -2;


	public int ladderRowNum;
	public int playerNum;
	private ArrayList<LadderCol> ladderObjectList;

	public ArrayList<LadderCol> getLadderObjectList() {
		return ladderObjectList;
	}

	public int getLadderRowNum() {
		return ladderRowNum;
	}
	
	//생성자이다. 특이한 점은 ladderRowNum에 받은 수의 +2를 해서 넣는다는 것이다. 이는 rowNum이 실제로는 플레이어가 원하는 수보다 2가 더 커야 하기 때문이다. 왜냐면 시작과 끝점에 어떤 플레이어가 참여할 것인지에 대한 내용이 들어가 있어야 하기 때문이다.
	LadderMap(int playerNum, int ladderRowNum) {
		this.playerNum = playerNum;
		this.ladderRowNum = ladderRowNum+2;

		initSetting();
	}


	private void initSetting() {

		//arrayList 에 LadderCol객체들을 저장한 후에, 각각 객체들을 연결시킴 
		ladderObjectList = new ArrayList<LadderCol>();

		createColObject();
		connectLadderColObject();
		setObjectArrayValue();		
	}


	//사다리 세로줄의 객체를 생성한다.
	private void createColObject() {
		for(int i=0; i<playerNum; i++) {			
			LadderCol col = new LadderCol(ladderRowNum);
			ladderObjectList.add(col);
		}
	}

	//객체들을 연결시켜서 좌우로 움직일 수 있게 한다.
	private void connectLadderColObject() {
		ladderObjectList.get(0).setPreLadder(null);
		ladderObjectList.get(0).setPostLadder(ladderObjectList.get(1));

		for(int i=1; i<playerNum-1; i++) {
			ladderObjectList.get(i).setPreLadder(ladderObjectList.get(i-1));
			ladderObjectList.get(i).setPostLadder(ladderObjectList.get(i+1));
		}
		ladderObjectList.get(playerNum-1).setPreLadder(ladderObjectList.get(playerNum-2));
		ladderObjectList.get(playerNum-1).setPostLadder(null);
	}

	//객체가 가지고 있는 Array에 초기값을 입력한다.
	private void setObjectArrayValue() {
		for(int i =0; i<playerNum; i++) {
			ladderObjectList.get(i).ladderArray[0] = i+1;
			ladderObjectList.get(i).ladderArray[ladderRowNum-1] = i+1;
		}
	}


	//선을 긋는다. 선을 긋기 전에 플레이어가 잘못 입력한 것인지 체크하고, 잘 입력했다면 선을 긋는다. 선은 왼쪽으로 긋는 경우에는 -1, 오른쪽으로 긋는 경우에는 -2를 사용한다.
	private void setLine(int colNum, int rowNum, String dir) {
		if(colNum < 1) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");
			return;
		}
		if(colNum > ladderObjectList.size()) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");
			return;
		}

		if(rowNum > ladderRowNum - 2) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");
			return;

		}

		if(rowNum < 1) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");			
			return;
		}

		if(colNum == 1 && dir == "left") {
			System.out.println("왼쪽으로 선을 그을 수 없습니다. 다시 입력하십시오 ");
			return;
		}

		if(colNum == playerNum && dir == "right") {
			System.out.println("오른쪽으로 선을 그을 수 없습니다. 다시 입력하십시오 ");
			return;
		}

		if(dir == "left") ladderObjectList.get(colNum-1).ladderArray[rowNum] = LEFT;
		if(dir == "right") ladderObjectList.get(colNum-1).ladderArray[rowNum] = RIGHT;
	}

	public void drawTwoLineFromLefttoRight(int colNum, int rowNum) {
		setLine(colNum, rowNum, "right");
		setLine(colNum+1, rowNum, "left");
	}
	
	//맵을 그리는 함수이다. 테스트 함수에서 이 함수를 호출하며, 맵의 객체들을 얻어 와서, 현재 별이 위치한 곳인지 확인하고, 위치한 곳이라면 별을 그리는 함수를 호출, 아니면 그냥 선을 그리는 함수를 호출한다.
		public void drawMap(LadderCol a, int row) {
			int col = ladderObjectList.indexOf(a);
			for (int objectNum=0; objectNum<playerNum; objectNum++) {
				LadderCol column = ladderObjectList.get(objectNum);
				if (col == objectNum) {
					column.drawCol(row);
					continue;
				}
				
				column.drawCol(-1);
			}
			System.out.println("\n\n\n\n");
		}
		
	//랜덤으로 선을 긋는 좌표를 생성해주는 메소드이다.
	public void makeRandomMap(int repeatNum) {
		Random random = new Random();

		for(int i=0; i<repeatNum; i++) {
			int colNum = random.nextInt(playerNum) + 1;
			int rowNum = random.nextInt(ladderRowNum-2)+1;

			System.out.println(colNum + ", " + rowNum);

			if(checkFourNearBlank(colNum, rowNum)) drawTwoLineFromLefttoRight(colNum, rowNum);
		}
	}

	//좌표를 찍었을 때, 그 곳에 선이 그어져도 괜찮은지 확인하는 메소드이다.
	private boolean checkFourNearBlank(int colNum, int rowNum) {
		/**
		 * 이 부분의 로직을 LadderCol이나 다른 곳으로 위임한다.
		 * (ladderObjectList.get(colNum-1).getPostLadder() == null)은 전형적으로 객체를 잘 활용하지 못하는 부분이다.
		 * 로직의 복잡도가 너무 높다. 
		 * 이 부분을 리팩토링하면서 객체 지향의 맛을 한번 느껴볼 수 있는 좋은 코드라 생각한다.
		 */
		boolean first = (ladderObjectList.get(colNum-1).ladderArray[rowNum] == 0);
		boolean second = (ladderObjectList.get(colNum-1).getPostLadder() == null) || (ladderObjectList.get(colNum).ladderArray[rowNum] == 0); 
		boolean third = (ladderObjectList.get(colNum-1).getPostLadder() == null) || (ladderObjectList.get(colNum-1).getPostLadder().getPostLadder() == null) || (ladderObjectList.get(colNum+1).ladderArray[rowNum] == 0);
		boolean fourth = (ladderObjectList.get(colNum-1).getPreLadder() == null) || (ladderObjectList.get(colNum-2).ladderArray[rowNum] == 0);

		return first && second && third && fourth;
	}

}



