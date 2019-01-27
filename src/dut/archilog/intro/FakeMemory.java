package dut.archilog.intro;

import java.util.Iterator;

public class FakeMemory implements Memory<Cell> {

	@Override
	public Cell createCell(char content) {
		return new Cell(content);
	}

	@Override
	public int getNbPairs() {
		return 10;
	}

	@Override
	public void prepare(Iterator<Cell> it) {
		System.err.println("This is a fake game !");
	}

	@Override
	public void selectFirstCard() {
	}

	@Override
	public void selectSecondCard() {
	}

	@Override
	public boolean areCardEquals() {
		return false;
	}

	@Override
	public void displayTheTwoCards() {
	}

	@Override
	public void hideTheTwoCards() {
	}

	@Override
	public boolean isStoppingCriterionMet() {
		return true;
	}

	@Override
	public boolean isWinner() {
		return false;
	}

	@Override
	public void displayMessage(String message) {
	}
}
