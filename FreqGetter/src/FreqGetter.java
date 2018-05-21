import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.atilika.kuromoji.ipadic.Token;
import com.atilika.kuromoji.ipadic.Tokenizer;

public class FreqGetter {
	public String readFile(String fileName) {
	    String line = null;
	    String text = "";
	    
	    try {
			FileReader fileReader = new FileReader(fileName);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			while((line = bufferedReader.readLine()) != null) {
				text+=line;
			}		
			bufferedReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return text;
	}
	
	public boolean isInteger(String i) {
		try {
			Integer.parseInt(i);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	public void run(){
		//Add kth sorting
		
		HashMap<String, Integer> dic = new HashMap<String, Integer>();
		Pair p1 = new Pair("漢字", 4);
		
		String fileName = "C:\\Users\\Ethan\\Documents\\GitHub\\j-vocab-freq-getter\\FreqGetter\\src\\test.txt";
		String text = readFile(fileName);
	    Tokenizer tokenizer = new Tokenizer() ;
	    List<Token> tokens = tokenizer.tokenize(text);
	   
	    ArrayList<String> inval = new ArrayList<String>();
	    inval.add("記号");
	    inval.add("接頭詞");
	    inval.add("助詞");
	    inval.add("助動詞");
	    inval.add("感動詞");
	    inval.add("の");
	    inval.add("ん");
	    ArrayList<String> val = new ArrayList<String>();
	    String basewords = "";
	    for (Token token : tokens) {
	    	boolean invalid = inval.contains(token.getPartOfSpeechLevel1()) || inval.contains(token.getBaseForm());
	    	if (!invalid) {
	    		if (!(token.getBaseForm().equals("*") || isInteger(token.getBaseForm()))) {
	        		if (dic.containsKey(token.getBaseForm())) {
	        			dic.put(token.getBaseForm(), dic.get(token.getBaseForm())+ 1);
	        		}
	        		else {
	        			dic.put(token.getBaseForm(), 1);
	        		}
	    		}
	    		
	    	}
	
		}
	    ArrayList<Pair> freqlist = new ArrayList<Pair>();
	    
	    Iterator<String> codeIterator = dic.keySet().iterator();
	    for (Map.Entry<String, Integer> pair : dic.entrySet()) {
	    	freqlist.add(new Pair(pair.getKey(), pair.getValue()));
	    }
	    
	    Collections.sort(freqlist);
	    for (Pair p : freqlist) {
	    	System.out.println(p);
	    }
	}

}
