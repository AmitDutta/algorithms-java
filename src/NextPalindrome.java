public class NextPalindrome {
	public static int NextPal(int number){
		String num = Integer.toString(number);
		int newNumber = 0;
		int middle = num.length()/2;
		if ((num.length() & 1) == 1){			
			String leftPart = num.substring(0, middle);
			String newString = leftPart + num.charAt(middle) + reverse(leftPart);
			newNumber = Integer.parseInt(newString);
			if (newNumber > number){
				
			}else{
				if (newString.charAt(middle) != '9'){
					// just add 1 at middle
					newNumber = newNumber + (int) Math.pow(10, leftPart.length());
					
				}else{
					// round up and call with the rounded up number
					return NextPal(round(number));
				}
			}
		}else{
			// even number
			String leftPart = num.substring(0, middle);
			String newString = leftPart + reverse(leftPart);
			newNumber = Integer.parseInt(newString);
			if (newNumber > number){
				
			}else{
				if (newString.charAt(middle) != '9'){
					newNumber = newNumber + (int) (11*Math.pow(10, leftPart.length() - 1));					
				}else{
					newNumber = NextPal(round(number));
				}
			}
		}
		return newNumber;
	}
	public static String reverse(String str){
		char[] chars = str.toCharArray();		
		for (int i = 0; i < chars.length/2; i++){
			char temp = chars[i];
			chars[i] = chars[chars.length-1-i];
			chars[chars.length-1-i] = temp;
		}
		return new String(chars);
	}
	public static int round(int number){		
		while (number % 10 != 0){
			number++;
		}
		return number;
	}
	public static void main(String[] args){
		System.out.println(NextPal(193));
		System.out.println(NextPal(1234));
		System.out.println(NextPal(4993));
		System.out.println(NextPal(1997));
	}
}
