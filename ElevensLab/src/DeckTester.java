
/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		
		String[] ranks1 = {"1", "2", "3"};
		String[] ranks2 = {"1", "2", "3", "4", "5"};
		String[] suits1 = {"Spade"};
		String[] suits2 = {"Spade", "Heart"};
		int[] values1 = {1, 2, 3};
		int[] values2 = {1, 2, 3, 4, 5};
		
		Deck deck1 = new Deck(ranks1, suits1, values1);
		Deck deck2 = new Deck(ranks1, suits2, values1);
		Deck deck3 = new Deck(ranks2, suits2, values2);
		
		System.out.println("deck1 : "+deck1);
		System.out.println("deck1 : "+deck2);
		System.out.println("deck1 : "+deck3);
		
		System.out.println("deck1 size " + deck1.size());
		System.out.println("deck1 is empty? " +deck1.isEmpty() );
		System.out.println("dealing: " + deck1.deal());
		System.out.println("dealing: " + deck1.deal());
		System.out.println("dealing: " + deck1.deal());
		System.out.println("deck1 is empty? "+ deck1.isEmpty());
		System.out.println("dealing: " + deck1.deal());
		System.out.println("deck 1: "+deck1);
	}
}








