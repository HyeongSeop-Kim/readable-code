package cleancode.minesweeper.tobe.cell;

public interface Cell {

    String FLAG_SIGN = "⚑";
    String UNCHECKED_SIGN = "□";

    abstract boolean isLandMine();

    abstract boolean hasLandMineCount();

    abstract String getSign();

    void flag();

    void open();

    boolean isChecked();

    boolean isOpened();
}
