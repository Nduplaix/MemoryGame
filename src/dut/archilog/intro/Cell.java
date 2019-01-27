package dut.archilog.intro;

/**
 * A cell displays some content, depending of its state 
 * (visible or not).
 * 
 * @author leberre
 *
 */
public class Cell {
	private final char content;
	private boolean visible = false;

	public Cell(char content) {
		this.content = content;
	}

	public char getContent() {
		return content;
	}

	public boolean isVisible() {
		return visible;
	}

	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	public void pin() {
		// do nothing by default
	}
	
	@Override
	public String toString() {
		if (visible) {
			return Character.toString(content);
		}
		return "?";
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof Cell) {
			return ((Cell) o).content == content;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Character.hashCode(content);
	}
}