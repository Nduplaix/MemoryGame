package dut.archilog.intro;

import java.util.Iterator;

/**
 * Basic abstraction for a memory view.
 * 
 * @author leberre
 *
 */
public interface Memory<C extends Cell> {

	/**
	 * Create a Cell to be used in the view.
	 * 
	 * @param content the character to display
	 * @return a Cell representing the specific character
	 */
	C createCell(char content);
	
	/**
	 * Return the number of pairs to generate for the view.
	 * 
	 * @return
	 */
	int getNbPairs();
	
	/**
	 * Provide the cells to the view.
	 * 
	 * There should be exactly twice {@link #getNbPairs()} Cells.
	 * 
	 * @param it an iterator of Cells, making sure that each char appears twice.
	 */
	void prepare(Iterator<C> it);
	
	/**
	 * Select the first card on the view.
	 */
	void selectFirstCard();
	
	/**
	 * Select the second card on the view.
	 */
	void selectSecondCard();
	
	/**
	 * Check if the two selected cards are equal.
	 * 
	 * @return true if the selected cards are equal.
	 */
	boolean areCardEquals();
	
	/**
	 * Make sure that the two selected card will be displayed
	 * in the future.
	 * 
	 * It is expected that the selected cards represent the same character.
	 */
	void displayTheTwoCards();
	
	/**
	 * Hide the content of the two selected cells.
	 */
	void hideTheTwoCards();
	
	/**
	 * Check if the game is over.
	 * 
	 * By default, the game should end when all the pairs have been found.
	 * Another possibility would be to end the game after a given number of trials.
	 * 
	 * @return true if the game is over.
	 */
	boolean isStoppingCriterionMet();
	
	/**
	 * Check if the player has won.
	 * 
	 * @return true if the player has won the game.
	 */
	boolean isWinner();
	
	/**
	 * Display a message to the player.
	 * 
	 * @param message the message to display
	 */
	void displayMessage(String message);
}
