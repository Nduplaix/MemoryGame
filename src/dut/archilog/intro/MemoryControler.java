package dut.archilog.intro;

import java.util.Iterator;

public class MemoryControler {
	
	public <C extends Cell> void control(Memory<C> memory,CharGenerator generator) {
		
		Iterator<C> it = generator.generate(memory).stream().map(memory::createCell).iterator();
		int stats = 0;
		memory.prepare(it);
		while (!memory.isStoppingCriterionMet()) {
			memory.selectFirstCard();
			memory.selectSecondCard();
			stats++;
			if (memory.areCardEquals()) {
				memory.displayTheTwoCards();
			} else {
				memory.hideTheTwoCards();
			}
		}
		if (memory.isWinner()) {
			memory.displayMessage("Congrats!, you won in "+stats+" steps !!!");
		} else {
			memory.displayMessage("You will certainly do better next time!");
		}
	}
}
