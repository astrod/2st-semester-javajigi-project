
public class LadderCol {
	public int [] ladderArray;
	public LadderCol preLadder;
	public LadderCol postLadder;
	

	
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
	
	public void drawCol(int row) {
		String colString = "";
		for (int r = 0; r < ladderArray.length; r++) {
			int i = ladderArray[r];
			if (r == row)
				colString += "★";
			else colString += "━";

			if (i == -1)
				colString += "┻";
			else if (i == -2)
				colString += "┳";
			else
				colString += "━";

		}
		System.out.println(colString);
	}

	public void drawRow() {
		String colString = "";
		for (int i : ladderArray) {
			if (i == -2) {
				colString += "┃꓅";
			}
			else colString += "꓅꓅";
		}
		System.out.println(colString);
	}
}
