import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.*;
import java.lang.Object;

public class Test {
	public static void main(String[] args) {
		JapDic japdic = new JapDic();
		System.out.println(japdic.getEng("タ"));
        Tokenizer tokenizer = new Tokenizer() ;
        List<Token> tokens = tokenizer.tokenize("流派");
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
        	System.out.println(token.getReading());
        }
        String s = "リュウハ";
        for (int i = 0; i < s.length(); i++){
        	System.out.println(s.charAt(i));
        }

	}
}



