/* LadderMap 함수는 게임에서 사용하는 사다리 맵을 다룬다. 사다리에 선을 긋고, 세로줄 객체를 생성해서 객체끼리 연결시키고
 * 배열에 초기값을 입력하는 일을 한다.
 */

import java.util.ArrayList;
import java.util.Random;


public class LadderMap {
	private ArrayList<LadderCol> colArray;
	private int playerNum;
	private int verticalSize;
	
	LadderMap(int playerNum, int verticalSize) {
		this.playerNum = playerNum;
		this.verticalSize = verticalSize+2;
		
		initSetting();
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	
	//맨 처음에 동작하는 method. ArrayList를 초기화한다.
	private void initSetting() {
		colArray = new ArrayList<>();
		setLadderColObject();
		connectLadderCol();
		setFirstValue();
	}

	//LadderCol 객체들을 생성해서 ArrayList로 감싼다.
	private void setLadderColObject() {
		for(int i=0; i<playerNum; i++) {
			LadderCol col = new LadderCol(verticalSize);
			colArray.add(col);
		}		
	}
	
	//각각의 LadderCol객체에게 sendMsg를 해서, 서로 연결하라고 명령을 내린다.
	private void connectLadderCol() {
		colArray.get(0).connectOtherObject(null, colArray.get(1));
		for(int i=1; i<playerNum-1; i++) {
			colArray.get(i).connectOtherObject(colArray.get(i-1), colArray.get(i+1));
		}
		colArray.get(playerNum-1).connectOtherObject(colArray.get(playerNum-2), null);
	}
	
	//Array에 초기값을 입력하라고 send Msg를 한다.
	private void setFirstValue() {
		int i =1;
		for(LadderCol object : colArray) {
			/**
			 * object를 초기화하는데 자기 자신을 또 다시 인자로 전달할 필요는 없을 듯하다. 
			 * object에게 초기화하라는 메시지를 전달하고 자신의 작업은 끝난다.
			 * from javajigi
			 */
			object.setInitialValue(object, i);
			i += 1;
		}
	}
	
	/* 선을 그리는 함수를 다시 여기로 집어 넣었다. LadderMap에 있는 ArrayList가 전체 LadderCol 객체를 감싸고 있기 때문에,
	 * 자기 자신을 그린다는 의미로 이곳에 넣는 게 옳을 거라는 생각이 들었다.
	 * 이 함수는 rowNum, colNum의 순서대로 값을 입력받아서 각각의 세로줄 객체에다가 선을 이곳에다 그리라는 명령을 내리게 된다. 
	 * input 값의 좌표는, (1, 1) -> (1, 0)
	 * 				  (6, 1) -> (6, 0)
	 * 즉 이 사다리는 rowNum, colNum의 방식으로 input을 받고, rowNum은 원래 1부터 시작하므로 colNum만 -1을 해 주면 매핑이 된다
	 */
	public void setLine(int rowNum, int colNum) {
		colArray.get(colNum-1).setPrivateArrayRight(rowNum);
		colArray.get(colNum).setPrivateArrayLeft(rowNum);
	}

	//세로 줄 객체를 감싸고 있는 arrayList를 돌면서 입력받은 초기값과 같은 값이 존재하는지 확인한 후, 존재하면 그 세로줄 객체를 리턴한다.
	public LadderCol searchEqualNum(int startNum) {
		for (LadderCol ladderCol : colArray) {
			if(ladderCol.findNum(startNum) == 1) return ladderCol;
		}
		
		return null;
	}
	
	//맵을 그리는 함수이다. 테스트 함수에서 이 함수를 호출하며, 맵의 객체들을 얻어 와서, 현재 별이 위치한 곳인지 확인하고, 위치한 곳이라면 별을 그리는 함수를 호출, 아니면 그냥 선을 그리는 함수를 호출한다.
	public void drawMap(LadderCol a, int row) {
		int col = colArray.indexOf(a);
		for (int objectNum=0; objectNum<playerNum; objectNum++) {
			LadderCol column = colArray.get(objectNum);
			if (col == objectNum) {
				column.drawCol(row);
				continue;
			}
			column.drawCol(-1);
		}
		System.out.println("\n\n\n\n");
	}
	
	//랜덤하게 숫자를 생성해서 맵에 집어넣는 메서드이다. 맵 자기 자신의 값을 랜덤하게 세팅하기 때문에, LadderMap에 포함시켰다.
	public void makeRandomMap(int repeatNum) {
		Random random = new Random();

		for(int i=0; i<repeatNum; i++) {
			int colNum = random.nextInt(playerNum) + 1;
			int rowNum = random.nextInt(verticalSize-2)+1;

			if(checkBlank(rowNum, colNum)) setLine(rowNum, colNum);
		}
	}
	
	//그 칸에 선이 그어질 수 있는지 확인하는 역할을 한다.
	private boolean checkBlank(int rowNum, int colNum) {
		try {
			return colArray.get(colNum-1).checkBlank(rowNum) && colArray.get(colNum).checkBlank(rowNum);
		} catch(Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
