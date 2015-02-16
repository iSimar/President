
public class Card {
	String num;
	String suit;
	public Card(String num, String suit){
		this.num = num;
		this.suit = suit;
	}
	public String toString(){
		return this.suit+this.num;
//		System.out.println(" ___");
//		System.out.println("| "+suit+" |");
//		if(num.length()>1)
//			System.out.println("|"+num+" |");
//		else
//			System.out.println("| "+num+" |");
//		System.out.println(" \u00af\u00af\u00af");
		
	}
}
