public class Base62Encode {
	// why base 62 encode? simple.. 26 uppers, 26 lowers, 10 digits 26*2 + 10
	private static final char[] symbols = {
		'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o',
		'p','q','r','s','t','u','v','w','x','y','z','1','2','3','4',
		'5','6','7','8','9','0','A','B','C','D','E','F','G','H','I',
		'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
		'Y','Z'
	};
	public static String getShortenString(int number, int base){
		StringBuffer buffer = new StringBuffer();
		while (number > 0){
			buffer.append(symbols[number % base]);
			number /= base;
		}
		return buffer.reverse().toString();
	}
	public static int getNumber(String str, int base){
		int k = 0, sum = 0;
		for (int i = str.length() - 1; i >= 0; i--){
			sum += getIndex(str.charAt(i)) * Math.pow(base, k++);
		}
		return sum;
	}
	private static int getIndex(char ch){
		int index = 0;
		if (ch >= 'a' && ch <= 'z'){
			index = (int) ch - 97;
		}else if (ch >= '0' && ch <= '9'){
			index = 26 + ((int) ch - 48);
		}else{
			// an uppercase char
			index = 36 + ((int) ch - 65);
		}
		return index;
	}
	public static void main(String[] args){
		String str = getShortenString(678544326, 62);
		int num = getNumber(str, 62);
		System.out.println(str + ", " + num);
		/*for (char ch = 'a'; ch <= 'z'; ch ++){
			System.out.println(getIndex(ch));
		}
		for (char ch = '0'; ch <= '9'; ch ++){
			System.out.println(getIndex(ch));
		}
		for (char ch = 'A'; ch <= 'Z'; ch ++){
			System.out.println(getIndex(ch));
		}*/
		/*int num = 12034;
		int sum = 0;
		while (num > 0){
			sum = sum * 10 + (num % 10);
			num /= 10;
		}
		System.out.println(sum);*/
	}
}
