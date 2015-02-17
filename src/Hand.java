import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


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
	
	public Card makeMove(Card top){
		if(!isBot){
			int cardIndex = this.askToMove();
			Card choosenCard = cards.get(cardIndex);
			if(top==null){
				cards.remove(cardIndex);
				return choosenCard;
			}
			while(!(top.isSmallerThan(choosenCard))){
				if(top.getNumInt() == choosenCard.getNumInt())
					break;
				System.out.println("Invalid pick, try again...");
				cardIndex = this.askToMove();
				choosenCard = cards.get(cardIndex);
			}
			cards.remove(cardIndex);
			return choosenCard;
		}
		return makeAIMove(top);
	}
	
	public Card makeAIMove(Card top){
		System.out.println("<Computer's Turn>");
		if(top != null)
			return this.makeOptimalChoiceAfter(top);
		return this.popLowestCard();
	}
	
	public Card popLowestCard(){
		Card card = null;
		int index = 0;
		int lowestCardIndex = 0;
		for(Card c:cards){
			if(card==null){
				card = c;
				lowestCardIndex = index;
			}
			else{
				if(c.isSmallerThan(card)){
					card = c;
					lowestCardIndex = index;
				}
			}
			index++;
		}
		if(card!=null)
			cards.remove(lowestCardIndex);
		return card;
	}
	
	public Card makeOptimalChoiceAfter(Card card){
		Card sameNumCard = this.popCardWithSameNum(card);
		if(sameNumCard!=null)
			return sameNumCard;
		return this.popLowestCardAfter(card);
	}
	
	public Card popCardWithSameNum(Card card){
		Card returnCard = null;
		for (int i = 0; i < cards.size(); i++) {
			if(cards.get(i).getNum().equals(card.getNum())){
				returnCard = cards.get(i);
				cards.remove(i);
				break;
			}
		}
		return returnCard;
	}
	
	public Card popLowestCardAfter(Card card){
		Card returnCard = null;
		int returnCardIndex = 0;
		for (int i = 0; i < cards.size(); i++) {
			if(card.isSmallerThan(cards.get(i))){
				if(returnCard==null){
					returnCard = cards.get(i);
					returnCardIndex = i;
				}
				else{
					if(cards.get(i).isSmallerThan(returnCard)){
						returnCard = cards.get(i);
						returnCardIndex = i;
					}
				}
			}
		}
		if(returnCard!=null)
			cards.remove(returnCardIndex);
		return returnCard;
	}
	
	public int askToMove(){
		System.out.println(playerName+"'s turn, please choose a card by index number:");
		for(int i=0; i<cards.size(); i++){
			System.out.print(cards.get(i).toString()+"["+i+"]");
			if(i==cards.size()-1)
				System.out.println();
			else
				System.out.print(", ");
		}
		Scanner sc = new Scanner(System.in);
		return sc.nextInt();
	}
	
	
}
