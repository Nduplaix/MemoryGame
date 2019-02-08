package dut.archilog.intro;

public class Game {
	public static void main(String[] args) {
		// Etape 1 :
		// 
		//Memory<Cell> memory = new TextualMemory(10, 10);
		//
		// Etape 2 :
		// 
		 Memory<GraphicalCell> memory = new GraphicalMemory(4, 4);
		//Memory<?> memory = new FakeMemory();
		MemoryControler controler = new MemoryControler();
		CharGenerator generator = new RandomCharGenerator();
		controler.control(memory,generator);
	}
}
