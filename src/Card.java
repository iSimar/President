
public class Card {
	String num;
	String suit;
	public Card(String num, String suit){
		this.num = num;
		this.suit = suit;
	}
	
	public String toString(){
		return suit+num;
	}
	
	public String getNum(){
		return num;
		
	}
	
	public int getNumInt(){
		if(num.equals("A")){
			return 14;
		}
		else if(num.equals("2")){
			return 15;
		}
		else if(num.equals("J")){
			return 11;
		}
		else if(num.equals("Q")){
			return 12;
		}
		else if(num.equals("K")){
			return 13;
		}
		else{
			return Integer.parseInt(num);
		}
	}
	
	public boolean isSmallerThan(Card card){
		return this.getNumInt() < card.getNumInt();
	}
	
}
