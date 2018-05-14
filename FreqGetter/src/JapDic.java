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
		 this.dic.put("ン", "n");
		 
		 this.dic.put("ハ", "ha");
		 this.dic.put("ヒ", "hi");
		 this.dic.put("フ", "fu");
		 this.dic.put("ヘ", "he");
		 this.dic.put("ホ", "ho");
		 
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
		 this.dic.put("ヲ", "wo");
		 
		 this.dic.put("カ", "ga");
		 this.dic.put("ギ", "gi");
		 this.dic.put("グ", "gu");
		 this.dic.put("ゲ", "ge");
		 this.dic.put("ゴ", "go");
		 
		 this.dic.put("ザ", "za");
		 this.dic.put("ズ", "zu");
		 this.dic.put("ゼ", "ze");
		 this.dic.put("ゾ", "zo");
		 this.dic.put("ジ", "ji");
		 
		 this.dic.put("ダ", "da");
		 this.dic.put("デ", "de");
		 this.dic.put("ド", "do");
		 
		 this.dic.put("バ", "ba");
		 this.dic.put("ビ", "bi");
		 this.dic.put("ブ", "bu");
		 this.dic.put("ベ", "be");
		 this.dic.put("ボ", "bo");
		 
		 this.dic.put("パ", "pa");
		 this.dic.put("ピ", "pi");
		 this.dic.put("プ", "pu");
		 this.dic.put("ペ", "pe");
		 this.dic.put("ポ", "po");
		 
		 this.dic.put("キャ", "kya");
		 this.dic.put("キュ", "kyu");
		 this.dic.put("キョ", "kyo");
		 
		 this.dic.put("ヒャ", "hya");
		 this.dic.put("ヒュ", "hyu");
		 this.dic.put("ヒョ", "hyo");
		 
		 this.dic.put("ジャ", "jya");
		 this.dic.put("ジュ", "jyu");
		 this.dic.put("ジョ", "jyo");
		 
		 this.dic.put("シャ", "sha");
		 this.dic.put("シュ", "shu");
		 this.dic.put("ショ", "sho");
		 
		 this.dic.put("ミャ", "mya");
		 this.dic.put("ミュ", "myu");
		 this.dic.put("ミョ", "myo");
		 
		 this.dic.put("チャ", "cha");
		 this.dic.put("チュ", "chu");
		 this.dic.put("チョ", "cho");
		 
		 this.dic.put("リャ", "rya");
		 this.dic.put("リュ", "ryu");
		 this.dic.put("リョ", "ryo");
		 
		 this.dic.put("ビャ", "bya");
		 this.dic.put("ビュ", "byu");
		 this.dic.put("ビョ", "byo");
		 
		 this.dic.put("ニャ", "nya");
		 this.dic.put("ニュ", "nyu");
		 this.dic.put("ニョ", "nyo");
		 
		 this.dic.put("ギャ", "gya");
		 this.dic.put("ギュ", "gyu");
		 this.dic.put("ギョ", "gyo");
		 
		 this.dic.put("ピャ", "pya");
		 this.dic.put("ピュ", "pyu");
		 this.dic.put("ピョ", "pyo");
		 
	}
	
	public String getEng(String s) {
		return (String) this.dic.get(s);
	}
	
}

