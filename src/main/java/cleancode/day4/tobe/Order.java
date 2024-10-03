package cleancode.day4.tobe;

import cleancode.day4.asis.Item;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Order {

    private final Items items;
    private final Customer customer;

    public Order(Items items, Customer customer) {
        this.items = items;
        this.customer = customer;
    }

    public boolean isItemsEmpty() {
        return items.isEmpty();
    }

    public boolean isTotalPriceNonPositive() {
        return items.calculateTotalPrice() <= 0;
    }

    public boolean hasNotCustomerInfo() {
        return customer.hasNotCustomerInfo();
    }

    public boolean validateOrder(Order order) {
        if (order.isItemsEmpty()) {
            log.info("주문 항목이 없습니다.");
            return false;
        }

        if (order.isTotalPriceNonPositive()) {
            log.info("올바르지 않은 총 가격입니다.");
            return false;
        }

        if (order.hasNotCustomerInfo()) {
            log.info("사용자 정보가 없습니다.");
            return false;
        }

        return true;
    }
}
