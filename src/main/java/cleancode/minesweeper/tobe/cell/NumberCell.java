package cleancode.minesweeper.tobe.cell;

public class NumberCell extends Cell {

    private final int nearByLandMineCounts;

    public NumberCell(int nearByLandMineCounts) {
        this.nearByLandMineCounts = nearByLandMineCounts;
    }

    @Override
    public boolean isLandMine() {
        return false;
    }

    @Override
    public boolean hasLandMineCount() {
        return true;
    }

    @Override
    public String getSign() {
        if (isOpened) {
            return String.valueOf(nearByLandMineCounts);
        }
        if (isFlagged) {
            return FLAG_SIGN;
        }
        return UNCHECKED_SIGN;
    }
}
