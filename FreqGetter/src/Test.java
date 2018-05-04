import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.*;


public class Test {
	public static void main(String[] args) {
        Tokenizer tokenizer = new Tokenizer() ;
        List<Token> tokens = tokenizer.tokenize("お寿司が食べたい。");
        ArrayList<String> inval = new ArrayList<String>();
        inval.add("記号");
        inval.add("接頭詞");
        inval.add("助詞");
        inval.add("助動詞");
        ArrayList<String> val = new ArrayList<String>();
        
        for (Token token : tokens) {
        	boolean valid = inval.contains(token.getPartOfSpeechLevel1());
        	if (!valid) {
        		val.add(token.getBaseForm());
        		System.out.println(token.getBaseForm() + "\t" + token.getPartOfSpeechLevel1());
        	}

		}
        
	}
}



