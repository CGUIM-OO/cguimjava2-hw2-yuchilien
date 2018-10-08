import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here b0444237 連昱棋 
 * Try to write some comments for your codes (methods, 15 points) 
 * 
 */
public class HW2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("input N (deck of cards):");
		String testn = sc.nextLine();

		int nDeck = Integer.parseInt(testn);
		Deck deck = new Deck(nDeck);
		// TODO: please check your output, make sure that you print all cards on your
		// screen (10 points)
		deck.printDeck();

		if (isAllCardsCorrect(deck.getAllCards(), nDeck)) {
			System.out.println("Well done!");
		} else {
			System.out.println("Error, please check your sourse code");
		}
	}

	/**
	 * This method is used for checking your result, not a part of your HW2
	 * 
	 * @param allCards 所有的牌
	 * @param nDeck    總共有幾副牌
	 * @return
	 */
	private static boolean isAllCardsCorrect(ArrayList<Card> allCards, int nDeck) {
		// check the output
		boolean isCorrect = true;
		;
		HashMap<String, Integer> checkHash = new HashMap<String, Integer>();
		for (Card card : allCards) {
			int suit = card.getSuit();
			int rank = card.getRank();
			if (suit > 4 || suit < 1 || rank > 13 || rank < 1) {
				isCorrect = false;
				break;
			}
			if (checkHash.containsKey(suit + "," + rank)) {
				checkHash.put(suit + "," + rank, checkHash.get(suit + "," + rank) + 1);
			} else {
				checkHash.put(suit + "," + rank, 1);
			}

		}
		if (checkHash.keySet().size() == 52) {
			for (int value : checkHash.values()) {
				if (value != nDeck) {
					isCorrect = false;
					break;
				}
			}
		} else {
			isCorrect = false;
		}
		return isCorrect;
	}

}

/**
 * Description: TODO: please add description here
 * 用迴圈產生所有的牌再放進ArrayList
 * 迴圈第一層:共有幾副牌deck
 * 迴圈第二層:分配花色suit
 * 迴圈第三層:分配點數rank
 */
class Deck {
	private ArrayList<Card> cards;

	// TODO: Please implement the constructor (30 points)
	public Deck(int nDeck) {
		cards = new ArrayList<Card>();
		// 1 Deck have 52 cards, https://en.wikipedia.org/wiki/Poker
		// Hint: Use new Card(x,y) and 3 for loops to add card into deck
		// Sample code start
		// Card card=new Card(1,1); ->means new card as clubs ace
		// cards.add(card);
		// Sample code end
		
		// 總共有幾副牌就產生
		for (int i = 0; i < nDeck; i++) {
			// 全部花色(1~4)
			for (int s = 1; s < 5; s++) {
				// 全部點數(1~13)
				for (int r = 1; r < 14; r++) {
					Card card = new Card(s, r);
					cards.add(card);
				}
			}

		}
	}

	// TODO: Please implement the method to print all cards on screen (10 points)
	public void printDeck() {
		// Hint: print all items in ArrayList<Card> cards,
		// TODO: please implement and reuse printCard method in Card class (5 points)
		//印出牌面上所有的牌
		System.out.println(cards);
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: TODO: please add description here
 * suit是花色,rank是點數 建立這兩個屬性 還有建構子
 * 轉換數字代碼與花色和點數的英文名字
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; // 1~13

	/**
	 * @param s suit花色
	 * @param r rank點數
	 */
	public Card(int s, int r) {
		suit = s;
		rank = r;
	}

	// TODO: 1. Please implement the printCard method (20 points, 10 for suit, 10
	// for rank)
	public void printCard() {
		// Hint: print (System.out.println) card as suit,rank, for example: print 1,1 as
		// Clubs Ace
		//建立兩個String變數來存轉換後的英文名字
		String sString="";//存花色
		String rString="";//存點數
		// 按照花色,數字1~4分別對應的花色,判斷是幾號再存入sString
		if (suit == 1) {
			sString = "Clubs";
		} else if (suit == 2) {
			sString = "Diamonds";
		} else if (suit == 3) {
			sString = "Hearts";
		} else if (suit == 4) {
			sString = "Spades";
		}
		// 按照點數,1、11、12、13點分別有英文名字所以要做轉換再存入rString
		if (rank == 1) {
			rString = "Ace";
		} else if (rank == 11) {
			rString = "Jack";
		} else if (rank == 12) {
			rString = "Queen";
		} else if (rank == 13) {
			rString = "King";
		} else {
			//其他沒有名字的點數直接轉成文字型態
			rString = Integer.toString(rank);
		}
		// 印出牌的花色及點數
		System.out.println(sString + "," + rString);

	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
