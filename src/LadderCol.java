
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
}
