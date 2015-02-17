import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	String input;
	Deck deck;
	ArrayList<Hand> hands;
	Hand player = new Hand(false, "Simar");
	int winner = -1;
	ArrayList<Card> thrown= new ArrayList<Card>();
	
	public Game(){
		System.out.println("Press Enter to deal the cards and start");
	    input = sc.nextLine();
	    while(true) {
	    	if(input.equals("")){
	    		deck = new Deck();
	    		hands = new ArrayList<Hand>();
	    		hands.add(new Hand(true, "Computer"));
	    		hands.add(player);
//	    		deck.printAll();
	    		deck.shuffle();
//	    		deck.printAll();
	    		
//	    		showHands();
	    		handOutCards();
//	    		showHands();
//	    		player.askToMove();
//	    		deck.printAll();
	    		Random rnd = new Random();
	    		start(rnd.nextInt(hands.size()));
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
	
	public void showThrown(){
		System.out.print("Thrown: ");
		if(thrown.size()==0)
			System.out.print("<Nothing>");
		for(int i=0; i<thrown.size(); i++){
			System.out.print(thrown.get(i).toString());
			if(i!=thrown.size()-1)
				System.out.print(", ");
		}
		System.out.println();
	}
	
	public void start(int startingHand){
		showThrown();
		int handIndex = startingHand;
		while(winner==-1){
			boolean isBurn = false;
			Hand currentHand = hands.get(handIndex);
			Card lastThrownCard = null;
			if(thrown.size()>0)
				lastThrownCard = thrown.get(thrown.size()-1);
			Card choosenCard = currentHand.makeMove(lastThrownCard);
			if(currentHand.cards.isEmpty())
				winner = handIndex;
			if(lastThrownCard!=null){
				if(choosenCard.getNumInt()==lastThrownCard.getNumInt()){
					System.out.println("BURN! YOU GO AGAIN.");
					isBurn=true;
					deck.transferCards(thrown);
					thrown.clear();
				}
				else{
					thrown.add(choosenCard);
				}
			}
			else{
				thrown.add(choosenCard);
			}
			if(!isBurn){
				handIndex++;
				if(handIndex>=hands.size())
					handIndex = 0;
			}
			showThrown();
		}
	}
	
	
}

