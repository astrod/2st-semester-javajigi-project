import junit.framework.TestCase;


public class ladderTest extends TestCase {
	ladderGameMaster obj;
	ladderMap map;
	ladderPlayer player;
	
	
	protected void setUp() throws Exception {
		obj = new ladderGameMaster();
		map = new ladderMap(6);
		player = new ladderPlayer();
		
		
		player.drawTowLineFromLefttoRight(1, 1, map);
		player.drawTowLineFromLefttoRight(6, 1, map);
		player.drawTowLineFromLefttoRight(9, 1, map);
		player.drawTowLineFromLefttoRight(3, 2, map);
		player.drawTowLineFromLefttoRight(5, 2, map);
		player.drawTowLineFromLefttoRight(8, 2, map);
		player.drawTowLineFromLefttoRight(4, 3, map);
		player.drawTowLineFromLefttoRight(7, 3, map);
		player.drawTowLineFromLefttoRight(10, 3, map);
		player.drawTowLineFromLefttoRight(2, 4, map);
		player.drawTowLineFromLefttoRight(6, 4, map);
		player.drawTowLineFromLefttoRight(8, 4, map);
		player.drawTowLineFromLefttoRight(3, 5, map);
		player.drawTowLineFromLefttoRight(5, 5, map);
		player.drawTowLineFromLefttoRight(7, 5, map);
		player.drawTowLineFromLefttoRight(0, 0, map);
	}
	
	public void testLadder1() {
		assertEquals(6, obj.searchArray(1, map));
	}
	public void testLadder2() {
		assertEquals(4, obj.searchArray(2, map));
	}
	public void testLadder3() {
		assertEquals(5, obj.searchArray(3, map));
	}
	public void testLadder4() {
		assertEquals(1, obj.searchArray(4, map));
	}
	public void testLadder5() {
		assertEquals(2, obj.searchArray(5, map));
	}
	public void testLadder6() {
		assertEquals(3, obj.searchArray(6, map));
	}
	public void testLadder7() {
		assertEquals(-1, obj.searchArray(8, map));
	}
	public void testLadder8() {
		assertEquals(-1, obj.searchArray(-1, map));
	}
	
	
}
