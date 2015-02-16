import java.util.ArrayList;


public class Hand {
	boolean isBot;
	ArrayList<Card> cards = new ArrayList<Card>();
	String playerName;
	
	public Hand(boolean isBot, String playerName){
		this.isBot = isBot;
		this.playerName = playerName;
	}
	
	public void give(Card card){
		this.cards.add(card);
	}
	
	public void printAll(){
		for(int i=0; i<cards.size(); i++){
			System.out.print(cards.get(i).toString());
			if(i==cards.size()-1)
				System.out.println();
			else
				System.out.print(", ");
		}
	}
	
	public String getPlayerName(){
		return this.playerName;
	}
}
