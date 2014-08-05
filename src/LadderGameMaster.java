/* LadderGameMaster는 게임을 총괄하는 클래스이다. 이 클래스에서는 맵의 정보를 가지고, 어떤 점에서 출발했을 때 목적지에 도달하면 어디인가 같은
 * 계산을 하게 된다.
 */
public class LadderGameMaster {
	int endPos;
		
	/*
	 * 시작 위치를 찾는 역할을 한다. 각각의 map 객체를 감싸고 있는 클래스인 LadderMap에게 Msg를 날려서 시작 지점을 찾으라는 이야기를 한다.
	 * 이야기를 들은 LadderMap은 자신의 ArrayList를 돌면서 각각의 객체들에게 입력한 startNum과 같은 숫자가 있으면 그곳의 위치를 return하라는 
	 * 이야기를 하게 된다.
	 */
	public int searchArray(int startNum, LadderMap map) {
		//만약에 잘못된 값이 들어오면 -1을 리턴한다.
		if(startNum > map.getPlayerNum() || startNum < 1) {
			return -1;
		}
		goPath(map.searchEqualNum(startNum), 1, map);
		return endPos;
	}

	/* 사다리를 타고 내려오는 역할을 하는 함수이다. 사다리를 시각화해주는 drawMap을 호출하면서, 각각의 세로 줄 객체에 내려가면서 탐색하라는 명령을
	 * 전달한다.
	 */
	public void goPath(LadderCol startObject, int startIdx, LadderMap map) {
		map.drawMap(startObject, startIdx);
		startObject.goAhead(startIdx, this, map);
	}
	
}
