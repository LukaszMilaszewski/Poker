package zad3;

import java.util.ArrayList;
import java.util.Collections;

public class Game {
	static int howManyPlayer1Wins(ArrayList<Integer> data) {
		int length = data.size()/20;
		int counter = 0;
		for (int i = 0; i < length; i++) {
		    Player player1 = new Player();
		    Player player2 = new Player();
			if(whoWinsRound(data, player1, player2) == player1)
				counter ++;
		}
		return counter;
	}
	
	static Player whoWinsRound (ArrayList<Integer> data, Player player1, Player player2) {
	    
		player1 = drawCards(player1, data);
		player2 = drawCards(player2, data);

		Collections.sort(player1.getCards(), Collections.reverseOrder());
		Collections.sort(player2.getCards(), Collections.reverseOrder());
		
		return Configurations.checkWhoHasBetterConfiguration(player1, player2);
	}

   static Player drawCards(Player player, ArrayList<Integer> data) {
   	int iter = 0;
		while(iter < 5) {
			Card card = new Card(data.get(0), data.get(1));
			player.addCard(card);
			data.remove(0);
			data.remove(0);
			iter++;
		}
		return player;
	}
}
