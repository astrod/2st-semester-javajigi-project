
public class ladderPlayer {

	private void setLine(int row, int col, ladderMap map, String dir) {
		if(col < 1) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");
			return;
		}
		if(col > map.Array[0].length) {
			System.out.println("잘못 입력하셨습니다. 다시 입력해 주십시오 ");
			return;
		}
		
		if(row > 10) {
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
		
		if(col == 6 && dir == "right") {
			System.out.println("오른쪽으로 선을 그을 수 없습니다. 다시 입력하십시오 ");
			return;
		}
		
		if(dir == "left") map.Array[row][col-1] = -1;
		if(dir == "right") map.Array[row][col-1] = -2;
	}
	
	public void drawTowLineFromLefttoRight(int row, int col, ladderMap map) {
		setLine(row, col, map, "right");
		setLine(row, col+1, map, "left");
	}

}
