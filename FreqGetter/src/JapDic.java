import java.util.HashMap;

public class JapDic {
	private HashMap dic;
	public JapDic(){
		 dic = new HashMap<String, String>();
		 this.dic.put("ア", "a");
		 this.dic.put("イ", "i");
		 this.dic.put("ウ", "u");
		 this.dic.put("エ", "e");
		 this.dic.put("オ", "o");
		 this.dic.put("カ", "ka");
		 this.dic.put("キ", "ki");
		 this.dic.put("ク", "ku");
		 this.dic.put("ケ", "ke");
		 this.dic.put("コ", "ko");
		 this.dic.put("サ", "sa");
		 this.dic.put("シ", "shi");
		 this.dic.put("ス", "su");
		 this.dic.put("セ", "se");
		 this.dic.put("ソ", "so");
		 this.dic.put("タ", "ta");
		 this.dic.put("チ", "chi");
		 this.dic.put("ツ", "tsu");
		 this.dic.put("テ", "te");
		 this.dic.put("ト", "to");
		 this.dic.put("ナ", "na");
		 this.dic.put("ニ", "ni");
		 this.dic.put("ヌ", "nu");
		 this.dic.put("ネ", "ne");
		 this.dic.put("ノ", "no");
		 this.dic.put("マ", "ma");
		 this.dic.put("ミ", "mi");
		 this.dic.put("ム", "mu");
		 this.dic.put("メ", "me");
		 this.dic.put("モ", "mo");
		 this.dic.put("ヤ", "ya");
		 this.dic.put("ユ", "yu");
		 this.dic.put("ヨ", "yo");
		 this.dic.put("ラ", "ra");
		 this.dic.put("リ", "ri");
		 this.dic.put("ル", "ru");
		 this.dic.put("レ", "re");
		 this.dic.put("ロ", "ro");
		 this.dic.put("ワ", "wa");
		 this.dic.put("ン", "n");
		 this.dic.put("ヲ", "wo");
		 
	}
	
	public String getEng(String s) {
		return (String) this.dic.get(s);
	}
	
}

