package cleancode.day4.asis;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Order {

    private List<Item> items;
    private int totalPrice;

    public List<Item> getItems() {
        return items;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean validateOrder(Order order) {
        if (order.getItems().size() == 0) {
            log.info("주문 항목이 없습니다.");
            return false;
        } else {
            if (order.getTotalPrice() > 0) {
                if (!order.hasCustomerInfo()) {
                    log.info("사용자 정보가 없습니다.");
                    return false;
                } else {
                    return true;
                }
            } else if (!(order.getTotalPrice() > 0)) {
                log.info("올바르지 않은 총 가격입니다.");
                return false;
            }
        }
        return true;
    }

    private boolean hasCustomerInfo() {
        return false;
    }
}
