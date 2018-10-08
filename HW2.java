import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author TODO: please add student ID and name here b0444237 �s�R�� 
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
	 * @param allCards �Ҧ����P
	 * @param nDeck    �`�@���X�ƵP
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
 * �ΰj�鲣�ͩҦ����P�A��iArrayList
 * �j��Ĥ@�h:�@���X�ƵPdeck
 * �j��ĤG�h:���t���suit
 * �j��ĤT�h:���t�I��rank
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
		
		// �`�@���X�ƵP�N����
		for (int i = 0; i < nDeck; i++) {
			// �������(1~4)
			for (int s = 1; s < 5; s++) {
				// �����I��(1~13)
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
		//�L�X�P���W�Ҧ����P
		System.out.println(cards);
	}

	public ArrayList<Card> getAllCards() {
		return cards;
	}
}

/**
 * Description: TODO: please add description here
 * suit�O���,rank�O�I�� �إ߳o����ݩ� �٦��غc�l
 * �ഫ�Ʀr�N�X�P���M�I�ƪ��^��W�r
 */
class Card {
	private int suit; // Definition: 1~4, Clubs=1, Diamonds=2, Hearts=3, Spades=4
	private int rank; // 1~13

	/**
	 * @param s suit���
	 * @param r rank�I��
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
		//�إߨ��String�ܼƨӦs�ഫ�᪺�^��W�r
		String sString="";//�s���
		String rString="";//�s�I��
		// ���Ӫ��,�Ʀr1~4���O���������,�P�_�O�X���A�s�JsString
		if (suit == 1) {
			sString = "Clubs";
		} else if (suit == 2) {
			sString = "Diamonds";
		} else if (suit == 3) {
			sString = "Hearts";
		} else if (suit == 4) {
			sString = "Spades";
		}
		// �����I��,1�B11�B12�B13�I���O���^��W�r�ҥH�n���ഫ�A�s�JrString
		if (rank == 1) {
			rString = "Ace";
		} else if (rank == 11) {
			rString = "Jack";
		} else if (rank == 12) {
			rString = "Queen";
		} else if (rank == 13) {
			rString = "King";
		} else {
			//��L�S���W�r���I�ƪ����ন��r���A
			rString = Integer.toString(rank);
		}
		// �L�X�P�������I��
		System.out.println(sString + "," + rString);

	}

	public int getSuit() {
		return suit;
	}

	public int getRank() {
		return rank;
	}
}
