package dut.archilog.intro;

import javax.swing.*;
import java.awt.*;

public class CellJButton extends JButton {
    private Cell cell;

    public CellJButton(Cell cell) {
        super(Character.toString(cell.getContent()));
        this.cell = cell;
        setPreferredSize(new Dimension(100,100));
        setMinimumSize(new Dimension(100,100));
    }

    public Cell getCell(){
        return cell;
    }
}
