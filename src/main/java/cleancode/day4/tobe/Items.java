package cleancode.day4.tobe;

import java.util.List;

public class Items {
    private final List<Item> items;

    public Items(List<Item> items) {
        this.items = items;
    }

    public int calculateTotalPrice() {
        return items.stream().mapToInt(Item::getPrice).sum();
    }

    public boolean isTotalPriceNonPositive() {
        return calculateTotalPrice() <= 0;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }
}
