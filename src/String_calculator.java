
public class String_calculator {
	String inputArray;
	
	public String_calculator(String inputString) {
		inputArray = inputString;
	}
	
	
	float calculating() {
		float returnValue = 0;
		String [] returnArray;
		float [] finalArray;
		
		if(inputArray.isEmpty()) {
			return 0;
		}
		
		returnArray = inputArray.split("[,\n]");
		
		finalArray = isFloat(returnArray);		
		returnValue = sumArray(finalArray);
		
		return returnValue;
	}
	
	float [] isFloat(String [] array) {
		float returnArray[] = new float[array.length];
		
		for(int i=0; i<array.length; i++) {
			returnArray[i] += Float.parseFloat(array[i]);
		}
		
		return returnArray;
	}
	
	float sumArray(float [] array) {
		float sum = 0;
		
		for(int i =0; i<array.length; i++) {
			sum += array[i];
		}
		
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String_calculator obj = new String_calculator("1,2,3\n4\n5\n6");
		System.out.println(obj.calculating());
				
	}

}
