import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*A spellchecker based on http://norvig.com/spell-correct.html. Dictionary: http://norvig.com/big.txt*/
public class SpellChecker {
	private Map<String, Integer> nwords = new HashMap<String, Integer>();
	public SpellChecker(String filePath) throws IOException{
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		Pattern p = Pattern.compile("\\w+");
		String line = "";
		while ((line = br.readLine()) != null){
			Matcher m = p.matcher(line.toLowerCase());
			while (m.find()){
				String word = m.group();
				if (nwords.containsKey(word)) nwords.put(word, nwords.get(word) + 1);
				else nwords.put(word, 1);
			}
		}
		br.close();
	}
	public List<String> Edits1(String word){
		List<String> words = new ArrayList<String>();
		//deletes
		for (int i = 0; i < word.length(); i++) words.add(word.substring(0, i) + word.substring(i + 1));
		//adds
		for (int i = 0; i < word.length(); i++){
			for (char ch = 'a'; ch <= 'z'; ch++){
				words.add(word.substring(0, i) + ch + word.substring(i));
			}
		}
		//exchanges
		for (int i = 0; i < word.length(); i++){
			for (char ch = 'a'; ch <= 'z'; ch++){
				words.add(word.substring(0, i) + ch + word.substring(i + 1));
			}
		}
		//transposes
		for (int i = 0; i < word.length() -1; i++){
			words.add(word.substring(0, i) + word.substring(i + 1, i + 2) + word.substring(i, i + 1) + word.substring(i + 2));
		}
		return words;
	}
	public List<String> Edits2(String word){
		List<String> edits2 = new ArrayList<String>();
		List<String> edits1 = Edits1(word);		
		for (String e1 : edits1) edits2.addAll(Edits1(e1));
		return edits2;
	}
	public String correct(String word){
		if(nwords.containsKey(word)) return word;
		Map<Integer, String> candidates = new HashMap<Integer, String>();
		List<String> words = Edits1(word);
		for(String w : words){
			if (nwords.containsKey(w)){
				candidates.put(nwords.get(w), w);
			}
		}
		if (candidates.size() > 0){
			return candidates.get(Collections.max(candidates.keySet()));
		}
		// try with words with distance 2
		for (String w : words){
			for (String w2 : Edits1(w)){
				if (nwords.containsKey(w2)){
					candidates.put(nwords.get(w2), w2);
				}
			}
		}
		return candidates.size() > 0 ? candidates.get(Collections.max(candidates.keySet())) : word;
	}
	public static void main(String[] args){
		try {
			SpellChecker checker = new SpellChecker(args[0]);
			System.out.println(checker.correct("generataed"));
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
}
