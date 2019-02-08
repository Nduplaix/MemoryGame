package dut.archilog.intro;

public class GraphicalCell extends Cell {
    private CellJButton ui;

    public GraphicalCell(char content) {
        super(content);
        ui = new CellJButton(this);
        setVisible(false);
    }

    public CellJButton getUi(){
        return ui;
    }

    @Override
    public boolean isVisible(){
        return super.isVisible();
    }

    @Override
    public void setVisible(boolean visible){
        super.setVisible(visible);
        ui.setText(toString());
    }


    @Override
    public void pin(){
        ui.setEnabled(false);
    }
}
