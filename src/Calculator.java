
public class Calculator {
	int num;
	
	Calculator(int num) {
		this.num = num;
	}
	
	int add(int operand) {
		return num+operand;
	}
	
	int muli(int operand) {
		return num*operand;
	}
	
	double divide(int operand) {
		if(operand == 0) {
			System.out.println("분모에 0을 입력하셨습니다!");
			return 0;
		}
		else return num/operand;
	}
	
	
	public static void main(String[] args) {
		Calculator cal = new Calculator(6);
		System.out.println("덧셈 : " + cal.add(2));
		System.out.println("곱셈 : " + cal.muli(4));
		System.out.println("나눗셈 : " + cal.divide(2));
		
	}

}
