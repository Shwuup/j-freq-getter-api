import java.util.ArrayList;
import java.util.Collections;

public class Pair implements Comparable{
	private String word;
	private int freq;
	
	public Pair(String w, int f) {
		word = w;
		freq = f;
	}
	
	public boolean equals(Pair other) {
		return this.getFreq() == other.getFreq();
	}
	
	public String toString() {
		return String.format("(%s, %d)", this.getWord(), this.getFreq());
	}
	
	@Override
	
	
	
	public int compareTo(Object temp) {
		Pair other = (Pair) temp;
		if(getFreq() > other.getFreq()) {
			return 1;
		}
		else if(getFreq() < other.getFreq()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	
	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getFreq() {
		return freq;
	}

	public void setFreq(int freq) {
		this.freq = freq;
	}
	
	public static void main(String[] args) {
		Pair p1 = new Pair("漢字", 4);
		Pair p2 = new Pair("合う", 9);
		
		System.out.println(p1.compareTo(p2));
		
		ArrayList<Pair> l = new ArrayList<Pair>();
		l.add(p2);
		l.add(p1);
		
		for (Pair p : l){
			System.out.println(p);
		}
		Collections.sort(l);
		for (Pair p : l){
			System.out.println(p);
		}
	}

	
	
}
