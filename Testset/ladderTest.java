import junit.framework.TestCase;


public class LadderTest extends TestCase {
	LadderGameMaster obj;
	LadderMap map;
	
	
	protected void setUp() throws Exception {
		obj = new LadderGameMaster();
		map = new LadderMap(6, 10);
		
		map.makeRandomMap(100);
		
//		map.drawTwoLineFromLefttoRight(1, 1);
//		map.drawTwoLineFromLefttoRight(6, 1);
//		map.drawTwoLineFromLefttoRight(9, 1);
//		map.drawTwoLineFromLefttoRight(3, 2);
//		map.drawTwoLineFromLefttoRight(5, 2);
//		map.drawTwoLineFromLefttoRight(8, 2);
//		map.drawTwoLineFromLefttoRight(4, 3);
//		map.drawTwoLineFromLefttoRight(7, 3);
//		map.drawTwoLineFromLefttoRight(10, 3);
//		map.drawTwoLineFromLefttoRight(2, 4);
//		map.drawTwoLineFromLefttoRight(6, 4);
//		map.drawTwoLineFromLefttoRight(8, 4);
//		map.drawTwoLineFromLefttoRight(3, 5);
//		map.drawTwoLineFromLefttoRight(5, 5);
//		map.drawTwoLineFromLefttoRight(7, 5);
	}
	
	public void testLadder1() {
		assertEquals(6, obj.searchArray(1, map.getLadderObjectList(), map));
	}
//	public void testLadder2() {
//		assertEquals(4, obj.searchArray(2, map.getLadderObjectList(), map));
//	}
//	public void testLadder3() {
//		assertEquals(5, obj.searchArray(3, map.getLadderObjectList(), map));
//	}
//	public void testLadder4() {
//		assertEquals(1, obj.searchArray(4, map.getLadderObjectList(), map));
//	}
//	public void testLadder5() {
//		assertEquals(2, obj.searchArray(5, map.getLadderObjectList(), map));
//	}
//	public void testLadder6() {
//		assertEquals(3, obj.searchArray(6, map.getLadderObjectList(), map));
//	}
//	public void testLadder7() {
//		assertEquals(-1, obj.searchArray(8, map.getLadderObjectList(), map));
//	}
//	public void testLadder8() {
//		assertEquals(-1, obj.searchArray(-1, map.getLadderObjectList(), map));
//	}
	
	
}
