import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;


public class Deck {
	String[] nums = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "K", "Q", "J"};
	String[] suits = {"\u2665", "\u2666", "\u2663", "\u2660"};
	
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public Deck(){
		for(String suit:suits)
			for(String num:nums)
				cards.add(new Card(num, suit));
	}
	
	public void printCard(int i){
		System.out.println(cards.get(i).toString());
	}
	
	public void printAll(){
		System.out.print("Deck: ");
		if(cards.size()==0)
			System.out.println("<Empty Deck>");
		for(int i=0; i<cards.size(); i++){
			System.out.print(cards.get(i).toString());
			if(i==cards.size()-1)
				System.out.println();
			else
				System.out.print(", ");
		}
	}
	
	public void shuffle(){
		Random rnd = new Random();
	    for (int i = cards.size() - 1; i > 0; i--){
	      int index = rnd.nextInt(i + 1);
	      Card a = cards.get(index);
	      cards.set(index, cards.get(i));
	      cards.set(i, a);
	    }
	}
	
	public void transferCards(ArrayList<Card> thrown){
		for(Card c: thrown)
			this.cards.add(c);
	}
}
