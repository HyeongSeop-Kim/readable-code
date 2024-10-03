package cleancode.day4.tobe;

import cleancode.day4.asis.Customer;
import cleancode.day4.asis.CustomerInfo;
import cleancode.day4.asis.Item;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class Order {

    private List<Item> items;
    private Customer customer;

    public Order(List<Item> items, Customer customer) {
        this.items = items;
        this.customer = customer;
    }

    public List<Item> getItems() {
        return items;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getTotalPrice() {
        return items.stream()
                .mapToInt(item -> getTotalPrice())
                .sum();
    }

    public boolean validateOrder(Order order) {
        if (order.getItems().isEmpty()) {
            log.info("주문 항목이 없습니다.");
            return false;
        }

        if (order.getTotalPrice() <= 0) {
            log.info("올바르지 않은 총 가격입니다.");
            return false;
        }

        if (!order.getCustomer().hasCustomerInfo()) {
            log.info("사용자 정보가 없습니다.");
            return false;
        }

        return true;
    }
}
