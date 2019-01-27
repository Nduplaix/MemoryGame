package dut.archilog.intro;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomCharGenerator implements CharGenerator {
    private static final Random RAND = new Random();

    @Override
    public List<Character> generate(Memory<? extends Cell> memory) {
        int nbPairs = memory.getNbPairs();
		List<Character> cards = new ArrayList<>();
		char current;
		for (int i = 0; i < nbPairs; i++) {
			current = (char) (RAND.nextInt(10) + 65);
			cards.add(current);
			cards.add(current);
		}
        Collections.shuffle(cards);
        return cards;
    }

}