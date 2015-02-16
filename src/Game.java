import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	String input;
	Deck deck;
	ArrayList<Hand> hands;
	Hand player = new Hand(true, "Simar");
	
	public Game(){
		System.out.println("Press Enter to deal the cards..");
	    input = sc.nextLine();
	    while(true) {
	    	if(input.equals("")){
	    		deck = new Deck();
	    		hands = new ArrayList<Hand>();
	    		hands.add(new Hand(true, "Computer"));
	    		hands.add(player);
	    		deck.printAll();
	    		deck.shuffle();
	    		deck.printAll();
	    		
	    		showHands();
	    		handOutCards();
	    		showHands();
	    		deck.printAll();
	    	    break;
	    	}
	    	else
	    		input = sc.nextLine();
	    }
	}
	
	public void handOutCards(){
		int index = 0;
		while(deck.cards.get(deck.cards.size()-1)!=null){
			for(int i=0; i<hands.size(); i++){
				if(index>=52)
					break;
				Card card = deck.cards.get(index);
				hands.get(i).give(card);
				deck.cards.set(index, null);
				index++;
			}
		}
		deck.cards.clear();
	}
	
	public void showHands(){
		for(int i=0; i<hands.size(); i++){
			System.out.print(hands.get(i).getPlayerName()+"'s Hand : ");
			if(hands.get(i).cards.size()==0)
				System.out.println("<Empty Hand>");
			else
				hands.get(i).printAll();
		}
	}
}

