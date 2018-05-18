import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.Object;

public class Test {
	public static void main(String[] args) {
		HashMap<String, Integer> dic = new HashMap<String, Integer>();
		Pair p1 = new Pair("漢字", 4);
		
		String fileName = "C:\\Users\\Ethan\\Documents\\GitHub\\j-vocab-freq-getter\\FreqGetter\\src\\test.txt";
        String line = null;
        String text = "";
        try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null) {
				text+=line;
				System.out.println(line);
			}
			
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        Tokenizer tokenizer = new Tokenizer() ;
        List<Token> tokens = tokenizer.tokenize(text);


        ArrayList<String> inval = new ArrayList<String>();
        inval.add("記号");
        inval.add("接頭詞");
        inval.add("助詞");
        inval.add("助動詞");
        ArrayList<String> val = new ArrayList<String>();
        String basewords = "";
        for (Token token : tokens) {
        	boolean invalid = inval.contains(token.getPartOfSpeechLevel1());
        	if (!invalid) {
        		System.out.println(token.getBaseForm());
        		if (dic.containsKey(token.getBaseForm())) {
        			dic.put(token.getBaseForm(), dic.get(token.getBaseForm())+ 1);
        		}
        		else {
        			dic.put(token.getBaseForm(), 1);
        		}
        		
        	}

		}
        ArrayList<Pair> freqlist = new ArrayList<Pair>();
        
        Iterator<String> codeIterator = dic.keySet().iterator();
        for (Map.Entry<String, Integer> pair : dic.entrySet()) {
        	System.out.println(pair.getKey() + " : " + pair.getValue());
        	freqlist.add(new Pair(pair.getKey(), pair.getValue()));
        }
        Collections.sort(freqlist);
        for (Pair p : freqlist) {
        	System.out.println(p);
        }
	}
}



