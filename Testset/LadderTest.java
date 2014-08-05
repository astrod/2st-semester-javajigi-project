import junit.framework.TestCase;


public class LadderTest extends TestCase {
	LadderGameMaster obj;
	LadderMap map;
	
	protected void setUp() throws Exception {
		obj = new LadderGameMaster();
		map = new LadderMap(6, 10);
		
		map.makeRandomMap(1000);
		
//		map.setLine(1, 1);
//		map.setLine(6, 1);
//		map.setLine(9, 1);
//		map.setLine(3, 2);
//		map.setLine(5, 2);
//		map.setLine(8, 2);
//		map.setLine(4, 3);
//		map.setLine(7, 3);
//		map.setLine(10, 3);
//		map.setLine(2, 4);
//		map.setLine(6, 4);
//		map.setLine(8, 4);
//		map.setLine(3, 5);
//		map.setLine(5, 5);
//		map.setLine(7, 5);
	}
	
	public void testLadder1() {
		assertEquals(6, obj.searchArray(1, map));
	}
//	public void testLadder2() {
//		assertEquals(4, obj.searchArray(2, map));
//	}
//	public void testLadder3() {
//		assertEquals(5, obj.searchArray(3, map));
//	}
//	public void testLadder4() {
//		assertEquals(1, obj.searchArray(4, map));
//	}
//	public void testLadder5() {
//		assertEquals(2, obj.searchArray(5, map));
//	}
//	public void testLadder6() {
//		assertEquals(3, obj.searchArray(6, map));
//	}
//	public void testLadder7() {
//		assertEquals(-1, obj.searchArray(8, map));
//	}
//	public void testLadder8() {
//		assertEquals(-1, obj.searchArray(-1, map));
//	}
	
	
}