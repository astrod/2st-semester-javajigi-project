
public class String_calculator_other_method {
	
	static int add(String text) {
		if (text.isEmpty()) {
			return 0;
		}
		
		String [] values = split(text);
		int [] numbers = toInt(values);
		return sum(numbers);
		
	}
	
	static int sum(int [] numbers) {
		int sum = 0;
		for(int i =0; i<numbers.length; i++) {
			sum +=numbers[i];
			
		}
		return sum;
	}
	
	static int[] toInt(String[] values) {
		int [] numbers = new int[values.length];
		for(int i =0; i<values.length; i++) {
			numbers[i] = Integer.parseInt(values[i]);
		}
		return numbers;
	}
	
	static String[] split(String text) {
		return text.split(",|\n");
	}
	
	
	public static void main(String args[]) {
		String[] values = split("1,2");
		for(String a : values) {
			System.out.println(a);
		}
		values = split("3\n4,5");
		for(String a : values) {
			System.out.println(a);
		}
		
		int [] numbers = toInt(values);
		for(int a : numbers) {
			System.out.println(a);
		}
		int total = sum(numbers);
		System.out.println(total);
		
		System.out.println("sum :" + add("1,2\n3"));
	}
	
}
