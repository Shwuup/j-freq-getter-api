import java.util.ArrayList;

public class Node {
	ArrayList children;
	String item;
	String word;
	int freq;
	ArrayList sameKanji;
	
	public Node(ArrayList newItem, String newWord, int freq) {
		this.children = newItem;
		this.word = newWord;
		this.freq = freq;
	}
	
}
