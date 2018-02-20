package zad3;

public class Configurations {
	
	// player1 - player1, player2 - player2
	static Player checkWhoHasBetterConfiguration(Player player1, Player player2) {
		/* poker krolewski */
		if (isRoyalFlush(player1))
			return player1;
		else if (isRoyalFlush(player2)) 
			return player2;	
	
	
		/* poker */ 
		if (isStraightFlush(player1) && isStraightFlush(player2))
			return whoHighestCard(player1, player2);
		
		if (isStraightFlush(player1)) 
			return player1;
		else if (isStraightFlush(player2))
			return player2;
	
	
		/* kareta */
		if (isFOAK(player1) && isFOAK(player2)) 
			if (player1.getCardValue(2) > player2.getCardValue(2)) 
				return player1;
		
		if(isFOAK(player1)) 
			return player1;
		 else if (isFOAK(player2))
			return player2;
	
	
		/* full */
		if (isFull(player1) && isFull(player2)) 
			if (player1.getCardValue(2) > player2.getCardValue(2))
				return player1;
		
		if (isFull(player1)) 
			return player1;
		else if (isFull(player2))
			return player2;
	
	
		/* kolor */
		if (isFlush(player1) && isFlush(player2)) 
			return whoHighestCard(player1, player2);
		
		if(isFlush(player1)) 
			return player1;
		else if (isFlush(player2))
			return player2;
	
	
		/* strit */
		if (isStraight(player1) && isStraight(player2)) 
			return whoHighestCard(player1, player2);
		
		if (isStraight(player1)) 
			return player1;
		else if (isStraight(player2))
			return player2;
	
	
		/* trojka */
		if (isTOAK(player1) && isTOAK(player2)) 
			if (player1.getCardValue(2) > player2.getCardValue(2)) 
				return player1;
		
		if (isTOAK(player1)) 
			return player1;
		else if (isTOAK(player2))
			return player2;
		
		if(isSecondPair(player1)) 
			return player1;
		else if(isSecondPair(player2))
			return player2;
	
		/* 1 taka sama para */
		if (isPair(player1) && isPair(player2)) {
			int p1Index = pairIndex(player1, 0);
			int p2Index = pairIndex(player2, 0);
			if (player1.getCardValue(p1Index) > player2.getCardValue(p2Index)) 
				return player1;
			else 
				if (player1.getCardValue(p1Index) == player2.getCardValue(p2Index)) 
					return whoHighestCard(player1, player2);
			return player2;
		}
		
		if (isPair(player1)) 
			return player1;
		else if (isPair(player2)) 
			return player2;
	
		/* najwyzsza karta */
		return whoHighestCard(player1, player2);
	}

	static boolean isRoyalFlush(Player player) {
		return (isStraightFlush(player) && (player.getCardValue(0) == 14));
	}
	
	static boolean isStraightFlush(Player player) {
		return (isFlush(player) && isStraight(player));
	}
	
	static boolean isFOAK(Player player) {
		return ((player.getCardValue(0) == player.getCardValue(3)) ||
				(player.getCardValue(1) == player.getCardValue(4)));
	}
	
	static boolean isFull(Player player) {
		return (isTOAK(player) && isSecondPair(player));
	}
	
	static boolean isFlush(Player player) {
		boolean flush = true;
		for (int i = 0; i < player.getNumberOfCards() -1; i++) {
			if (player.getCardColor(i) != player.getCardColor(i+1))
				flush = false;
		}
		return flush;
	}
	
	static boolean isStraight(Player player) {
		return (((player.getCardValue(0) - player.getCardValue(4)) == 4) &&
				 !isPair(player) );
	}
	
	static Player whoHighestCard(Player player1, Player player2) {
		int i = 0;
		Player best = null;
		while (i < 5) {
			if (player1.getCardValue(i) > player2.getCardValue(i)) {
				best = player1;
				break;
			} else {
				if (player1.getCardValue(i) == player2.getCardValue(i)) {
					i++;
				} else {
					best = player2;
					break;
				}
			}
		}
		return best;
	}
	
	static boolean isTOAK(Player player) {
		return ((player.getCardValue(0) == player.getCardValue(2)) ||
				(player.getCardValue(2) == player.getCardValue(4) ||
				(player.getCardValue(1) == player.getCardValue(3))));
	}
	
	static int sumCardValues(Player player) {
		int sum = 0;
		for (int i = 0; i < player.getNumberOfCards(); i++) {
			sum += player.getCardValue(i);
		}
		return sum;
	}
    
	static int getSecondPairValue(Player player) {
		return player.getCardValue(secondPairIndex(player));
	}
	
	static int getFirstPairValue(Player player) {
		return player.getCardValue(firstPairIndex(player));
	}
	
	static boolean isPair(Player player) {
		return pairIndex(player, 0) != -1;
	}
	
	static boolean isSecondPair(Player player) {
	    return secondPairIndex(player) != -1;
	}
	
	static int firstPairIndex(Player player) {
		return pairIndex(player, 0);		
	}
	
	static int secondPairIndex(Player player) {
		 return firstPairIndex(player) != -1 ? pairIndex(player, firstPairIndex(player) + 1) : -1;
	}
	
	static int pairIndex(Player player, int start) {
		int index = -1;
		for (int i = start; i < player.getNumberOfCards() - 1; i++) {
			if (player.getCardValue(i) == player.getCardValue(i+1)) {
				index = i+1;
				break;
			}
		}
		return index;
	}
}
