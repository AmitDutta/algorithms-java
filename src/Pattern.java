
public class Pattern {
	public static void print(char[] str, int index){
		if (index == str.length - 1){
			for (int i = 0; i < str.length; i++) System.out.print(str[i]);
			System.out.println();
			return;
		}
		if (str[index] == '?'){
			str[index] = '0';
			print(str, index + 1);
			str[index] = '1';
			print(str, index + 1);
		}else print(str, index + 1);
	}
	public static void generateAllPatterns(String s, int index)
    {
        while(index < s.length() && s.charAt(index) != '?')
            index++;
        if(index == s.length())
        {
            System.out.println(s);
            return;
        }
        StringBuilder s1 = new StringBuilder(s);
        s1.setCharAt(index, '0');
        generateAllPatterns(s1.toString(),index);
        s1.setCharAt(index, '1');
        generateAllPatterns(s1.toString(),index);
    }
	public static void main(String[] args){
		generateAllPatterns("1??0", 0);
	}
}
