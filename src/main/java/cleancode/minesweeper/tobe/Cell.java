package cleancode.minesweeper.tobe;

public class Cell {

    private static final String FLAG_SIGN = "⚑";
    private static final String LAND_MINE_SIGN = "☼";
    private static final String UNCHECKED_SIGN = "□";
    private static final String EMPTY_SIGN = "■";

    private int nearByLandMineCounts;
    private boolean isLandMine;
    private boolean isFlagged;
    private boolean isOpened;

    private Cell(int nearByLandMineCounts, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        this.nearByLandMineCounts = nearByLandMineCounts;
        this.isLandMine = isLandMine;
        this.isFlagged = isFlagged;
        this.isOpened = isOpened;
    }

    public static Cell of(int nearByLandMineCounts, boolean isLandMine, boolean isFlagged, boolean isOpened) {
        return new Cell(nearByLandMineCounts, isLandMine, isFlagged, isOpened);
    }

    public static Cell create() {
        return of(0, false, false, false);
    }
    public void turnOnLandMine() {
        this.isLandMine = true;
    }

    public void updateNearByLandMineCount(int count) {
        this.nearByLandMineCounts = count;
    }

    public void flag() {
        this.isFlagged = true;
    }

    public void open() {
        this.isOpened = true;
    }

    public boolean isChecked() {
        return isFlagged || isOpened;
    }

    public boolean isLandMine() {
        return isLandMine;
    }

    public boolean isOpened() {
        return isOpened;
    }

    public boolean hasLandMineCount() {
        return this.nearByLandMineCounts != 0;
    }

    public String getSign() {
        if (isOpened) {
            if(isLandMine) {
                return LAND_MINE_SIGN;
            }
            if (hasLandMineCount()) {
                return String.valueOf(nearByLandMineCounts);
            }
            return EMPTY_SIGN;
        }

        if (isFlagged) {
            return FLAG_SIGN;
        }

        return UNCHECKED_SIGN;
    }
}
