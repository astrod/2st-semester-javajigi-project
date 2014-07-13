
public class String_calculator_Junit {

	public static void main(String[] args) {
		
	}

	public String[] cut(String inputString) {
		
		String [] returnStringArray = new String[inputString.length()];
		returnStringArray = inputString.split(",|\n");
		
		return returnStringArray;
	}

	public int [] toInt(String[] stringArray) {
		if(stringArray == null) {
			return new int[]{};
		}
		
		int [] returnIntArray = new int[stringArray.length];
		
		for(int i =0; i<stringArray.length; i++) {
			returnIntArray[i] = Integer.parseInt(stringArray[i]);
		}
		
		return returnIntArray;
	}

	public int sum(int[] intArray) {
		int sum = 0;
		
		for(int i=0; i<intArray.length; i++) {
			sum += intArray[i];
		}
		return sum;
	}

	public int add(String inputString) {
		String [] stringArray = cut(inputString);
		int [] intArray = toInt(stringArray);
		int total = sum(intArray);
				
		return total;
	}

}
