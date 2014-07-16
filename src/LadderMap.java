import java.util.ArrayList;


public class LadderMap {

	public int ladderRowNum;
	public int playerNum;
	private ArrayList<LadderCol> ladderObjectList;
	
	public ArrayList<LadderCol> getLadderObjectList() {
		return ladderObjectList;
	}
	
	public int getLadderRowNum() {
		return ladderRowNum;
	}
	
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
	
	
	
	private void setLine(int row, int col, String dir) {
		if(col < 1) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");
			return;
		}
		if(col > ladderObjectList.size()) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");
			return;
		}
		
		if(row > ladderRowNum - 2) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");
			return;
			
		}
		
		if(row < 1) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");			
			return;
		}
		
		if(col == 1 && dir == "left") {
			System.out.println("왼쪽으로 선을 그을 수 없습니다. 다시 입력하십시오 ");
			return;
		}
		
		if(col == playerNum && dir == "right") {
			System.out.println("오른쪽으로 선을 그을 수 없습니다. 다시 입력하십시오 ");
			return;
		}
		
		if(dir == "left") ladderObjectList.get(col-1).ladderArray[row] = -1;
		if(dir == "right") ladderObjectList.get(col-1).ladderArray[row] = -2;
	}
	
	public void drawTwoLineFromLefttoRight(int row, int col) {
		setLine(row, col, "right");
		setLine(row, col+1, "left");
	}
	
	
	
}
