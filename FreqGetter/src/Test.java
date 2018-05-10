import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.*;
import java.lang.Object;

public class Test {
	public static void main(String[] args) {
		HashMap hm = new HashMap();
		hm.put("タ", "ta");
		hm.put("ベ", "be");
		hm.put("ル", "ru");
		
        Tokenizer tokenizer = new Tokenizer() ;
        List<Token> tokens = tokenizer.tokenize("お寿司が食べたい。　桃太郎");
        ArrayList<String> inval = new ArrayList<String>();
        inval.add("記号");
        inval.add("接頭詞");
        inval.add("助詞");
        inval.add("助動詞");
        ArrayList<String> val = new ArrayList<String>();
        String basewords = "";
        for (Token token : tokens) {
        	System.out.println(token);
        	boolean valid = inval.contains(token.getPartOfSpeechLevel1());
        	if (!valid) {
        		val.add(token.getBaseForm());
        		System.out.println(token.getBaseForm());
        		basewords+= token.getBaseForm();
        
        	}

		}
        System.out.println(basewords);
        List<Token> basetokens = tokenizer.tokenize(basewords);
        for (Token token : basetokens) {
        	System.out.print(token.getReading());
        }
        char kanji = '漢';
        System.out.println((int)kanji);
	}
}



